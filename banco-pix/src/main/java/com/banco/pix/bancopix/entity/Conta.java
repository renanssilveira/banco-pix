package com.banco.pix.bancopix.entity;

import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "contas")
@Table(name = "contas")
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String tipoChave;
    private String valorChave;
    private String tipoConta;
    private String numeroAgencia;
    private String numeroConta;
    private String nomeCorrentista;
    private String sobreNomeCorrentista;


    public Conta(CriaChaveRequest request) {
        this.tipoChave = request.getTipoChave().toUpperCase();
        this.valorChave = request.getValorChave();
        this.tipoConta = request.getTipoConta().toUpperCase();
        this.numeroAgencia = request.getNumeroAgencia();
        this.numeroConta = request.getNumeroConta();
        this.nomeCorrentista = request.getNomeCorrentista();
        this.sobreNomeCorrentista = request.getSobreNomeCorrentista();
    }
}
