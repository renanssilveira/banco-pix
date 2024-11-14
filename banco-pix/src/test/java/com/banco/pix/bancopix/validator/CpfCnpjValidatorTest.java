package com.banco.pix.bancopix.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CpfCnpjValidatorTest {

    @InjectMocks
    private CpfCnpjValidator cpfCnpjValidator;

    @Test
    public void testIsCpfWhenValidCpfThenReturnTrue() {
        // Arrange
        String validCpf = "123.456.789-09"; // Replace with a valid CPF for the test

        // Act
        boolean result = cpfCnpjValidator.isCpf(validCpf);

        // Assert
        assertTrue(result, "The isCpf method should return true for a valid CPF");
    }

    @Test
    public void testIsCpfWhenInvalidCpfThenReturnFalse() {
        // Arrange
        String invalidCpf = "123.456.789-00"; // Replace with an invalid CPF for the test

        // Act
        boolean result = cpfCnpjValidator.isCpf(invalidCpf);

        // Assert
        assertFalse(result, "The isCpf method should return false for an invalid CPF");
    }

    @Test
    public void testIsCnpjWhenValidCnpjThenReturnTrue() {
        // Arrange
        String validCnpj = "12.345.678/0001-95"; // Replace with a valid CNPJ for the test

        // Act
        boolean result = cpfCnpjValidator.isCnpj(validCnpj);

        // Assert
        assertTrue(result, "The isCnpj method should return true for a valid CNPJ");
    }

    @Test
    public void testIsCnpjWhenInvalidCnpjThenReturnFalse() {
        // Arrange
        String invalidCnpj = "12.345.678/0001-00"; // Replace with an invalid CNPJ for the test

        // Act
        boolean result = cpfCnpjValidator.isCnpj(invalidCnpj);

        // Assert
        assertFalse(result, "The isCnpj method should return false for an invalid CNPJ");
    }
}
