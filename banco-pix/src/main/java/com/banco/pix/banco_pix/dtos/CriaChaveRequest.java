package com.banco.pix.banco_pix.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CriaChaveRequest {

    @NotNull(message = "O tipo da chave não pode ser Null")
    @NotBlank(message = "O tipo da chave não pode vazio")
    @NotEmpty
    String tipoChave;

    @NotNull(message = "A chave Pix não pode ser Null")
    @NotBlank(message = "A chave Pix não pode vazio ")
    @Size(max = 77, message = "O campo chave Pix tem o tamanho maximo de 77 caracteres")
    String valorChave;

    @NotNull(message = "A tipo de conta não pode ser Null")
    @NotBlank(message = "A tipo de conta não pode vazio ")
    String tipoConta;

    @NotNull(message = "A numero da agencia não pode ser Null")
    @NotBlank(message = "A numero da agencia não pode vazio ")
    @Size(max = 4, message = "O campo Agencia tem o tamanho maximo de 4 caracteres")
    String numeroAgencia;

    @NotNull(message = "O numero da conta não pode ser Null")
    @NotBlank(message = "O numero da conta não pode vazio ")
    @Size(max = 8, message = "O campo Conta tem o tamanho maximo de 8 caracteres")
    String numeroConta;

    @NotNull(message = "O nome do correntista não pode ser Null")
    @NotBlank(message = "O nome do correntista não pode vazio ")
    @Size(max = 30, message = "O campo Nome tem o tamanho maximo de 30 caracteres")
    String nomeCorrentista;

    @Size(max = 30, message = "O campo Nome tem o tamanho maximo de 30 caracteres")
    String sobreNomeCorrentista;
}
