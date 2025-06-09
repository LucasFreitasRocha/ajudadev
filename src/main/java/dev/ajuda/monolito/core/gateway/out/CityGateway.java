package dev.ajuda.monolito.core.gateway.out;

import dev.ajuda.monolito.core.domain.City;

public interface CityGateway {
    City findById(Long id);


}
