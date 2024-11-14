package com.banco.pix.bancopix.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditaResponse {

    @JsonProperty(value = "UUID")
    private String identificacao;
    private String tipoChave;
    private String tipoConta;
    private String numeroAgencia;
    private String numeroConta;
    private String nomeCorrentista;
    private String sobreNomeCorrentista;
    private String dataInclusao;
}
