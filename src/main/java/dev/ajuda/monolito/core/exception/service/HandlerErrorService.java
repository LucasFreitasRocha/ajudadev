package dev.ajuda.monolito.core.exception.service;


import dev.ajuda.monolito.core.exception.HandlerException;
import dev.ajuda.monolito.core.exception.model.ErrorModel;
import dev.ajuda.monolito.core.exception.model.FieldsMessageError;
import dev.ajuda.monolito.core.exception.model.HandlerErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HandlerErrorService {

    private HandlerErrorModel handlerErrorModel;

    public HandlerErrorService init() {
        handlerErrorModel = new HandlerErrorModel();
        return this;
    }

    public HandlerErrorService addError(String message) {
        this.handlerErrorModel.getErrors().add(new ErrorModel("error:", message));
        return this;
    }

    public HandlerErrorService addFieldError(String field, String message) {
        this.handlerErrorModel.getErrors().add(new ErrorModel(field, message));
        return this;
    }

    public HandlerErrorService addFieldError(FieldsMessageError fieldsMessageError) {
        this.handlerErrorModel.getErrors().add(new ErrorModel(fieldsMessageError.getField(),
                fieldsMessageError.getMessage()));
        return this;
    }

    public HandlerErrorService addHttpStatus(HttpStatus status) {
        this.handlerErrorModel.setStatus(status);
        return this;
    }

    public void handle() {
        if (!handlerErrorModel.getErrors().isEmpty()) {
            throw new HandlerException(this.handlerErrorModel);
        }
    }
}