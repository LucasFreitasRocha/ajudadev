package dev.ajuda.monolito.core.validator;

import dev.ajuda.monolito.core.domain.City;
import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.HandlerException;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@DisplayName("RegisterCommunityValidator Tests")
class RegisterCommunityValidatorTest {

    private static final String OWNER_ID = "ownerId";
    private static final long CITY_ID = 1L;
    @Spy
    private HandlerErrorService handlerErrorService;

    @InjectMocks
    RegisterCommunityValidator registerCommunityValidator;

    @Test
    @DisplayName("Should pass")
    void shouldPass() {
        var community = CommunityDomain.builder()
                .name("Community without owner")
                .description("This community has no owner.")
                .owner(UserDomain.builder().id(OWNER_ID).build())
                .city(City.builder().id(CITY_ID).build())
                .build();
        assertDoesNotThrow(() ->registerCommunityValidator.validate(community));
        verify(handlerErrorService).handle();
        verify(handlerErrorService, never()).addFieldError(any());
    }

    @Test
    @DisplayName("Should fall validation errors - empty name, description, invalid city and owner")
    void shouldFallValidationErrors() {
        var community = CommunityDomain.builder()
                .name("")
                .description("")
                .owner(UserDomain.builder().id("").build())
                .city(City.builder().id(null).build())
                .build();
        assertThrows(HandlerException.class, () ->
                registerCommunityValidator.validate(community));
        verify(handlerErrorService).init();
        verify(handlerErrorService).addFieldError(FieldsMessageError.NAME_INVALID);
        verify(handlerErrorService).addFieldError(FieldsMessageError.DESCRIPTION_EMPTY);
        verify(handlerErrorService).addFieldError(FieldsMessageError.CITY_INVALID);
        verify(handlerErrorService).addFieldError(FieldsMessageError.OWNER_INVALID);
        verify(handlerErrorService).handle();
    }

}