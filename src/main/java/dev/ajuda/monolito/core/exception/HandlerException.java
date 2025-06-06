package dev.ajuda.monolito.core.exception;


import dev.ajuda.monolito.core.exception.model.HandlerErrorModel;

public class HandlerException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private HandlerErrorModel handlerErrorModel;

    public HandlerException(HandlerErrorModel model){
        this.handlerErrorModel = model;
    }
    public HandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandlerErrorModel getHandlerErrorModel() {
        return handlerErrorModel;
    }
}