package com.banco.pix.bancopix.controllers;

import com.banco.pix.bancopix.dtos.ConsultaChaveResponse;
import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import com.banco.pix.bancopix.dtos.CriaChaveResponse;
import com.banco.pix.bancopix.service.CadastraPixService;
import com.banco.pix.bancopix.service.ConsultaPixService;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pix")
public class TransacaoController {

  @Autowired private CadastraPixService cadastraPixService;
  @Autowired private ConsultaPixService consultaPixService;

  @PostMapping("/criar")
  public ResponseEntity<CriaChaveResponse> criaChavePix(
      @RequestBody @Valid CriaChaveRequest criaChaveRequest) {

    return ResponseEntity.ok(
        CriaChaveResponse.builder()
            .NumeroIdentificacao(cadastraPixService.cadastraChavePix(criaChaveRequest))
            .build());
  }

  @GetMapping("/consulta/filtros")
  public ResponseEntity<Set<ConsultaChaveResponse>> consultaByFilter(
      @RequestParam(required = false) String identificacao,
      @RequestParam(required = false) String tipoChave,
      @RequestParam(required = false) String agencia,
      @RequestParam(required = false) String conta,
      @RequestParam(required = false) String nome,
      @RequestParam(required = false) String dtInclusao,
      @RequestParam(required = false) String dtInativacao) {

    return ResponseEntity.ok(
        consultaPixService.consultaByFilter(
           identificacao, tipoChave, agencia, conta, nome, dtInclusao, dtInativacao));
  }
}
