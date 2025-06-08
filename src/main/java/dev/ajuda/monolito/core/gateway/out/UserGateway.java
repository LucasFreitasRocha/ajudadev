package dev.ajuda.monolito.core.gateway.out;

import dev.ajuda.monolito.core.domain.UserDomain;

public interface UserGateway {

    UserDomain save(UserDomain userDomain);

    boolean emailExist(String email);
}
