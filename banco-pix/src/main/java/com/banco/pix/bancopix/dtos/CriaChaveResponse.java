package com.banco.pix.bancopix.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CriaChaveResponse {

    private UUID NumeroIdentificacao;
}
