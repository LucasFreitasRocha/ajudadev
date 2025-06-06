package dev.ajuda.monolito.core.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDomain {
    private String name;
    private String email;
    private String password;
    private List<TypeUser> typeUser;
}
