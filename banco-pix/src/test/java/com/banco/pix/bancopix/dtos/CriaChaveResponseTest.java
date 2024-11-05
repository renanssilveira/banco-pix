package com.banco.pix.bancopix.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CriaChaveResponseTest {

    @Test
    public void testGetNumeroIdentificacaoWhenUUIDIsSetThenReturnUUID() {
        // Arrange
        UUID expectedUUID = UUID.randomUUID();
        CriaChaveResponse response = CriaChaveResponse.builder()
                .NumeroIdentificacao(expectedUUID)
                .build();

        // Act
        UUID actualUUID = response.getNumeroIdentificacao();

        // Assert
        Assertions.assertEquals(expectedUUID, actualUUID, "The UUID returned by getNumeroIdentificacao should match the expected UUID.");
    }

    @Test
    public void testSetNumeroIdentificacaoWhenUUIDIsSetThenReturnUUID() {
        // Arrange
        UUID expectedUUID = UUID.randomUUID();
        CriaChaveResponse response = CriaChaveResponse.builder().build();

        // Act
        response.setNumeroIdentificacao(expectedUUID);
        UUID actualUUID = response.getNumeroIdentificacao();

        // Assert
        Assertions.assertEquals(expectedUUID, actualUUID, "The UUID returned by getNumeroIdentificacao should match the expected UUID after setting it.");
    }
}
