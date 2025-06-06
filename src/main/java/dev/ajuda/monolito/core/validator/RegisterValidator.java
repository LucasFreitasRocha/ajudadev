package dev.ajuda.monolito.core.validator;


import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RegisterValidator {

    public void validate(RegisterInDto register) {
        if (StringUtils.hasLength(register.name())) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (StringUtils.hasLength(register.password())) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }
}
