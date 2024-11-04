package com.banco.pix.bancopix.entity;

import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

@Entity(name = "chave")
@Table(name = "chave")
@Data
public class Chave {

    @Id
    @GeneratedValue
    private long id;
    private String identificacaoId;
    private String tipoChave;
    private String valorChave;
    private String tipoConta;
    private String numeroAgencia;
    private String numeroConta;
    private String nomeCorrentista;
    private String sobreNomeCorrentista;
    private String dataInclusao;
    private String dataInativacao;

    public Chave() {
    }


    public Chave(CriaChaveRequest request) {
        this.identificacaoId = String.valueOf(UUID.randomUUID());
        this.tipoChave = request.getTipoChave().toUpperCase();
        this.valorChave = request.getValorChave();
        this.tipoConta = request.getTipoConta().toUpperCase();
        this.numeroAgencia = request.getNumeroAgencia();
        this.numeroConta = request.getNumeroConta();
        this.nomeCorrentista = request.getNomeCorrentista();
        this.sobreNomeCorrentista = request.getSobreNomeCorrentista();
        Locale loc = new Locale("pt", "BR");
        Locale.setDefault(loc);

        this.dataInclusao = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public UUID getIdentificacaoId() {
        return identificacaoId != null ? UUID.fromString(identificacaoId) : null;
    }

    public void setIdentificacaoId(UUID uuid) {
        this.identificacaoId = uuid != null ? uuid.toString() : null;
    }
}
