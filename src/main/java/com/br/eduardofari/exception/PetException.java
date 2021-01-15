package com.br.eduardofari.exception;

public class PetException extends RuntimeException {
    public PetException() {
        super("Pet não encontrado!");
    }
}
