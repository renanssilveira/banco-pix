package com.banco.pix.bancopix.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CriaChaveRequestTest {

    private CriaChaveRequest criaChaveRequest;

    @BeforeEach
    public void setUp() {
        criaChaveRequest = new CriaChaveRequest();
    }

    @Test
    public void testGetIdWhenIdIsSetThenReturnId() {
        // Arrange
        String expectedId = "12345";
        criaChaveRequest.setId(expectedId);

        // Act
        String actualId = criaChaveRequest.getId();

        // Assert
        assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    public void testSetIdWhenIdIsSetThenReturnId() {
        // Arrange
        String expectedId = "12345";

        // Act
        criaChaveRequest.setId(expectedId);
        String actualId = criaChaveRequest.getId();

        // Assert
        assertThat(actualId).isEqualTo(expectedId);
    }

    @Test
    public void testGetTipoChaveWhenTipoChaveIsSetThenReturnTipoChave() {
        // Arrange
        String expectedTipoChave = "CPF";
        criaChaveRequest.setTipoChave(expectedTipoChave);

        // Act
        String actualTipoChave = criaChaveRequest.getTipoChave();

        // Assert
        assertThat(actualTipoChave).isEqualTo(expectedTipoChave);
    }

    @Test
    public void testSetTipoChaveWhenTipoChaveIsSetThenReturnTipoChave() {
        // Arrange
        String expectedTipoChave = "CPF";

        // Act
        criaChaveRequest.setTipoChave(expectedTipoChave);
        String actualTipoChave = criaChaveRequest.getTipoChave();

        // Assert
        assertThat(actualTipoChave).isEqualTo(expectedTipoChave);
    }

    @Test
    public void testGetValorChaveWhenValorChaveIsSetThenReturnValorChave() {
        // Arrange
        String expectedValorChave = "12345678900";
        criaChaveRequest.setValorChave(expectedValorChave);

        // Act
        String actualValorChave = criaChaveRequest.getValorChave();

        // Assert
        assertThat(actualValorChave).isEqualTo(expectedValorChave);
    }

    @Test
    public void testSetValorChaveWhenValorChaveIsSetThenReturnValorChave() {
        // Arrange
        String expectedValorChave = "12345678900";

        // Act
        criaChaveRequest.setValorChave(expectedValorChave);
        String actualValorChave = criaChaveRequest.getValorChave();

        // Assert
        assertThat(actualValorChave).isEqualTo(expectedValorChave);
    }

    @Test
    public void testGetTipoContaWhenTipoContaIsSetThenReturnTipoConta() {
        // Arrange
        String expectedTipoConta = "Corrente";
        criaChaveRequest.setTipoConta(expectedTipoConta);

        // Act
        String actualTipoConta = criaChaveRequest.getTipoConta();

        // Assert
        assertThat(actualTipoConta).isEqualTo(expectedTipoConta);
    }

    @Test
    public void testSetTipoContaWhenTipoContaIsSetThenReturnTipoConta() {
        // Arrange
        String expectedTipoConta = "Corrente";

        // Act
        criaChaveRequest.setTipoConta(expectedTipoConta);
        String actualTipoConta = criaChaveRequest.getTipoConta();

        // Assert
        assertThat(actualTipoConta).isEqualTo(expectedTipoConta);
    }

    @Test
    public void testGetNumeroAgenciaWhenNumeroAgenciaIsSetThenReturnNumeroAgencia() {
        // Arrange
        String expectedNumeroAgencia = "1234";
        criaChaveRequest.setNumeroAgencia(expectedNumeroAgencia);

        // Act
        String actualNumeroAgencia = criaChaveRequest.getNumeroAgencia();

        // Assert
        assertThat(actualNumeroAgencia).isEqualTo(expectedNumeroAgencia);
    }

    @Test
    public void testSetNumeroAgenciaWhenNumeroAgenciaIsSetThenReturnNumeroAgencia() {
        // Arrange
        String expectedNumeroAgencia = "1234";

        // Act
        criaChaveRequest.setNumeroAgencia(expectedNumeroAgencia);
        String actualNumeroAgencia = criaChaveRequest.getNumeroAgencia();

        // Assert
        assertThat(actualNumeroAgencia).isEqualTo(expectedNumeroAgencia);
    }

    @Test
    public void testGetNumeroContaWhenNumeroContaIsSetThenReturnNumeroConta() {
        // Arrange
        String expectedNumeroConta = "56789";
        criaChaveRequest.setNumeroConta(expectedNumeroConta);

        // Act
        String actualNumeroConta = criaChaveRequest.getNumeroConta();

        // Assert
        assertThat(actualNumeroConta).isEqualTo(expectedNumeroConta);
    }

    @Test
    public void testSetNumeroContaWhenNumeroContaIsSetThenReturnNumeroConta() {
        // Arrange
        String expectedNumeroConta = "56789";

        // Act
        criaChaveRequest.setNumeroConta(expectedNumeroConta);
        String actualNumeroConta = criaChaveRequest.getNumeroConta();

        // Assert
        assertThat(actualNumeroConta).isEqualTo(expectedNumeroConta);
    }

    @Test
    public void testGetNomeCorrentistaWhenNomeCorrentistaIsSetThenReturnNomeCorrentista() {
        // Arrange
        String expectedNomeCorrentista = "John";
        criaChaveRequest.setNomeCorrentista(expectedNomeCorrentista);

        // Act
        String actualNomeCorrentista = criaChaveRequest.getNomeCorrentista();

        // Assert
        assertThat(actualNomeCorrentista).isEqualTo(expectedNomeCorrentista);
    }

    @Test
    public void testSetNomeCorrentistaWhenNomeCorrentistaIsSetThenReturnNomeCorrentista() {
        // Arrange
        String expectedNomeCorrentista = "John";

        // Act
        criaChaveRequest.setNomeCorrentista(expectedNomeCorrentista);
        String actualNomeCorrentista = criaChaveRequest.getNomeCorrentista();

        // Assert
        assertThat(actualNomeCorrentista).isEqualTo(expectedNomeCorrentista);
    }

    @Test
    public void testGetSobreNomeCorrentistaWhenSobreNomeCorrentistaIsSetThenReturnSobreNomeCorrentista() {
        // Arrange
        String expectedSobreNomeCorrentista = "Doe";
        criaChaveRequest.setSobreNomeCorrentista(expectedSobreNomeCorrentista);

        // Act
        String actualSobreNomeCorrentista = criaChaveRequest.getSobreNomeCorrentista();

        // Assert
        assertThat(actualSobreNomeCorrentista).isEqualTo(expectedSobreNomeCorrentista);
    }

    @Test
    public void testSetSobreNomeCorrentistaWhenSobreNomeCorrentistaIsSetThenReturnSobreNomeCorrentista() {
        // Arrange
        String expectedSobreNomeCorrentista = "Doe";

        // Act
        criaChaveRequest.setSobreNomeCorrentista(expectedSobreNomeCorrentista);
        String actualSobreNomeCorrentista = criaChaveRequest.getSobreNomeCorrentista();

        // Assert
        assertThat(actualSobreNomeCorrentista).isEqualTo(expectedSobreNomeCorrentista);
    }
}
