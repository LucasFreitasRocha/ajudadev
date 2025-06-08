package dev.ajuda.monolito.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDomain {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<TypeUser> typeUser;


}
