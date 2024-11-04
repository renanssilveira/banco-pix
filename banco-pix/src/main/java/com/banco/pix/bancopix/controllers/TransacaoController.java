package com.banco.pix.bancopix.controllers;


import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import com.banco.pix.bancopix.dtos.CriaChaveResponse;
import com.banco.pix.bancopix.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/pix")
public class TransacaoController {

    @Autowired
    private PixService pixService;

    @PostMapping("criar")
    public ResponseEntity<CriaChaveResponse> criaChavePix(@RequestBody @Valid CriaChaveRequest criaChaveRequest) {


        return ResponseEntity.ok(CriaChaveResponse.builder().NumeroIdentificacao(pixService.criaConta(criaChaveRequest)).build());


    }
}
