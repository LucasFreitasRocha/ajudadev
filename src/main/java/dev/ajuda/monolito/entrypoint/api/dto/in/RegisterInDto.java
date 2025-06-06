package dev.ajuda.monolito.entrypoint.api.dto.in;

import dev.ajuda.monolito.core.domain.TypeUser;
import lombok.Builder;

import java.util.List;
@Builder
public record RegisterInDto(String name,
                            String email,
                            String password,
                            List<TypeUser> typeUsers) {
}
