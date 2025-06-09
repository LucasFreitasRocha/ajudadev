package dev.ajuda.monolito.entrypoint.api.controller.community.controller;

import dev.ajuda.monolito.entrypoint.api.controller.community.dto.CommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.RegisterCommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.facade.CommunityFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController implements CommunityApi {

    private final CommunityFacade communityFacade;

    @Override
    public RegisterCommunityDto register(RegisterCommunityDto registerCommunityDto) {
        return communityFacade.register(registerCommunityDto);
    }

    @Override
    public List<CommunityDto> getAllCommunities() {
        return communityFacade.getAllCommunities();
    }
}
