package dev.ajuda.monolito.entrypoint.api.controller.community.dto;

import dev.ajuda.monolito.core.domain.City;
import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.domain.UserDomain;

public record RegisterCommunityDto(Long cityId,
                                   String name,
                                   String description,
                                   String ownerId
                                     ) {

        public CommunityDomain toDomain() {
            return CommunityDomain.builder()
                    .city(City.builder()
                            .id(cityId)
                            .build())
                    .name(name)
                    .description(description)
                    .owner(UserDomain.builder()
                            .id(ownerId)
                            .build())
                    .build();
        }
        public static RegisterCommunityDto fromDomain(CommunityDomain communityDomain) {
            return new RegisterCommunityDto(
                    communityDomain.getCity().getId(),
                    communityDomain.getName(),
                    communityDomain.getDescription(),
                    communityDomain.getOwner().getId()
            );
        }
}
