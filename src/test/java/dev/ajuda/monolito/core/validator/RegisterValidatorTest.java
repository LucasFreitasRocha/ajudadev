package dev.ajuda.monolito.core.validator;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayName("RegisterValidator Tests")
class RegisterValidatorTest {

    @Mock
    HandlerErrorService handlerErrorService;
    @Mock
    UserGateway userGateway;
    @InjectMocks
    private RegisterValidator registerValidator;

    @Test
    @DisplayName("Should fall  validation errors - empty name, password and invalid email")
    void shouldFallEmptyAndInvalid() {
        var register = UserDomain.builder()
                .name("")
                .email("invalid-email")
                .password("")
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService).addFieldError(FieldsMessageError.NAME_EMPTY);
        verify(handlerErrorService).addFieldError(FieldsMessageError.PASSWORD_EMPTY);
        verify(handlerErrorService).addFieldError(FieldsMessageError.EMAIL_INVALID);
        verify(handlerErrorService).handle();
    }

    @Test
    @DisplayName("should fall validation errors - null name and password")
    void shouldFallNullParameters() {
        var register = UserDomain.builder()
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService).addFieldError(FieldsMessageError.NAME_EMPTY);
        verify(handlerErrorService).addFieldError(FieldsMessageError.PASSWORD_EMPTY);
        verify(handlerErrorService).addFieldError(FieldsMessageError.EMAIL_INVALID);
        verify(handlerErrorService).handle();
    }

    @Test
    @DisplayName("Should fall validation errors - empty email")
    void shouldFallEmptyEmail() {
        var register = UserDomain.builder()
                .name("Valid Name")
                .email("")
                .password("ValidPassword123")
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService).addFieldError(FieldsMessageError.EMAIL_EMPTY);
        verify(handlerErrorService).handle();
    }

    @Test
    @DisplayName("Should pass validation")
    void shouldPassValidation() {
        var register = UserDomain.builder()
                .name("Valid Name")
                .email("teste@email.com")
                .password("ValidPassword123")
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService, never()).addFieldError(any());
        verify(handlerErrorService).handle();
    }

}