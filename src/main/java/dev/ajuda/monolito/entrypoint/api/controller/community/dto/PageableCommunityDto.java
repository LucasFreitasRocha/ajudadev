package dev.ajuda.monolito.entrypoint.api.controller.community.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageableCommunityDto {
    private boolean hasNext;
    private CommunityDto[] communities;

    public static PageableCommunityDto fromDomain(dev.ajuda.monolito.core.domain.PageableCommunity domain) {
        return PageableCommunityDto.builder()
                .hasNext(domain.isHasNext())
                .communities(domain.getCommunities().stream()
                        .map(CommunityDto::fromDomain)
                        .toArray(CommunityDto[]::new))
                .build();
    }
}
