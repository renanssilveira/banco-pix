package com.banco.pix.bancopix.exceptions;

public class BancoNotFoundException extends RuntimeException {
    public BancoNotFoundException() {
        super("Conta não encontrada");
    }

    public BancoNotFoundException(String message) {
        super(message);
    }
}
