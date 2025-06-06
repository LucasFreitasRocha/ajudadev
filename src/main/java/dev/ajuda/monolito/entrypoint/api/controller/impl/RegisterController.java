package dev.ajuda.monolito.entrypoint.api.controller.impl;

import dev.ajuda.monolito.entrypoint.api.controller.RegisterApi;
import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import dev.ajuda.monolito.entrypoint.api.dto.out.RegisterOutDto;
import dev.ajuda.monolito.entrypoint.api.facade.RegisterFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RegisterController implements RegisterApi {
    private final RegisterFacade registerFacade;
    @Override
    public RegisterOutDto register(RegisterInDto register) {
        return registerFacade.register(register);
    }
}
