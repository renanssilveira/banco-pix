package com.banco.pix.bancopix.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
public class AleatorioValidatorTest {

    @InjectMocks
    private AleatorioValidator aleatorioValidator;

    @Test
    public void testIsValidAleatorioWhenInputIsValidThenReturnTrue() {
        // Arrange
        String validInput = "abc123XYZ";

        // Act
        boolean result = aleatorioValidator.isValidAleatorio(validInput);

        // Assert
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void testIsValidAleatorioWhenInputIsTooLongThenReturnFalse() {
        // Arrange
        String invalidInput = "a".repeat(37); // 37 characters, more than the allowed 36

        // Act
        boolean result = aleatorioValidator.isValidAleatorio(invalidInput);

        // Assert
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void testIsValidAleatorioWhenInputContainsInvalidCharactersThenReturnFalse() {
        // Arrange
        String invalidInput = "abc123!@#";

        // Act
        boolean result = aleatorioValidator.isValidAleatorio(invalidInput);

        // Assert
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void testIsValidAleatorioWhenInputIsEmptyThenReturnFalse() {
        // Arrange
        String invalidInput = "";

        // Act
        boolean result = aleatorioValidator.isValidAleatorio(invalidInput);

        // Assert
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void testIsValidAleatorioWhenInputIsNullThenReturnFalse() {
        // Arrange
        String invalidInput = null;

        // Act
        boolean result = aleatorioValidator.isValidAleatorio(invalidInput);

        // Assert
        Assertions.assertThat(result).isFalse();
    }
}