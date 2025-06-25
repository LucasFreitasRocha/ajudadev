package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.City;
import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.HandlerException;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.out.CityGateway;
import dev.ajuda.monolito.core.gateway.out.CommunityDatabaseGateway;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.core.validator.RegisterCommunityValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static dev.ajuda.monolito.core.exception.model.FieldsMessageError.CITY_NOT_FOUND;
import static dev.ajuda.monolito.core.exception.model.FieldsMessageError.USER_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ExtendWith(MockitoExtension.class)
@DisplayName("registerCommunityUseCase Tests")
class RegisterCommunityUseCaseTest {

    public static final String OWNER_ID = "ownerId";
    public static final long CITY_ID = 1L;
    @Mock
    private UserGateway userGateway;
    @Mock
    private CityGateway cityGateway;
    @Mock
    private CommunityDatabaseGateway communityDatabaseGateway;
    @Mock
    private RegisterCommunityValidator registerCommunityValidator;

    @Spy
    private HandlerErrorService handlerErrorService;

    @InjectMocks
    private RegisterCommunityUseCase registerCommunityUseCase;



    @Test
    @DisplayName("Should register a community successfully")
    void shouldRegisterCommunitySuccessfully() {
        var communityDomain = CommunityDomain.builder()
                .name("Valid Community")
                .description("This is a valid community description.")
                .owner(UserDomain.builder().id("ownerId").build())
                .city(City.builder().id(1L).build())
                .build();

        when(userGateway.findById(OWNER_ID)).thenReturn(communityDomain.getOwner());
        when(cityGateway.findById(CITY_ID)).thenReturn(communityDomain.getCity());
        when(communityDatabaseGateway.register(communityDomain)).thenReturn(communityDomain);
        registerCommunityUseCase.register(communityDomain);
        verify(registerCommunityValidator).validate(communityDomain);
        verifyNoInteractions(handlerErrorService);
    }

    @Test
    @DisplayName("Should throw an error when the owner is not found")
    void shouldThrowErrorWhenOwnerNotFound() {
        var communityDomain = CommunityDomain.builder()
                .name("Community without owner")
                .description("This community has no owner.")
                .owner(UserDomain.builder().id(OWNER_ID).build())
                .city(City.builder().id(CITY_ID).build())
                .build();

        when(userGateway.findById(OWNER_ID)).thenReturn(null);
        HandlerException exception = assertThrows(HandlerException.class, () ->
            registerCommunityUseCase.register(communityDomain)
        );

        assertEquals(NOT_FOUND, exception.getHandlerErrorModel().getStatus());
        assertEquals(USER_NOT_FOUND.getField(), exception.getHandlerErrorModel().getErrors().get(0).getField());
        assertEquals(USER_NOT_FOUND.getMessage(), exception.getHandlerErrorModel().getErrors().get(0).getMessage());
    }

    @Test
    @DisplayName("Should throw an error when the city is not found")
    void shouldThrowErrorWhenCityNotFound() {
        var communityDomain = CommunityDomain.builder()
                .name("Community without city")
                .description("not found city.")
                .owner(UserDomain.builder().id(OWNER_ID).build())
                .city(City.builder().id(CITY_ID).build())
                .build();
        when(userGateway.findById(OWNER_ID)).thenReturn(communityDomain.getOwner());
        when(cityGateway.findById(CITY_ID)).thenReturn(null);
        HandlerException exception = assertThrows(HandlerException.class, () -> {
            registerCommunityUseCase.register(communityDomain);
        });

        assertEquals(NOT_FOUND, exception.getHandlerErrorModel().getStatus());
        assertEquals(CITY_NOT_FOUND.getField(), exception.getHandlerErrorModel().getErrors().get(0).getField());
        assertEquals(CITY_NOT_FOUND.getMessage(), exception.getHandlerErrorModel().getErrors().get(0).getMessage());
    }


}