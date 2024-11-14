package com.banco.pix.bancopix.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class DeletaChaveResponseTest {

    @Test
    public void testGetIdentificacaoWhenIdentificacaoIsSetThenReturnIdentificacao() {
        // Arrange
        String expectedIdentificacao = "12345";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .identificacao(expectedIdentificacao)
                .build();

        // Act
        String actualIdentificacao = response.getIdentificacao();

        // Assert
        assertThat(actualIdentificacao).isEqualTo(expectedIdentificacao);
    }

    @Test
    public void testSetIdentificacaoWhenIdentificacaoIsSetThenReturnIdentificacao() {
        // Arrange
        String expectedIdentificacao = "12345";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setIdentificacao(expectedIdentificacao);
        String actualIdentificacao = response.getIdentificacao();

        // Assert
        assertThat(actualIdentificacao).isEqualTo(expectedIdentificacao);
    }

    @Test
    public void testGetTipoChaveWhenTipoChaveIsSetThenReturnTipoChave() {
        // Arrange
        String expectedTipoChave = "CPF";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .tipoChave(expectedTipoChave)
                .build();

        // Act
        String actualTipoChave = response.getTipoChave();

        // Assert
        assertThat(actualTipoChave).isEqualTo(expectedTipoChave);
    }

    @Test
    public void testSetTipoChaveWhenTipoChaveIsSetThenReturnTipoChave() {
        // Arrange
        String expectedTipoChave = "CPF";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setTipoChave(expectedTipoChave);
        String actualTipoChave = response.getTipoChave();

        // Assert
        assertThat(actualTipoChave).isEqualTo(expectedTipoChave);
    }

    @Test
    public void testGetValorChaveWhenValorChaveIsSetThenReturnValorChave() {
        // Arrange
        String expectedValorChave = "12345678900";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .valorChave(expectedValorChave)
                .build();

        // Act
        String actualValorChave = response.getValorChave();

        // Assert
        assertThat(actualValorChave).isEqualTo(expectedValorChave);
    }

    @Test
    public void testSetValorChaveWhenValorChaveIsSetThenReturnValorChave() {
        // Arrange
        String expectedValorChave = "12345678900";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setValorChave(expectedValorChave);
        String actualValorChave = response.getValorChave();

        // Assert
        assertThat(actualValorChave).isEqualTo(expectedValorChave);
    }

    @Test
    public void testGetTipoContaWhenTipoContaIsSetThenReturnTipoConta() {
        // Arrange
        String expectedTipoConta = "Corrente";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .tipoConta(expectedTipoConta)
                .build();

        // Act
        String actualTipoConta = response.getTipoConta();

        // Assert
        assertThat(actualTipoConta).isEqualTo(expectedTipoConta);
    }

    @Test
    public void testSetTipoContaWhenTipoContaIsSetThenReturnTipoConta() {
        // Arrange
        String expectedTipoConta = "Corrente";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setTipoConta(expectedTipoConta);
        String actualTipoConta = response.getTipoConta();

        // Assert
        assertThat(actualTipoConta).isEqualTo(expectedTipoConta);
    }

    @Test
    public void testGetNumeroAgenciaWhenNumeroAgenciaIsSetThenReturnNumeroAgencia() {
        // Arrange
        String expectedNumeroAgencia = "0001";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .numeroAgencia(expectedNumeroAgencia)
                .build();

        // Act
        String actualNumeroAgencia = response.getNumeroAgencia();

        // Assert
        assertThat(actualNumeroAgencia).isEqualTo(expectedNumeroAgencia);
    }

    @Test
    public void testSetNumeroAgenciaWhenNumeroAgenciaIsSetThenReturnNumeroAgencia() {
        // Arrange
        String expectedNumeroAgencia = "0001";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setNumeroAgencia(expectedNumeroAgencia);
        String actualNumeroAgencia = response.getNumeroAgencia();

        // Assert
        assertThat(actualNumeroAgencia).isEqualTo(expectedNumeroAgencia);
    }

    @Test
    public void testGetNumeroContaWhenNumeroContaIsSetThenReturnNumeroConta() {
        // Arrange
        String expectedNumeroConta = "123456";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .numeroConta(expectedNumeroConta)
                .build();

        // Act
        String actualNumeroConta = response.getNumeroConta();

        // Assert
        assertThat(actualNumeroConta).isEqualTo(expectedNumeroConta);
    }

    @Test
    public void testSetNumeroContaWhenNumeroContaIsSetThenReturnNumeroConta() {
        // Arrange
        String expectedNumeroConta = "123456";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setNumeroConta(expectedNumeroConta);
        String actualNumeroConta = response.getNumeroConta();

        // Assert
        assertThat(actualNumeroConta).isEqualTo(expectedNumeroConta);
    }

    @Test
    public void testGetNomeCorrentistaWhenNomeCorrentistaIsSetThenReturnNomeCorrentista() {
        // Arrange
        String expectedNomeCorrentista = "John";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .nomeCorrentista(expectedNomeCorrentista)
                .build();

        // Act
        String actualNomeCorrentista = response.getNomeCorrentista();

        // Assert
        assertThat(actualNomeCorrentista).isEqualTo(expectedNomeCorrentista);
    }

    @Test
    public void testSetNomeCorrentistaWhenNomeCorrentistaIsSetThenReturnNomeCorrentista() {
        // Arrange
        String expectedNomeCorrentista = "John";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setNomeCorrentista(expectedNomeCorrentista);
        String actualNomeCorrentista = response.getNomeCorrentista();

        // Assert
        assertThat(actualNomeCorrentista).isEqualTo(expectedNomeCorrentista);
    }

    @Test
    public void testGetSobreNomeCorrentistaWhenSobreNomeCorrentistaIsSetThenReturnSobreNomeCorrentista() {
        // Arrange
        String expectedSobreNomeCorrentista = "Doe";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .sobreNomeCorrentista(expectedSobreNomeCorrentista)
                .build();

        // Act
        String actualSobreNomeCorrentista = response.getSobreNomeCorrentista();

        // Assert
        assertThat(actualSobreNomeCorrentista).isEqualTo(expectedSobreNomeCorrentista);
    }

    @Test
    public void testSetSobreNomeCorrentistaWhenSobreNomeCorrentistaIsSetThenReturnSobreNomeCorrentista() {
        // Arrange
        String expectedSobreNomeCorrentista = "Doe";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setSobreNomeCorrentista(expectedSobreNomeCorrentista);
        String actualSobreNomeCorrentista = response.getSobreNomeCorrentista();

        // Assert
        assertThat(actualSobreNomeCorrentista).isEqualTo(expectedSobreNomeCorrentista);
    }

    @Test
    public void testGetDataInclusaoWhenDataInclusaoIsSetThenReturnDataInclusao() {
        // Arrange
        String expectedDataInclusao = "2023-01-01";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .dataInclusao(expectedDataInclusao)
                .build();

        // Act
        String actualDataInclusao = response.getDataInclusao();

        // Assert
        assertThat(actualDataInclusao).isEqualTo(expectedDataInclusao);
    }

    @Test
    public void testSetDataInclusaoWhenDataInclusaoIsSetThenReturnDataInclusao() {
        // Arrange
        String expectedDataInclusao = "2023-01-01";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setDataInclusao(expectedDataInclusao);
        String actualDataInclusao = response.getDataInclusao();

        // Assert
        assertThat(actualDataInclusao).isEqualTo(expectedDataInclusao);
    }

    @Test
    public void testGetDataInativacaoWhenDataInativacaoIsSetThenReturnDataInativacao() {
        // Arrange
        String expectedDataInativacao = "2023-12-31";
        DeletaChaveResponse response = DeletaChaveResponse.builder()
                .dataInativacao(expectedDataInativacao)
                .build();

        // Act
        String actualDataInativacao = response.getDataInativacao();

        // Assert
        assertThat(actualDataInativacao).isEqualTo(expectedDataInativacao);
    }

    @Test
    public void testSetDataInativacaoWhenDataInativacaoIsSetThenReturnDataInativacao() {
        // Arrange
        String expectedDataInativacao = "2023-12-31";
        DeletaChaveResponse response = DeletaChaveResponse.builder().build();
        
        // Act
        response.setDataInativacao(expectedDataInativacao);
        String actualDataInativacao = response.getDataInativacao();

        // Assert
        assertThat(actualDataInativacao).isEqualTo(expectedDataInativacao);
    }
}
