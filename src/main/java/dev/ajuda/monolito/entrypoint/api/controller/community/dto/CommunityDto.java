package dev.ajuda.monolito.entrypoint.api.controller.community.dto;

import dev.ajuda.monolito.core.domain.City;
import dev.ajuda.monolito.core.domain.CommunityDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {

    private Long id;
    private String name;
    private String description;
    private CityDto city;
    private OwnerCommunityDto owner;

    public static CommunityDto fromDomain(CommunityDomain domain){
        return CommunityDto.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .city(new CityDto(
                        domain.getCity().getId(),
                        domain.getCity().getName(),
                        domain.getCity().getState().getPostalAcronym()))
                .owner(new OwnerCommunityDto(domain.getOwner().getId(), domain.getOwner().getName()))
                .build();
    }
}
