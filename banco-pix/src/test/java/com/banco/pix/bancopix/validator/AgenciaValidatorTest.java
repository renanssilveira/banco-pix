package com.banco.pix.bancopix.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
public class AgenciaValidatorTest {

    @InjectMocks
    private AgenciaValidator agenciaValidator;

    @Test
    public void testIsValidAgenciaWhenInputIsValidThenReturnTrue() {
        // Arrange
        String validInput = "1234";

        // Act
        boolean result = agenciaValidator.isValidAgencia(validInput);

        // Assert
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void testIsValidAgenciaWhenInputIsInvalidThenReturnFalse() {
        // Arrange
        String invalidInput = "12345"; // More than 4 digits

        // Act
        boolean result = agenciaValidator.isValidAgencia(invalidInput);

        // Assert
        Assertions.assertThat(result).isFalse();
    }
}
