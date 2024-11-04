package com.banco.pix.bancopix.validator;

import org.springframework.stereotype.Service;

@Service
public class CelularValidator {

    public boolean isValidCelular(String valor){

        return valor.matches("^\\+\\d{2}\\d{3}\\d{9}$");
    }
}
