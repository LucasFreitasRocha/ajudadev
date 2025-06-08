package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.in.RegisterGateway;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.core.validator.RegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RegisterUseCase implements RegisterGateway {

    private final RegisterValidator registerValidator;
    private final BCryptPasswordEncoder encryptor;
    private final UserGateway userGateway;
    private final HandlerErrorService handlerErrorService;
    @Override
    public UserDomain register(UserDomain register) {
        registerValidator.validate(register);
        if(userGateway.emailExist(register.getEmail())) {
            handlerErrorService.addFieldError(FieldsMessageError.EMAIL_EXISTS).handle();
        }
        register.setPassword(encryptor.encode(register.getPassword()));
        return userGateway.save(register);
    }
}
