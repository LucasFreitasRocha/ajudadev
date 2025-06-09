package dev.ajuda.monolito.core.usecase;

import dev.ajuda.monolito.core.domain.City;
import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.domain.UserDomain;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import dev.ajuda.monolito.core.gateway.in.RegisterCommunityGateway;
import dev.ajuda.monolito.core.gateway.out.CityGateway;
import dev.ajuda.monolito.core.gateway.out.CommunityDatabaseGateway;
import dev.ajuda.monolito.core.gateway.out.UserGateway;
import dev.ajuda.monolito.core.validator.RegisterCommunityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RegisterCommunityUseCase implements RegisterCommunityGateway {

    private final UserGateway userGateway;
    private final CityGateway cityGateway;
    private final CommunityDatabaseGateway communityDatabaseGateway;
    private final RegisterCommunityValidator registerCommunityValidator;
    private final HandlerErrorService handlerErrorService;

    @Override
    public CommunityDomain register(CommunityDomain community) {
        registerCommunityValidator.validate(community);
        community.setOwner(getUser(community.getOwner().getId()));
        community.setCity(getCity(community.getCity().getId()));
        return communityDatabaseGateway.register(community);
    }

    @Override
    public List<CommunityDomain> getAllCommunities() {
        return communityDatabaseGateway.getAllCommunities();
    }

    private City getCity(Long id) {
        var city = cityGateway.findById(id);
        if(Objects.isNull(city)) {
            handlerErrorService.addFieldError(FieldsMessageError.CITY_NOT_FOUND)
                    .addHttpStatus(HttpStatus.NOT_FOUND).handle();
        }
        return city;
    }

    private UserDomain getUser(String ownerId) {
        var user = userGateway.findById(ownerId);
        if (Objects.isNull(user)) {
            handlerErrorService.addFieldError(FieldsMessageError.USER_NOT_FOUND)
                    .addHttpStatus(HttpStatus.NOT_FOUND).handle();
        }
        return user;
    }
}
