package dev.ajuda.monolito.entrypoint.api.controller.community.controller;


import dev.ajuda.monolito.entrypoint.api.controller.community.dto.CommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.PageableCommunityDto;
import dev.ajuda.monolito.entrypoint.api.controller.community.dto.RegisterCommunityDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/community")
public interface CommunityApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    CommunityDto register(RegisterCommunityDto registerCommunityDto);


    @GetMapping
    PageableCommunityDto getAllCommunities(@RequestParam("page") Integer page,
                                           @RequestParam(value = "size" , required = false, defaultValue = "5") int size,
                                           @RequestParam(value = "cityId", required = false) Long cityId
    );
}
