package dev.ajuda.monolito.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class UserDomain {
    private String name;
    private String email;
    private String password;
    private List<TypeUser> typeUser;
}
