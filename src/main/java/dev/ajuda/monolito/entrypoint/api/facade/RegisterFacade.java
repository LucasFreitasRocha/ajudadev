package dev.ajuda.monolito.entrypoint.api.facade;

import dev.ajuda.monolito.core.gateway.in.RegisterGateway;
import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import dev.ajuda.monolito.entrypoint.api.dto.out.RegisterOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterFacade {
    private final RegisterGateway registerGateway;

    public RegisterOutDto register(RegisterInDto register) {
        return RegisterOutDto.fromDomain(registerGateway.register(register.toDomain()));
    }
}
