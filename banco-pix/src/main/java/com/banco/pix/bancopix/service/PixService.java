package com.banco.pix.bancopix.service;

import com.banco.pix.bancopix.domain.TipoChave;
import com.banco.pix.bancopix.domain.TipoConta;
import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.entity.Conta;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.repository.ChaveRepository;
import com.banco.pix.bancopix.repository.ContaRepository;
import com.banco.pix.bancopix.validator.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class PixService {

  @Autowired private ChaveRepository chaveRepository;

  @Autowired private ContaRepository contaRepository;

  @Autowired private CpfCnpjValidator cpfCnpjValidator;

  @Autowired private EmailValidator emailValidator;

  @Autowired private CelularValidator celularValidator;

  @Autowired private AleatorioValidator aleatorioValidator;

  @Autowired private AgenciaValidator agenciaValidator;

  @Autowired private ContaValidator contaValidator;

  public UUID cadastraChavePix(CriaChaveRequest chaveRequest) {


    TipoChave tipoChave = validaTipoChave(chaveRequest.getTipoChave());

    switch (tipoChave) {
      case CPF -> validaCPF(chaveRequest.getValorChave());
      case CNPJ -> validaCNPJ(chaveRequest.getValorChave());
      case EMAIL -> validaEmail(chaveRequest.getValorChave());
      case CELULAR -> validaCelular(chaveRequest.getValorChave());
      case ALEATORIO -> validaAleatorio(chaveRequest.getValorChave());
    }

    validaChaveDuplicada(chaveRequest.getValorChave());
    validaTipoConta(chaveRequest.getTipoConta());
    validaAgencia(chaveRequest.getNumeroAgencia());
    validaConta(chaveRequest.getNumeroConta());
    validaQtdChaves(chaveRequest);

    return chaveRepository.save(new Chave(chaveRequest)).getIdentificacaoId();
  }

  public TipoChave validaTipoChave(@NotEmpty String chave) {
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

  public void validaQtdChaves(CriaChaveRequest chaveRequest) {
    Conta conta =
        contaRepository.findByNumeroAgenciaAndNumeroConta(
            chaveRequest.getNumeroAgencia(), chaveRequest.getNumeroConta());
    if (isNull(conta)) {
      throw new BancoFullException("Conta não Encontrada");
    }
    if (conta.getPerfil().equals("PF")) {
      log.info(
          String.valueOf(
              chaveRepository
                  .findByNumeroAgenciaAndNumeroConta(
                      chaveRequest.getNumeroAgencia(), chaveRequest.getNumeroConta())
                  .size()));
      if (chaveRepository
              .findByNumeroAgenciaAndNumeroConta(
                  chaveRequest.getNumeroAgencia(), chaveRequest.getNumeroConta())
              .size()
          >= 5) {
        throw new BancoFullException("Limite de Chave Atigido");
      }
    } else {
      if (chaveRepository
              .findByNumeroAgenciaAndNumeroConta(
                  chaveRequest.getNumeroAgencia(), chaveRequest.getNumeroConta())
              .size()
          >= 20) {
        throw new BancoFullException("Limite de Chave Atigido");
      }
    }
  }

  public void validaChaveDuplicada(String chave) {
    if (chaveRepository.findByValorChave(chave).isPresent()) {
      throw new BancoFullException("Chave ja cadastrada");
    }
  }
}
