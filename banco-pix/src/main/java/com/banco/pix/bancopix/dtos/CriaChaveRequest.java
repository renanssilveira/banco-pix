package com.banco.pix.bancopix.dtos;

import com.banco.pix.bancopix.domain.TipoChave;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CriaChaveRequest {

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
