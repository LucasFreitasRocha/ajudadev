package dev.ajuda.monolito.dataprovider.database.gateway;

import dev.ajuda.monolito.core.domain.City;
import dev.ajuda.monolito.core.gateway.out.CityGateway;
import dev.ajuda.monolito.dataprovider.database.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityGatewayImpl implements CityGateway {
    private final CityRepository cityRepository;
    @Override
    public City findById(Long id) {
        return cityRepository.findById(id)
                .map(cityEntity -> cityEntity.toDomain())
                .orElse(null);
    }


}
