package dev.ajuda.monolito.entrypoint.api.controller.community.dto.in;

public record RegisterCommunityInDto(Long cityId,
                                     String name,
                                     String description,
                                     String ownerId
                                     ) {


}
