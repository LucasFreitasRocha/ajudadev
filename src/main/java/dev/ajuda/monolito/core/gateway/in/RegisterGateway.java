package dev.ajuda.monolito.core.gateway.in;

import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import dev.ajuda.monolito.entrypoint.api.dto.out.RegisterOutDto;

public interface RegisterGateway {
    public RegisterOutDto register(RegisterInDto register);
}
