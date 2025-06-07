package dev.ajuda.monolito.core.gateway.out;

import dev.ajuda.monolito.core.domain.UserDomain;

public interface RegisterSaveGateway {

    UserDomain save(UserDomain userDomain);
}
