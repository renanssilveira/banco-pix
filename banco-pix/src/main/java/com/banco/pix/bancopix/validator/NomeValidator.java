package com.banco.pix.bancopix.validator;

import org.springframework.stereotype.Service;

@Service
public class NomeValidator {

    public boolean isValidNome(String valor){

        return valor.matches("^[a-zA-Z0-9_]{1,30}$");
    }
}
