package dev.ajuda.monolito.core.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FieldsMessageError {
    NAME_INVALID("name", "Name is not valid"),
    PASSWORD_EMPTY("password", "Password cannot be empty"),
    EMAIL_EMPTY("email", "Email cannot be empty"),
    EMAIL_INVALID("email", "Email is not valid"),
    EMAIL_EXISTS("email", "Email already exists"),
    DESCRIPTION_EMPTY("description", "Description cannot be empty"),
    CITY_INVALID("city", "City is not valid"),
    OWNER_INVALID("owner", "Owner is not valid"),
    USER_NOT_FOUND("user", "user not found" ),
    CITY_NOT_FOUND("city", "City is not found"),
    PAGE_IS_REQUIRED("page" , "Page is required" );

    private final String field;
    private final String message;
}
