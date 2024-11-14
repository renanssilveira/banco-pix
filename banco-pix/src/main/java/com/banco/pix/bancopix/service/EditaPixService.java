package com.banco.pix.bancopix.service;

import static java.util.Objects.nonNull;

import com.banco.pix.bancopix.domain.TipoConta;
import com.banco.pix.bancopix.dtos.EditaRequest;
import com.banco.pix.bancopix.dtos.EditaResponse;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.exceptions.BancoNotFoundException;
import com.banco.pix.bancopix.repository.ChaveRepository;
import com.banco.pix.bancopix.validator.AgenciaValidator;
import com.banco.pix.bancopix.validator.ContaValidator;
import com.banco.pix.bancopix.validator.NomeValidator;
import com.banco.pix.bancopix.validator.SobreNomeValidator;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EditaPixService {

  @Autowired private ChaveRepository chaveRepository;
  @Autowired private AgenciaValidator agenciaValidator;
  @Autowired private ContaValidator contaValidator;
  @Autowired private NomeValidator nomeValidator;
  @Autowired private SobreNomeValidator sobreNomeValidator;
  

  public EditaResponse editaConta(EditaRequest editaRequest){
    validaTipoConta(editaRequest.getTipoConta());
    validaAgencia(editaRequest.getNumeroAgencia());
    validaConta(editaRequest.getNumeroConta());
    validaNome(editaRequest.getNomeCorrentista());
    validaSobreNome(editaRequest.getSobreNomeCorrentista());

    Optional<Chave> chave = chaveRepository.findByIdentificacaoId(editaRequest.getId());
    if(!chave.isPresent()){
      throw new BancoNotFoundException();
    }
    if(nonNull(chave.get().getDataInativacao())){
      throw new BancoFullException("Chave Inativa");
    }

    editeConta(editaRequest, chave);
    chaveRepository.save(chave.get());
    return EditaResponse.builder()
            .identificacao(String.valueOf(chave.get().getIdentificacaoId()))
            .tipoChave(chave.get().getTipoChave())
            .tipoConta(chave.get().getTipoConta())
            .numeroAgencia(chave.get().getNumeroAgencia())
            .numeroConta(chave.get().getNumeroConta())
            .nomeCorrentista(chave.get().getNomeCorrentista())
            .sobreNomeCorrentista(chave.get().getSobreNomeCorrentista())
            .dataInclusao(chave.get().getDataInclusao())
            .build();
  }

  private static void editeConta(EditaRequest editaRequest, Optional<Chave> chave) {
    chave.get().setTipoConta(editaRequest.getTipoConta());
    chave.get().setNumeroAgencia(editaRequest.getNumeroAgencia());
    chave.get().setNumeroConta(editaRequest.getTipoConta());
    chave.get().setNomeCorrentista(editaRequest.getNomeCorrentista());
    chave.get().setSobreNomeCorrentista(editaRequest.getSobreNomeCorrentista());
  }

  public void validaTipoConta(String tipoConta) {
    try {
      TipoConta.valueOf(tipoConta.toUpperCase());
    } catch (IllegalArgumentException exception) {
      throw new BancoFullException("Tipo da Conta Invalido");
    }
  }
  public void validaAgencia(String agencia) {
    if (!agenciaValidator.isValidAgencia(agencia)) {
      throw new BancoFullException("Numero da Agencia invalida.");
    }
  }

  public void validaConta(String conta) {
    if (!contaValidator.isValidConta(conta)) {
      throw new BancoFullException("Numero da Conta invalido.");
    }
  }

  public void validaNome(String nome){
    if (!nomeValidator.isValidNome(nome)) {
      throw new BancoFullException("Nome invalido.");
    }
  }

  public void validaSobreNome(String sobreNome){
    if (!sobreNomeValidator.isValidSobreNome(sobreNome)) {
      throw new BancoFullException("SobreNome invalido.");
    }
  }
}
