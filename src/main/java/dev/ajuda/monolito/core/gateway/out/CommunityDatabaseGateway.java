package dev.ajuda.monolito.core.gateway.out;

import dev.ajuda.monolito.core.domain.CommunityDomain;

import java.util.List;

public interface CommunityDatabaseGateway {
    CommunityDomain register(CommunityDomain community);

    List<CommunityDomain> getAllCommunities();
}
