package dev.ajuda.monolito.dataprovider.database.gateway;

import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.domain.PageableCommunity;
import dev.ajuda.monolito.core.gateway.out.CommunityDatabaseGateway;
import dev.ajuda.monolito.dataprovider.database.entity.CommunityEntity;
import dev.ajuda.monolito.dataprovider.database.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityDatabaseGatewayImpl implements CommunityDatabaseGateway {

    private final CommunityRepository communityRepository;

    @Override
    public CommunityDomain register(CommunityDomain community) {
        return communityRepository.save(CommunityEntity.fromDomain(community)).toDomain();
    }

    @Override
    public PageableCommunity getAllCommunities(int page, int size, Long cityId) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<CommunityEntity> communityEntityPage = communityRepository.findByCityOptional(cityId, pageable);
        return PageableCommunity.builder()
                .hasNext(communityEntityPage.hasNext())
                .communities(communityEntityPage.getContent().stream()
                        .map(CommunityEntity::toDomain)
                        .toList())
                .build();
    }
}
