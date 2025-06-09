package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.in.RegisterUserGateway;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.core.validator.RegisterUseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase implements RegisterUserGateway {

    private final RegisterUseValidator registerUseValidator;
    private final BCryptPasswordEncoder encryptor;
    private final UserGateway userGateway;
    private final HandlerErrorService handlerErrorService;
    @Override
    public UserDomain register(UserDomain register) {
        registerUseValidator.validate(register);
        if(Objects.nonNull(userGateway.findByEmail(register.getEmail()))) {
            handlerErrorService.addFieldError(FieldsMessageError.EMAIL_EXISTS).handle();
        }
        register.setPassword(encryptor.encode(register.getPassword()));
        return userGateway.save(register);
    }
}
