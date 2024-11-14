package com.banco.pix.bancopix.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EditaRequest {

  @NotEmpty
  String id;

  @NotEmpty String tipoConta;

  @NotEmpty String numeroAgencia;

  @NotEmpty String numeroConta;

  @NotEmpty String nomeCorrentista;

  String sobreNomeCorrentista;
}
