package dev.ajuda.monolito.core.gateway.in;

import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.domain.PageableCommunity;

import java.util.List;

public interface RegisterCommunityGateway {

    public CommunityDomain register(CommunityDomain community);

    PageableCommunity getAllCommunities(Integer page, int size, Long cityId);
}
