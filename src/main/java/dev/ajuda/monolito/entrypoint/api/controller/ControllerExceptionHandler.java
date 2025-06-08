package dev.ajuda.monolito.entrypoint.api.controller;


import dev.ajuda.monolito.core.exception.HandlerException;
import dev.ajuda.monolito.core.exception.model.ErrorModel;
import dev.ajuda.monolito.core.exception.model.HandlerErrorModel;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(HandlerException.class)
    public ResponseEntity<HandlerErrorModel> handler(HandlerException e, HttpServletRequest req) {
        e.getHandlerErrorModel().setPath(req.getRequestURI());
        return ResponseEntity.status(e.getHandlerErrorModel().getStatus()).body(e.getHandlerErrorModel());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HandlerErrorModel> othersExpections(Exception e, HttpServletRequest req) {
        HandlerErrorModel model = new HandlerErrorModel();
        model.getErrors().add(new ErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage()));
        model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        model.setPath(req.getRequestURI());
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(model);

    }
}