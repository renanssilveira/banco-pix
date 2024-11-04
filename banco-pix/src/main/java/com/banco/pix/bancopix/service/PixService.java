package com.banco.pix.bancopix.service;

import com.banco.pix.bancopix.converter.ContaConverter;
import com.banco.pix.bancopix.domain.TipoChave;
import com.banco.pix.bancopix.domain.TipoConta;
import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import com.banco.pix.bancopix.entity.Conta;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.repository.ContaRepository;
import com.banco.pix.bancopix.validator.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
@Slf4j
public class PixService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CpfCnpjValidator cpfCnpjValidator;

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private ContaConverter contaConverter;

    @Autowired
    private CelularValidator celularValidator;

    @Autowired
    private AleatorioValidator aleatorioValidator;

    @Autowired
    private AgenciaValidator agenciaValidator;

    @Autowired
    private ContaValidator contaValidator;


    public String criaConta(CriaChaveRequest contaRequest) {
        log.info("A conta esta aqui : {}", contaRequest);

        TipoChave tipoChave = validaTipoChave(contaRequest.getTipoChave());

        switch (tipoChave) {
            case CPF -> validaCPF(contaRequest.getValorChave());
            case CNPJ -> validaCNPJ(contaRequest.getValorChave());
            case EMAIL -> validaEmail(contaRequest.getValorChave());
            case CELULAR -> validaCelular(contaRequest.getValorChave());
            case ALEATORIO -> validaAleatorio(contaRequest.getValorChave());
        }

        validaTipoConta(contaRequest.getTipoConta());
        validaAgencia(contaRequest.getNumeroAgencia());
        validaConta(contaRequest.getNumeroConta());


        Set<Conta> listaContas = listaContas(contaRequest.getNumeroAgencia(), contaRequest.getNumeroConta());
        Conta conta = new Conta(contaRequest);
        String id = contaRepository.save(conta).getId();

        return contaRepository.save(new Conta(contaRequest)).getId();
    }

    public TipoChave validaTipoChave(String chave) {
        try {
            return TipoChave.valueOf(chave.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new BancoFullException("Tipo de Chave Invalido");
        }
    }

    public void validaTipoConta(String tipoConta) {
        try {
            TipoConta.valueOf(tipoConta.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new BancoFullException("Tipo da Conta Invalido");
        }
    }

    public void validaCPF(String chave) {
        if (!cpfCnpjValidator.isCpf(chave)) {
            throw new BancoFullException("CPF invalido");
        }
    }

    public void validaCNPJ(String chave) {
        if (!cpfCnpjValidator.isCnpj(chave)) {
            throw new BancoFullException("CNPJ invalido");
        }
    }

    public void validaEmail(String chave) {
        if (!emailValidator.isValidEmailAddress(chave)) {
            throw new BancoFullException("EMAIL invalido");
        }
    }

    public void validaCelular(String chave) {
        if (!celularValidator.isValidCelular(chave)) {
            throw new BancoFullException("Celular invalido. Exemplo : +5511900000000");
        }
    }

    public void validaAleatorio(String chave) {
        if (!aleatorioValidator.isValidAleatorio(chave)) {
            throw new BancoFullException("Chave Aleatória invalida.");
        }
    }

    public void validaAgencia(String agencia) {
        if (!agenciaValidator.isValidAgencia(agencia)) {
            throw new BancoFullException("Numero da Agencia invalida.");
        }
    }

    public void validaConta(String conta) {
        if (!aleatorioValidator.isValidAleatorio(conta)) {
            throw new BancoFullException("Numero da Conta invalido.");
        }
    }

    public Set<Conta> listaContas(String agencia, String conta){
        return contaRepository.findBynumeroAgenciaAndnumeroConta(agencia, conta);
    }

}
