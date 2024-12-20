package com.banco.pix.bancopix.infra;

import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.exceptions.BancoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BancoFullException.class)
    private ResponseEntity<String> contaValidacaoHandler(BancoFullException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }

    @ExceptionHandler(BancoNotFoundException.class)
    private ResponseEntity<String> contaNotFoundHandler(BancoNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
