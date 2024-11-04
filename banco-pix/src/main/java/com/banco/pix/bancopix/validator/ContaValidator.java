package com.banco.pix.bancopix.validator;

import org.springframework.stereotype.Service;

@Service
public class ContaValidator {

    public boolean isValidConta(String valor){

        return valor.matches("^[0-9]{1,8}$");
    }
}
