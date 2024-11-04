package com.banco.pix.bancopix.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsultaChaveResponse {
    
    private String NumeroIdentificacao;
    private String tipoChave;
    private String valorChave;
    private String tipoConta;
    private String numeroAgencia;
    private String numeroConta;
    private String nomeCorrentista;
    private String sobreNomeCorrentista;
    private String dataInclusao;
    private String dataInativacao;
}
