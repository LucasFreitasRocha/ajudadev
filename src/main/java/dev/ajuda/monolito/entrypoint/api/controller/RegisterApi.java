package dev.ajuda.monolito.entrypoint.api.controller;

import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import dev.ajuda.monolito.entrypoint.api.dto.out.RegisterOutDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public interface RegisterApi {
    @PostMapping
    RegisterOutDto register(@RequestBody RegisterInDto register);
}
