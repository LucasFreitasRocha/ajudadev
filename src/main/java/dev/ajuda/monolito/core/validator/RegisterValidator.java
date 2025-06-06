package dev.ajuda.monolito.core.validator;


import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;


@Component
@RequiredArgsConstructor
public class RegisterValidator {
    private final HandlerErrorService handlerErrorService;
    public void validate(RegisterInDto register) {
        handlerErrorService.init();
        if (StringUtils.isEmpty(register.name())) {
            handlerErrorService.addFieldError("name", "Name cannot be empty");
        }
        if (StringUtils.isEmpty(register.password())) {
            handlerErrorService.addFieldError("password", "Password cannot be empty");
        }
        if (StringUtils.isEmpty(register.email())) {
            handlerErrorService.addFieldError("email", "Email cannot be empty");
        }
        if(!EmailValidator.isValid(register.email())){
            handlerErrorService.addFieldError("email", "Email is not valid");
        }
        handlerErrorService.handle();
    }
}
