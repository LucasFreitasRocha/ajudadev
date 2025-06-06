package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.gateway.in.RegisterGateway;
import dev.ajuda.monolito.core.validator.RegisterValidator;
import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import dev.ajuda.monolito.entrypoint.api.dto.out.RegisterOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUseCase implements RegisterGateway {

    private final RegisterValidator registerValidator;

    @Override
    public RegisterOutDto register(RegisterInDto register) {
        registerValidator.validate(register);
        return null;
    }
}
