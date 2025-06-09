package dev.ajuda.monolito.core.gateway.in;

import dev.ajuda.monolito.core.domain.CommunityDomain;
import io.micrometer.common.KeyValues;

import java.util.List;
import java.util.stream.Stream;

public interface RegisterCommunityGateway {

    public CommunityDomain register(CommunityDomain community);

    List<CommunityDomain> getAllCommunities();
}
