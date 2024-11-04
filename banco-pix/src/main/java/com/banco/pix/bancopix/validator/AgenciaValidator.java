package com.banco.pix.bancopix.validator;

import org.springframework.stereotype.Service;

@Service
public class AgenciaValidator {

    public boolean isValidAgencia(String valor){

        return valor.matches("^[0-9]{1,4}$");
    }
}
