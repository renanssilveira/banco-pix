package com.banco.pix.bancopix.validator;

import org.springframework.stereotype.Service;

@Service
public class SobreNomeValidator {

    public boolean isValidSobreNome(String valor){

        return valor.matches("^[a-zA-Z0-9_]{0,45}$");
    }
}
