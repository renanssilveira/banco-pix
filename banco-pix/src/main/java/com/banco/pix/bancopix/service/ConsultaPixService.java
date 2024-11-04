package com.banco.pix.bancopix.service;


import com.banco.pix.bancopix.dtos.ConsultaChaveResponse;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.repository.ChaveRepository;
import com.banco.pix.bancopix.repository.ContaRepository;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsultaPixService {

  @Autowired private ChaveRepository chaveRepository;

  @Autowired private ContaRepository contaRepository;
  

  public ConsultaChaveResponse cadastraChavePix(String identificacao) {
    Optional<Chave> chave = chaveRepository.findByIdentificacaoId(identificacao);

    if(chave.isEmpty()){
      //TODO Criar uma Exception Cunstom para Consulta
    }
    return ConsultaChaveResponse.builder()
            .NumeroIdentificacao(String.valueOf(chave.get().getIdentificacaoId()))
            .tipoChave(chave.get().getTipoChave())
            .valorChave(chave.get().getValorChave())
            .tipoConta(chave.get().getTipoConta())
            .numeroAgencia(chave.get().getNumeroAgencia())
            .numeroConta(chave.get().getNumeroConta())
            .nomeCorrentista(chave.get().getNomeCorrentista())
            .sobreNomeCorrentista(chave.get().getSobreNomeCorrentista())
            .build();
  }

  public ConsultaChaveResponse cadastraByFilter(String identificacao) {
    Optional<Chave> chave = chaveRepository.findByIdentificacaoId(identificacao);

    if(chave.isEmpty()){
      //TODO Criar uma Exception Cunstom para Consulta
    }
    return ConsultaChaveResponse.builder()
            .NumeroIdentificacao(String.valueOf(chave.get().getIdentificacaoId()))
            .tipoChave(chave.get().getTipoChave())
            .valorChave(chave.get().getValorChave())
            .tipoConta(chave.get().getTipoConta())
            .numeroAgencia(chave.get().getNumeroAgencia())
            .numeroConta(chave.get().getNumeroConta())
            .nomeCorrentista(chave.get().getNomeCorrentista())
            .sobreNomeCorrentista(chave.get().getSobreNomeCorrentista())
            .build();
  }



 
}
