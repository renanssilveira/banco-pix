package com.banco.pix.banco_pix.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CriaChaveResponse {

    private UUID NumeroIdentificacao;
}
