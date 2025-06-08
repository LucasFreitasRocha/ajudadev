package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.core.validator.RegisterValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DisplayName("RegisterUseCase Tests")
class RegisterUseCaseTest {

    @Mock
    private RegisterValidator registerValidator;
    @Mock
    private BCryptPasswordEncoder encryptor;
    @Mock
    private UserGateway userGateway;
    @Mock
    private HandlerErrorService handlerErrorService;
    @InjectMocks
    private RegisterUseCase registerUseCase;

    @Test
    @DisplayName("Should register a user successfully")
    void shouldRegisterUserSuccessfully() {
        var userDomain = UserDomain.builder()
                .name("Valid Name")
                .email("teste@email.com")
                .password("ValidPassword123")
                .build();

        when(encryptor.encode(userDomain.getPassword())).thenReturn(userDomain.getPassword());
        when(userGateway.emailExist(userDomain.getEmail())).thenReturn(false);
        when(userGateway.save(userDomain)).thenReturn(userDomain);
        registerUseCase.register(userDomain);
        verify(registerValidator).validate(userDomain);
        verify(userGateway).emailExist(userDomain.getEmail());
        verify(encryptor).encode(userDomain.getPassword());
        verify(userGateway).save(userDomain);
    }

}