package com.andresartiga.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class ProyectoException extends RuntimeException{

        public ProyectoException (String mensaje){
            super(mensaje);
        }
}
