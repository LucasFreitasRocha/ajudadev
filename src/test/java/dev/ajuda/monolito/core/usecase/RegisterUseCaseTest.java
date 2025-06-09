package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.core.validator.RegisterUseValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DisplayName("RegisterUseCase Tests")
class RegisterUseCaseTest {

    @Mock
    private RegisterUseValidator registerUseValidator;
    @Mock
    private BCryptPasswordEncoder encryptor;
    @Mock
    private UserGateway userGateway;
    @Mock
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
        when(userGateway.findByEmail(userDomain.getEmail())).thenReturn(userDomain);
        when(userGateway.save(userDomain)).thenReturn(userDomain);
        registerUseCase.register(userDomain);
        verify(registerUseValidator).validate(userDomain);
        verify(userGateway).findByEmail(userDomain.getEmail());
        verify(encryptor).encode(userDomain.getPassword());
        verify(userGateway).save(userDomain);
    }

}