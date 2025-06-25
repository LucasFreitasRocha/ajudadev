package dev.ajuda.monolito.core.gateway.out;

import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.domain.PageableCommunity;

import java.util.List;

public interface CommunityDatabaseGateway {
    CommunityDomain register(CommunityDomain community);

    PageableCommunity getAllCommunities(int page, int size, Long cityId);
}
