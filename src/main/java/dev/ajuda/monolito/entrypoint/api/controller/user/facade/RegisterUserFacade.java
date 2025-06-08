package dev.ajuda.monolito.entrypoint.api.controller.user.facade;

import dev.ajuda.monolito.core.gateway.in.RegisterGateway;
import dev.ajuda.monolito.entrypoint.api.controller.user.dto.in.RegisterUserInDto;
import dev.ajuda.monolito.entrypoint.api.controller.user.dto.out.RegisterOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserFacade {
    private final RegisterGateway registerGateway;

    public RegisterOutDto register(RegisterUserInDto register) {
        return RegisterOutDto.fromDomain(registerGateway.register(register.toDomain()));
    }
}
