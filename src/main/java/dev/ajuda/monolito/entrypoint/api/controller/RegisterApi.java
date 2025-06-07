package dev.ajuda.monolito.entrypoint.api.controller;

import dev.ajuda.monolito.entrypoint.api.dto.in.RegisterInDto;
import dev.ajuda.monolito.entrypoint.api.dto.out.RegisterOutDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public interface RegisterApi {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    RegisterOutDto register(@RequestBody RegisterInDto register);
}
