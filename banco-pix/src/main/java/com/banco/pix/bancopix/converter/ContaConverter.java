package com.banco.pix.bancopix.converter;

import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import com.banco.pix.bancopix.entity.Conta;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContaConverter {



/*    public Conta ConverterResquestToConta(CriaChaveRequest request) {
        return Conta.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .tipoChave(request.getTipoChave().toUpperCase())
                .valorChave(request.getValorChave())
                .tipoConta(request.getTipoConta().toUpperCase())
                .numeroAgencia(request.getNumeroAgencia())
                .numeroConta(request.getNumeroConta())
                .nomeCorrentista(request.getNomeCorrentista())
                .sobreNomeCorrentista(request.getSobreNomeCorrentista())
                .build();
    }*/
}
