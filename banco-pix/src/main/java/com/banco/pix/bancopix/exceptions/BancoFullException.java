package com.banco.pix.bancopix.exceptions;

public class BancoFullException extends RuntimeException {
    public BancoFullException() {
        super("Conta não encontrada");
    }

    public BancoFullException(String message) {
        super(message);
    }
}
