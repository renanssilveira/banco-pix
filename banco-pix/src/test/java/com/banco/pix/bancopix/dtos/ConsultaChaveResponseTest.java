package com.banco.pix.bancopix.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ConsultaChaveResponseTest {

    @Test
    public void testGettersWhenValuesAreSetThenReturnCorrectValues() {
        // Arrange
        String identificacao = "123456";
        String tipoChave = "CPF";
        String valorChave = "123.456.789-00";
        String tipoConta = "Corrente";
        String numeroAgencia = "0001";
        String numeroConta = "123456-7";
        String nomeCorrentista = "João";
        String sobreNomeCorrentista = "Silva";
        String dataInclusao = "2023-01-01";
        String dataInativacao = "2023-12-31";

        ConsultaChaveResponse response = ConsultaChaveResponse.builder()
                .identificacao(identificacao)
                .tipoChave(tipoChave)
                .valorChave(valorChave)
                .tipoConta(tipoConta)
                .numeroAgencia(numeroAgencia)
                .numeroConta(numeroConta)
                .nomeCorrentista(nomeCorrentista)
                .sobreNomeCorrentista(sobreNomeCorrentista)
                .dataInclusao(dataInclusao)
                .dataInativacao(dataInativacao)
                .build();

        // Act & Assert
        assertThat(response.getIdentificacao()).isEqualTo(identificacao);
        assertThat(response.getTipoChave()).isEqualTo(tipoChave);
        assertThat(response.getValorChave()).isEqualTo(valorChave);
        assertThat(response.getTipoConta()).isEqualTo(tipoConta);
        assertThat(response.getNumeroAgencia()).isEqualTo(numeroAgencia);
        assertThat(response.getNumeroConta()).isEqualTo(numeroConta);
        assertThat(response.getNomeCorrentista()).isEqualTo(nomeCorrentista);
        assertThat(response.getSobreNomeCorrentista()).isEqualTo(sobreNomeCorrentista);
        assertThat(response.getDataInclusao()).isEqualTo(dataInclusao);
        assertThat(response.getDataInativacao()).isEqualTo(dataInativacao);
    }
}
