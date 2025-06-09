package dev.ajuda.monolito.entrypoint.api.controller.user.controller;

import dev.ajuda.monolito.entrypoint.api.controller.user.dto.in.RegisterUserInDto;
import dev.ajuda.monolito.entrypoint.api.controller.user.dto.out.RegisterOutDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public interface UserApi {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    RegisterOutDto register(@RequestBody RegisterUserInDto register);
}
