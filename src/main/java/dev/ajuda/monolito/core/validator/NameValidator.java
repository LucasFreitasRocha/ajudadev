package dev.ajuda.monolito.core.validator;


public class NameValidator {

    public static boolean isValid(String name, boolean isCommunity) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        // Check if the name contains only letters, spaces, and apostrophes
        return (isCommunity)? true : name.matches("^[a-zA-ZÀ-ÿ\\s' ]+$") && name.length() <= 50;
    }
}
