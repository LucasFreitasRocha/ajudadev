package dev.ajuda.monolito.entrypoint.api.controller.community.facade;

import dev.ajuda.monolito.core.domain.PageableCommunity;
import dev.ajuda.monolito.core.gateway.in.RegisterCommunityGateway;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.CommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.PageableCommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.RegisterCommunityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityFacade {

    private final RegisterCommunityGateway registerCommunityGateway;

    public CommunityDto register(RegisterCommunityDto registerCommunityDto) {
        return CommunityDto.fromDomain(registerCommunityGateway.register(registerCommunityDto.toDomain()));

    }

    public PageableCommunityDto getAllCommunities(Integer page, int size, Long cityId) {
        return PageableCommunityDto.fromDomain(registerCommunityGateway.getAllCommunities(page, size, cityId));

    }
}
