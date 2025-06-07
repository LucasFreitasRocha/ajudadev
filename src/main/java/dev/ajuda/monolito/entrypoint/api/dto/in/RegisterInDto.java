package dev.ajuda.monolito.entrypoint.api.dto.in;

import dev.ajuda.monolito.core.domain.TypeUser;
import dev.ajuda.monolito.core.domain.UserDomain;
import lombok.Builder;

import java.util.List;
@Builder
public record RegisterInDto(String name,
                            String email,
                            String password,
                            List<TypeUser> typeUsers) {
    public UserDomain toDomain() {

        return UserDomain.builder()
                .name(name)
                .email(email)
                .password(password)
                .typeUser(typeUsers)
                .build();
    }
}
