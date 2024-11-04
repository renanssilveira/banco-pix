package com.banco.pix.bancopix.validator;

import org.springframework.stereotype.Service;

@Service
public class AleatorioValidator {

    public boolean isValidAleatorio(String valor){

        return valor.matches("^[a-zA-Z0-9]{1,36}$");
    }
}
