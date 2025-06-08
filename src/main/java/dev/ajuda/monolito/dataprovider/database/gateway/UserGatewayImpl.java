package dev.ajuda.monolito.dataprovider.database.gateway;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.dataprovider.database.entity.UserEntity;
import dev.ajuda.monolito.dataprovider.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public UserDomain save(UserDomain userDomain) {
        return userRepository.save(UserEntity.fromDomain(userDomain))
                .toDomain();
    }

    @Override
    public boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
