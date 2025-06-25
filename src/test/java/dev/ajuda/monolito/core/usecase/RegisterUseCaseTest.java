package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.HandlerException;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.core.validator.RegisterUseValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayName("RegisterUseCase Tests")
class RegisterUseCaseTest {

    @Mock
    private RegisterUseValidator registerUseValidator;
    @Mock
    private BCryptPasswordEncoder encryptor;
    @Mock
    private UserGateway userGateway;
    @Spy
    private HandlerErrorService handlerErrorService;
    @InjectMocks
    private RegisterUserUseCase registerUseCase;

    @Test
    @DisplayName("Should register a user successfully")
    void shouldRegisterUserSuccessfully() {
        var userDomain = UserDomain.builder()
                .name("Valid Name")
                .email("teste@email.com")
                .password("ValidPassword123")
                .build();

        when(encryptor.encode(userDomain.getPassword())).thenReturn(userDomain.getPassword());
        when(userGateway.findByEmail(userDomain.getEmail())).thenReturn(null);
        when(userGateway.save(userDomain)).thenReturn(userDomain);
        registerUseCase.register(userDomain);
        verify(registerUseValidator).validate(userDomain);
        verify(userGateway).findByEmail(userDomain.getEmail());
        verify(encryptor).encode(userDomain.getPassword());
        verify(userGateway).save(userDomain);
    }


    @Test
    @DisplayName("Should throw exception when email already exists")
    void shouldThrowExceptionWhenEmailExists() {
        var userDomain = UserDomain.builder()
                .name("Valid Name")
                .email("teste@email.com")
                .password("ValidPassword123")
                .build();
        when(userGateway.findByEmail(userDomain.getEmail())).thenReturn(userDomain);
        assertThrows(HandlerException.class, () -> registerUseCase.register(userDomain));
        verify(registerUseValidator).validate(userDomain);
        verify(userGateway).findByEmail(userDomain.getEmail());
        verify(encryptor, never()).encode(userDomain.getPassword());
        verify(userGateway, never()).save(userDomain);
    }
}