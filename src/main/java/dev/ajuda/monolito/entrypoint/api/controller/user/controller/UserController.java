package dev.ajuda.monolito.entrypoint.api.controller.user.controller;

import dev.ajuda.monolito.entrypoint.api.controller.user.dto.in.RegisterUserInDto;
import dev.ajuda.monolito.entrypoint.api.controller.user.dto.out.RegisterOutDto;
import dev.ajuda.monolito.entrypoint.api.controller.user.facade.RegisterUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final RegisterUserFacade registerUserFacade;
    @Override
    public RegisterOutDto register(RegisterUserInDto register) {
        return registerUserFacade.register(register);
    }
}
