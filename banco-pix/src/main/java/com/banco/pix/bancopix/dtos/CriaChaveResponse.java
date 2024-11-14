package com.banco.pix.bancopix.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CriaChaveResponse {

    @JsonProperty(value = "UUID")
    private UUID NumeroIdentificacao;
}
