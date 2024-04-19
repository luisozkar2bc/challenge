package com.challenge.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SuperHeroeDuplicadoException extends RuntimeException {
    private final String mensaje;
    public SuperHeroeDuplicadoException(String message){
        this.mensaje = message;
    }

    @Override
    public String getMessage() {
        return this.getMensaje();
    }
}
