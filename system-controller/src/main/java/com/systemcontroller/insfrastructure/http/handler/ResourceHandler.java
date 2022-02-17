package com.systemcontroller.insfrastructure.http.handler;

import com.systemcontroller.insfrastructure.http.ErrorMapResponse;
import com.systemcontroller.insfrastructure.http.ErrorResponse;
import com.systemcontroller.insfrastructure.http.OrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMapResponse>  handlerMethodArgumentException(MethodArgumentNotValidException m){
        Map<String,String> erros = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach(erro ->{
            String campo = ((FieldError)erro).getField();
            String mensagem = erro.getDefaultMessage();
            erros.put(campo, mensagem);
        });
        ErrorMapResponse.ErrorMapResponseBuilder errorMap = ErrorMapResponse.builder();
        errorMap.errosResp(erros).httpStatus(HttpStatus.BAD_REQUEST.value())
                .timStamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap.build());
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> handlerException(OrderException m) {
        ErrorResponse.ErrorResponseBuilder error =  ErrorResponse.builder();
        error.httpStatus(m.getHttpStatus().value());
        error.menssage(m.getMessage());
        error.timeStamp(System.currentTimeMillis());
        return ResponseEntity.status(m.getHttpStatus()).body(error.build());
    }

}
