package com.banco.pix.banco_pix.service;

import com.banco.pix.banco_pix.converter.ContaConverter;
import com.banco.pix.banco_pix.dtos.CriaChaveRequest;
import com.banco.pix.banco_pix.entity.Conta;
import com.banco.pix.banco_pix.repository.ContaRepository;
import com.banco.pix.banco_pix.validator.CpfCnpjValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class PixService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CpfCnpjValidator cpfCnpjValidator;

    @Autowired
    private ContaConverter contaConverter;


    public UUID criaConta(CriaChaveRequest conta){
        log.info("A conta esta aqui : {}", conta);
        log.info(String.valueOf(cpfCnpjValidator.isCpf(conta.getValorChave())));

        contaRepository.save(contaConverter.ConverterResquestToConta(conta));
    return null;
    }


}
