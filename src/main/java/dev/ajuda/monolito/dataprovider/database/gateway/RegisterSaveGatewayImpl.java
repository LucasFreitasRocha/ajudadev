package dev.ajuda.monolito.dataprovider.database.gateway;

import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.gateway.out.RegisterSaveGateway;
import dev.ajuda.monolito.dataprovider.database.entity.UserEntity;
import dev.ajuda.monolito.dataprovider.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterSaveGatewayImpl implements RegisterSaveGateway {

    private final UserRepository userRepository;

    @Override
    public UserDomain save(UserDomain userDomain) {
        return userRepository.save(UserEntity.fromDomain(userDomain))
                .toDomain();
    }
}
