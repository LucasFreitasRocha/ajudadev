package dev.ajuda.monolito.core.validator;

import dev.ajuda.monolito.core.domain.CommunityDomain;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.service.HandlerErrorService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RegisterCommunityValidator {
    private final HandlerErrorService handlerErrorService;

    public void validate(CommunityDomain domain) {
        handlerErrorService.init();
        if (!NameValidator.isValid(domain.getName(), true)) {
            handlerErrorService.addFieldError(FieldsMessageError.NAME_INVALID);
        }
        if (StringUtils.isEmpty(domain.getDescription())) {
            handlerErrorService.addFieldError(FieldsMessageError.DESCRIPTION_EMPTY);
        }
        if (Objects.isNull(domain.getCity()) | Objects.isNull(domain.getCity().getId())) {
            handlerErrorService.addFieldError(FieldsMessageError.CITY_INVALID);
        }
        if (Objects.isNull(domain.getOwner()) | StringUtils.isEmpty(domain.getOwner().getId())) {
            handlerErrorService.addFieldError(FieldsMessageError.OWNER_INVALID);
        }

        handlerErrorService.handle();
    }
}
