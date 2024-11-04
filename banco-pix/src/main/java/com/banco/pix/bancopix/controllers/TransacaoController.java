package com.banco.pix.bancopix.controllers;

import com.banco.pix.bancopix.dtos.ConsultaChaveResponse;
import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import com.banco.pix.bancopix.dtos.CriaChaveResponse;
import com.banco.pix.bancopix.service.CadastraPixService;
import com.banco.pix.bancopix.service.ConsultaPixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

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

  @GetMapping("/consulta/identificacao/{identificacao}")
  public ResponseEntity<ConsultaChaveResponse> criaChavePix(
      @PathVariable @NotEmpty String identificacao) {
    return ResponseEntity.ok(consultaPixService.cadastraChavePix(identificacao));
  }

  @GetMapping("/consulta/filtros")
  public ResponseEntity<ConsultaChaveResponse> consultaByFilter(
      @RequestParam String tipoChave,
      @RequestParam String agenciaConta,
      @RequestParam String nome,
      @RequestParam String dtInclusao,
      @RequestParam String dtInativacao) {

    return null;

  }
}
