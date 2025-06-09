package dev.ajuda.monolito.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CommunityDomain {
    private Long id;
    private City city;
    private String name;
    private String description;
    private UserDomain owner;

}
