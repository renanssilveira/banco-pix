package com.banco.pix.bancopix.controllers;

import com.banco.pix.bancopix.dtos.*;
import com.banco.pix.bancopix.service.CadastraPixService;
import com.banco.pix.bancopix.service.ConsultaPixService;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.banco.pix.bancopix.service.DeletaPixService;
import com.banco.pix.bancopix.service.EditaPixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pix")
public class TransacaoController {

  @Autowired private CadastraPixService cadastraPixService;
  @Autowired private ConsultaPixService consultaPixService;
  @Autowired private EditaPixService editaPixService;
  @Autowired private DeletaPixService deletaPixService;

  @PostMapping()
  public ResponseEntity<CriaChaveResponse> criaChavePix(
      @RequestBody @Valid CriaChaveRequest criaChaveRequest) {

    return ResponseEntity.ok(
        CriaChaveResponse.builder()
            .NumeroIdentificacao(cadastraPixService.cadastraChavePix(criaChaveRequest))
            .build());
  }

  @GetMapping("/filtros")
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

  @PatchMapping()
  public ResponseEntity<EditaResponse> editacaoConta(@RequestBody @Valid EditaRequest editaRequest){

    return ResponseEntity.ok(editaPixService.editaConta(editaRequest));
  }

  @DeleteMapping("/identificacao/{identificacao}")
  public ResponseEntity<DeletaChaveResponse> deletaChave(@PathVariable String identificacao){

    return ResponseEntity.ok(deletaPixService.deletaChave(identificacao));
  }
}
