package dev.ajuda.monolito.dataprovider.database.gateway;

import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.gateway.out.CommunityDatabaseGateway;
import dev.ajuda.monolito.dataprovider.database.entity.CommunityEntity;
import dev.ajuda.monolito.dataprovider.database.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityDatabaseGatewayImpl implements CommunityDatabaseGateway {

    private final CommunityRepository communityRepository;
    @Override
    public CommunityDomain register(CommunityDomain community) {
        return communityRepository.save(CommunityEntity.fromDomain(community)).toDomain();
    }

    @Override
    public List<CommunityDomain> getAllCommunities() {
        return communityRepository.findAll()
                .stream()
                .map(CommunityEntity::toDomain)
                .toList();
    }
}
