package com.banco.pix.bancopix.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditaResponseTest {

  @Test
  public void testGetAndSetIdentificacaoWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "12345";

    // Act
    editaResponse.setIdentificacao(expectedValue);
    String actualValue = editaResponse.getIdentificacao();

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testGetAndSetTipoChaveWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "CPF";

    // Act
    editaResponse.setTipoChave(expectedValue);
    String actualValue = editaResponse.getTipoChave();

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testGetAndSetTipoContaWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "Corrente";

    // Act
    editaResponse.setTipoConta(expectedValue);
    String actualValue = editaResponse.getTipoConta();

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testGetAndSetNumeroAgenciaWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "001";

    // Act
    editaResponse.setNumeroAgencia(expectedValue);
    String actualValue = editaResponse.getNumeroAgencia();

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testGetAndSetNumeroContaWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "123456-7";

    // Act
    editaResponse.setNumeroConta(expectedValue);
    String actualValue = editaResponse.getNumeroConta();

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testGetAndSetNomeCorrentistaWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "John";

    // Act
    editaResponse.setNomeCorrentista(expectedValue);
    String actualValue = editaResponse.getNomeCorrentista();

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testGetAndSetSobreNomeCorrentistaWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "Doe";

    // Act
    editaResponse.setSobreNomeCorrentista(expectedValue);
    String actualValue = editaResponse.getSobreNomeCorrentista();

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void testGetAndSetDataInclusaoWhenValueIsSetThenValueIsReturned() {
    // Arrange
    EditaResponse editaResponse = EditaResponse.builder().build();
    String expectedValue = "2023-10-01";

    // Act
    editaResponse.setDataInclusao(expectedValue);
    String actualValue = editaResponse.getDataInclusao();

    // Assert
    assertEquals(expectedValue, actualValue);
  }
}
