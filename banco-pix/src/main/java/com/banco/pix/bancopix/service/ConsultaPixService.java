package com.banco.pix.bancopix.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.banco.pix.bancopix.dtos.ConsultaChaveResponse;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.exceptions.BancoNotFoundException;
import com.banco.pix.bancopix.repository.ChaveRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsultaPixService {

  @Autowired private ChaveRepository chaveRepository;
  

  public Set<ConsultaChaveResponse> consultaByFilter(
      String identificacao,
      String tipoChave,
      String agencia,
      String conta,
      String nome,
      String dtInclusao,
      String dtInativacao) {

    Set<ConsultaChaveResponse> listaResponse = new HashSet<>();

    if (nonNull(identificacao) && !identificacao.isEmpty()) {
      listaResponse.add(findByIdentificacao(identificacao));
    }

    List<Chave> chaves = chaveRepository.findAll();

    chaves = listaChaveByFilter(tipoChave, agencia, conta, nome, dtInclusao, dtInativacao, chaves);

    validateIdentificacaoFilter(
        identificacao, tipoChave, agencia, conta, nome, dtInclusao, dtInativacao);
    chaves.forEach(
        chave -> {
          listaResponse.add(
              ConsultaChaveResponse.builder()
                  .identificacao(String.valueOf(chave.getIdentificacaoId()))
                  .tipoChave(chave.getTipoChave())
                  .valorChave(chave.getValorChave())
                  .tipoConta(chave.getTipoConta())
                  .tipoConta(chave.getTipoConta())
                  .numeroAgencia(chave.getNumeroAgencia())
                  .numeroConta(chave.getNumeroConta())
                  .nomeCorrentista(chave.getNomeCorrentista())
                  .sobreNomeCorrentista(chave.getSobreNomeCorrentista())
                  .dataInclusao(
                      LocalDateTime.parse(chave.getDataInclusao())
                          .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                  .dataInativacao(
                      isNull(chave.getDataInativacao()) ? "" : chave.getDataInativacao())
                  .build());
        });
    if(listaResponse.isEmpty()){
      throw new BancoNotFoundException("Nenhum registro encontrado");
    }

    return listaResponse;
  }

  private static List<Chave> listaChaveByFilter(
      String tipoChave,
      String agencia,
      String conta,
      String nome,
      String dtInclusao,
      String dtInativacao,
      List<Chave> chaves) {
    if (nonNull(tipoChave) && !tipoChave.isEmpty()) {
      chaves =
          chaves.stream()
              .filter(chave -> chave.getTipoChave().equalsIgnoreCase(tipoChave))
              .toList();
    }

    if (nonNull(agencia) && !agencia.isEmpty() && nonNull(conta) && !conta.isEmpty()) {
      chaves =
          chaves.stream()
              .filter(
                  chave ->
                      chave.getNumeroAgencia().equals(agencia)
                          && chave.getNumeroConta().equals(conta))
              .toList();
    }

    if (nonNull(nome) && !nome.isEmpty()) {
      chaves =
          chaves.stream()
              .filter(chave -> chave.getNomeCorrentista().equalsIgnoreCase(nome))
              .toList();
    }

    if (nonNull(dtInclusao) && !dtInclusao.isEmpty()) {
      chaves =
          chaves.stream()
              .filter(
                  chave ->
                      LocalDateTime.parse(chave.getDataInclusao())
                          .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                          .equals(dtInclusao))
              .toList();
    }

    if ((nonNull(dtInativacao) && !dtInativacao.isEmpty())) {
      if ((nonNull(dtInclusao) && !dtInclusao.isEmpty())) {
        throw new BancoFullException("Não é possivel comparar a Data de Inclusão com a Inativação");
      }

      chaves =
          chaves.stream()
              .filter(
                  chave -> {
                    if (nonNull(chave.getDataInativacao())
                        && LocalDateTime.parse(chave.getDataInativacao())
                            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                            .equals(dtInativacao)) {
                      return true;
                    }
                    return false;
                  })
              .toList();
    }
    return chaves;
  }

  public ConsultaChaveResponse findByIdentificacao(String identificacao) {
    Optional<Chave> chave = chaveRepository.findByIdentificacaoId(identificacao);
    if (chave.isEmpty()) {
      throw new BancoNotFoundException();
    } else {
      return ConsultaChaveResponse.builder()
          .identificacao(String.valueOf(chave.get().getIdentificacaoId()))
          .tipoChave(chave.get().getTipoChave())
          .valorChave(chave.get().getValorChave())
          .tipoConta(chave.get().getTipoConta())
          .tipoConta(chave.get().getTipoConta())
          .numeroAgencia(chave.get().getNumeroAgencia())
          .numeroConta(chave.get().getNumeroConta())
          .nomeCorrentista(chave.get().getNomeCorrentista())
          .sobreNomeCorrentista(chave.get().getSobreNomeCorrentista())
          .dataInclusao(
              LocalDateTime.parse(chave.get().getDataInclusao())
                  .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
          .dataInativacao(
              isNull(chave.get().getDataInativacao())
                  ? ""
                  : LocalDateTime.parse(chave.get().getDataInativacao())
                      .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
          .build();
    }
  }

  public void validateIdentificacaoFilter(
      String identificacao,
      String tipoChave,
      String agencia,
      String conta,
      String nome,
      String dtInclusao,
      String dtInativacao) {
    if ((nonNull(identificacao))
        && (nonNull(tipoChave)
            || nonNull(agencia)
            || nonNull(conta)
            || nonNull(nome)
            || nonNull(dtInclusao)
            || nonNull(dtInativacao))) {
      throw new BancoFullException("O campo identificação não pode ser composto com mais filtros");
    }
  }
}
