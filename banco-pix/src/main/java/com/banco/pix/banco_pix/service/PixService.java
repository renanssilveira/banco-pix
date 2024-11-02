package com.banco.pix.banco_pix.service;

import com.banco.pix.banco_pix.entity.Conta;
import com.banco.pix.banco_pix.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import validator.CpfCnpjValidator;

import java.util.Optional;


@Service
public class PixService {

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private CpfCnpjValidator cpfCnpjValidator;

    public Conta criaConta(Conta conta){
    return null;
    }
}
