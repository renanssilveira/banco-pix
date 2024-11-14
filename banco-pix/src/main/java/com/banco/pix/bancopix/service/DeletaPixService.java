package com.banco.pix.bancopix.service;


import com.banco.pix.bancopix.dtos.DeletaChaveResponse;
import com.banco.pix.bancopix.dtos.EditaRequest;
import com.banco.pix.bancopix.dtos.EditaResponse;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.exceptions.BancoNotFoundException;
import com.banco.pix.bancopix.repository.ChaveRepository;

import java.time.LocalDateTime;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@Slf4j
public class DeletaPixService {

  @Autowired private ChaveRepository chaveRepository;

  public DeletaChaveResponse deletaChave(String identificacao) {
    Optional<Chave> chave = chaveRepository.findByIdentificacaoId(identificacao);
    if(!chave.isPresent()){
      throw new BancoNotFoundException();
    }
    if(nonNull(chave.get().getDataInativacao())){
      throw new BancoFullException("Chave Inativa");
    }
    incluiDtInativacao(chave);
    chaveRepository.save(chave.get());
    return DeletaChaveResponse.builder()
            .identificacao(String.valueOf(chave.get().getIdentificacaoId()))
            .tipoChave(chave.get().getTipoChave())
            .valorChave(chave.get().getValorChave())
            .tipoConta(chave.get().getTipoConta())
            .numeroAgencia(chave.get().getNumeroAgencia())
            .numeroConta(chave.get().getNumeroConta())
            .nomeCorrentista(chave.get().getNomeCorrentista())
            .sobreNomeCorrentista(chave.get().getSobreNomeCorrentista())
            .dataInclusao(chave.get().getDataInclusao())
            .dataInativacao(chave.get().getDataInativacao())
            .build();
  }

  private static void incluiDtInativacao(Optional<Chave> chave) {
    Locale loc = new Locale("pt", "BR");
    Locale.setDefault(loc);
    chave.get().setDataInativacao(LocalDateTime.now().toString());

  }
}
