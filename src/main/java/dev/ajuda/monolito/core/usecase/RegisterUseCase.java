package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.gateway.in.RegisterGateway;
import dev.ajuda.monolito.core.gateway.out.RegisterSaveGateway;
import dev.ajuda.monolito.core.validator.RegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUseCase implements RegisterGateway {

    private final RegisterValidator registerValidator;
    private final BCryptPasswordEncoder encryptor;
    private final RegisterSaveGateway registerSaveGateway;
    @Override
    public UserDomain register(UserDomain register) {
        registerValidator.validate(register);
        register.setPassword(encryptor.encode(register.getPassword()));
        return registerSaveGateway.save(register);
    }
}
