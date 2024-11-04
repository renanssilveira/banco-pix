package com.banco.pix.banco_pix.converter;

import com.banco.pix.banco_pix.dtos.CriaChaveRequest;
import com.banco.pix.banco_pix.entity.Conta;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContaConverter {

    public Conta ConverterResquestToConta(CriaChaveRequest request) {
        return Conta.builder()
                .tipoChave(request.getTipoChave())
                .valorChave(request.getValorChave())
                .tipoConta(request.getTipoConta())
                .numeroAgencia(request.getNumeroAgencia())
                .numeroConta(request.getNumeroConta())
                .nomeCorrentista(request.getNomeCorrentista())
                .sobreNomeCorrentista(request.getSobreNomeCorrentista())
                .build();
    }
}
