package dev.ajuda.monolito.entrypoint.api.controller.user.dto.in;

import dev.ajuda.monolito.core.domain.TypeUser;
import dev.ajuda.monolito.core.domain.UserDomain;
import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record RegisterUserInDto(String name,
                                String email,
                                String password,
                                List<TypeUser> typeUsers) {
    public UserDomain toDomain() {

        return UserDomain.builder()
                .name(name)
                .email(email)
                .password(password)
                .typeUser(Objects.nonNull(typeUsers) ? typeUsers : List.of(TypeUser.MENTORED))
                .build();
    }
}
