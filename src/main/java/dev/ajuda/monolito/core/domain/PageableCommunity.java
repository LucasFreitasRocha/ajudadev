package dev.ajuda.monolito.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PageableCommunity {

    private boolean hasNext;
    private List<CommunityDomain> communities;
}
