package dev.ajuda.monolito.entrypoint.api.controller.community.controller;

import dev.ajuda.monolito.entrypoint.api.controller.community.dto.CommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.RegisterCommunityDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/community")
public interface CommunityApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    RegisterCommunityDto register(RegisterCommunityDto registerCommunityDto);


    @GetMapping
    List<CommunityDto> getAllCommunities();
}
