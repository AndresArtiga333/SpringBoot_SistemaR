package com.andresartiga.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class EmpleadoException extends RuntimeException  {

    public EmpleadoException(String mensaje){
        super(mensaje);
    }
}
