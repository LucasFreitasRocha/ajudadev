package dev.ajuda.monolito.entrypoint.api.controller.user.dto.out;

import dev.ajuda.monolito.core.domain.TypeUser;
import dev.ajuda.monolito.core.domain.UserDomain;
import lombok.Builder;

import java.util.List;

@Builder
public record RegisterOutDto(
                            Long id,
                            String name,
                            String email,
                            List<TypeUser> typeUsers) {

    public static RegisterOutDto fromDomain(UserDomain userDomain) {
        return RegisterOutDto.builder()
                .id(userDomain.getId())
                .name(userDomain.getName())
                .email(userDomain.getEmail())
                .typeUsers(userDomain.getTypeUser())
                .build();
    }
}

