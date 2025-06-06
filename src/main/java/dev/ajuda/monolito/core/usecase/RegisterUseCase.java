package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.gateway.in.RegisterGateway;
import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import dev.ajuda.monolito.entrypoint.api.dto.out.RegisterOutDto;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCase implements RegisterGateway {

    @Override
    public RegisterOutDto register(RegisterInDto register) {
        return null;
    }
}
