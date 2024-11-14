package com.banco.pix.bancopix.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContaValidatorTest {

    @Autowired
    private ContaValidator contaValidator;

    @Test
    public void testIsValidContaWhenValidAccountNumberThenReturnTrue() {
        // Arrange
        String validAccountNumber = "12345678";

        // Act
        boolean result = contaValidator.isValidConta(validAccountNumber);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    public void testIsValidContaWhenInvalidAccountNumberThenReturnFalse() {
        // Arrange
        String invalidAccountNumber = "123456789"; // More than 8 digits

        // Act
        boolean result = contaValidator.isValidConta(invalidAccountNumber);

        // Assert
        assertThat(result).isFalse();
    }
}
