package dev.ajuda.monolito.entrypoint.api.controller.community.facade;

import dev.ajuda.monolito.core.gateway.in.RegisterCommunityGateway;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.CommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.RegisterCommunityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityFacade {

    private final RegisterCommunityGateway registerCommunityGateway;

    public RegisterCommunityDto register(RegisterCommunityDto registerCommunityDto) {
        return RegisterCommunityDto.fromDomain(registerCommunityGateway.register(registerCommunityDto.toDomain()));

    }

    public List<CommunityDto> getAllCommunities() {
        return registerCommunityGateway.getAllCommunities()
                .stream()
                .map(CommunityDto::fromDomain)
                .toList();

    }
}
