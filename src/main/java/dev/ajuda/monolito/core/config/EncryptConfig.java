package dev.ajuda.monolito.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncryptConfig {

    @Bean("encryptor")
    public BCryptPasswordEncoder encryptor() {
        return new BCryptPasswordEncoder();
    }
}
