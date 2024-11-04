package com.banco.pix.banco_pix.controllers;


import com.banco.pix.banco_pix.dtos.CriaChaveRequest;
import com.banco.pix.banco_pix.dtos.CriaChaveResponse;
import com.banco.pix.banco_pix.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pix")
public class TransacaoController {

    @Autowired
    private PixService pixService;

    @PostMapping("criar")
    public ResponseEntity<String> criaChavePix(@RequestBody @Valid CriaChaveRequest criaChaveRequest) {
         pixService.criaConta(criaChaveRequest);

        //return ResponseEntity.ok(CriaChaveResponse.builder().NumeroIdentificacao(UUID.randomUUID()).build());
        return  ResponseEntity.ok(null);


    }
}
