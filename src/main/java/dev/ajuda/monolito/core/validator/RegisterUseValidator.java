package dev.ajuda.monolito.core.validator;


import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;


@Component
@RequiredArgsConstructor
public class RegisterUseValidator {
    private final HandlerErrorService handlerErrorService;
    public void validate(UserDomain register) {
        handlerErrorService.init();
        if (!NameValidator.isValid(register.getName(), false)) {
            handlerErrorService.addFieldError(FieldsMessageError.NAME_INVALID);
        }
        if (StringUtils.isEmpty(register.getPassword())) {
            handlerErrorService.addFieldError(FieldsMessageError.PASSWORD_EMPTY);
        }
        if (StringUtils.isEmpty(register.getEmail())) {
            handlerErrorService.addFieldError(FieldsMessageError.EMAIL_EMPTY);
        }
        if(!EmailValidator.isValid(register.getEmail())){
            handlerErrorService.addFieldError(FieldsMessageError.EMAIL_INVALID);
        }
        handlerErrorService.handle();
    }
}
