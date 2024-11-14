package com.banco.pix.bancopix.dtos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EditaRequestTest {

    @Test
    public void testGettersAndSettersWhenValuesAreSetThenValuesAreRetrievedCorrectly() {
        // Arrange
        EditaRequest editaRequest = new EditaRequest();
        String id = "123";
        String tipoConta = "Corrente";
        String numeroAgencia = "001";
        String numeroConta = "123456";
        String nomeCorrentista = "John";
        String sobreNomeCorrentista = "Doe";

        // Act
        editaRequest.setId(id);
        editaRequest.setTipoConta(tipoConta);
        editaRequest.setNumeroAgencia(numeroAgencia);
        editaRequest.setNumeroConta(numeroConta);
        editaRequest.setNomeCorrentista(nomeCorrentista);
        editaRequest.setSobreNomeCorrentista(sobreNomeCorrentista);

        // Assert
        assertEquals(id, editaRequest.getId());
        assertEquals(tipoConta, editaRequest.getTipoConta());
        assertEquals(numeroAgencia, editaRequest.getNumeroAgencia());
        assertEquals(numeroConta, editaRequest.getNumeroConta());
        assertEquals(nomeCorrentista, editaRequest.getNomeCorrentista());
        assertEquals(sobreNomeCorrentista, editaRequest.getSobreNomeCorrentista());
    }
}
