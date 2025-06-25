package dev.ajuda.monolito.entrypoint.api.controller.community.controller;

import dev.ajuda.monolito.core.domain.PageableCommunity;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.CommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.PageableCommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.RegisterCommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.facade.CommunityFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommunityController implements CommunityApi {

    private final CommunityFacade communityFacade;

    @Override
    public CommunityDto register(RegisterCommunityDto registerCommunityDto) {
        return communityFacade.register(registerCommunityDto);
    }

    @Override
    public PageableCommunityDto getAllCommunities(Integer page, int size, Long cityId) {
       return  communityFacade.getAllCommunities(page, size, cityId);
    }


}
