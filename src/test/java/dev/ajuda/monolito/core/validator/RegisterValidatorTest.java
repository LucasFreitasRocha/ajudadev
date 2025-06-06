package dev.ajuda.monolito.core.validator;

import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@DisplayName("RegisterValidator Tests")
class RegisterValidatorTest {

    @Mock
    HandlerErrorService handlerErrorService;
    @InjectMocks
    private RegisterValidator registerValidator;

    @Test
    @DisplayName("Should fall  validation errors - empty name, password and invalid email")
    void shouldFallEmptyAndInvalid() {
        var register = RegisterInDto.builder()
                .name("")
                .email("invalid-email")
                .password("")
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService).addFieldError("name", "Name cannot be empty");
        verify(handlerErrorService).addFieldError("password", "Password cannot be empty");
        verify(handlerErrorService).addFieldError("email", "Email is not valid");
        verify(handlerErrorService).handle();
    }

    @Test
    @DisplayName("should fall validation errors - null name and password")
    void shouldFallNullParameters() {
        var register = RegisterInDto.builder()
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService).addFieldError("name", "Name cannot be empty");
        verify(handlerErrorService).addFieldError("password", "Password cannot be empty");
        verify(handlerErrorService).addFieldError("email", "Email is not valid");
        verify(handlerErrorService).handle();
    }

    @Test
    @DisplayName("Should fall validation errors - empty email")
    void shouldFallEmptyEmail() {
        var register = RegisterInDto.builder()
                .name("Valid Name")
                .email("")
                .password("ValidPassword123")
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService).addFieldError("email", "Email cannot be empty");
        verify(handlerErrorService).handle();
    }

    @Test
    @DisplayName("Should pass validation")
    void shouldPassValidation() {
        var register = RegisterInDto.builder()
                .name("Valid Name")
                .email("teste@email.com")
                .password("ValidPassword123")
                .build();
        registerValidator.validate(register);
        verify(handlerErrorService).init();
        verify(handlerErrorService, never()).addFieldError(any(),any());
        verify(handlerErrorService).handle();
    }

}