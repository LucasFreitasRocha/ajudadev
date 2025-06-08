package dev.ajuda.monolito.core.gateway.in;

import dev.ajuda.monolito.core.domain.UserDomain;

public interface RegisterGateway {
    public UserDomain register(UserDomain register);
}
