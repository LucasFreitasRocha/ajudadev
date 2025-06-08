package dev.ajuda.monolito.core.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FieldsMessageError {
    NAME_EMPTY("name", "Name cannot be empty"),
    PASSWORD_EMPTY("password", "Password cannot be empty"),
    EMAIL_EMPTY("email", "Email cannot be empty"),
    EMAIL_INVALID("email", "Email is not valid"),
    EMAIL_EXISTS("email", "Email already exists");

    private final String field;
    private final String message;
}
