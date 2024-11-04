package com.banco.pix.bancopix.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CriaChaveRequest {

    String id;

    @NotEmpty
    String tipoChave;

    @NotEmpty
    String valorChave;

    @NotEmpty
    String tipoConta;

    @NotEmpty
    String numeroAgencia;

    @NotEmpty
    String numeroConta;

    @NotEmpty
    String nomeCorrentista;

    String sobreNomeCorrentista;
}
