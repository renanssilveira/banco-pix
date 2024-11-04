package com.banco.pix.bancopix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "conta")
@Table(name = "conta")
@Data
public class Conta {

    @Id
    @GeneratedValue
    private long id;
    private String perfil;
    private String numeroAgencia;
    private String numeroConta;

    public Conta() {
    }

}
