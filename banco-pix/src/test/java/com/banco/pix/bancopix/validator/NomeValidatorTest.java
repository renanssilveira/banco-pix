package com.banco.pix.bancopix.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NomeValidatorTest {

    @Autowired
    private NomeValidator nomeValidator;

    @Test
    public void testIsValidNomeWhenNameIsValidThenReturnTrue() {
        // Arrange
        String validName = "ValidName123";

        // Act
        boolean result = nomeValidator.isValidNome(validName);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    public void testIsValidNomeWhenNameIsTooLongThenReturnFalse() {
        // Arrange
        String tooLongName = "ThisNameIsWayTooLongToBeValid1234567890";

        // Act
        boolean result = nomeValidator.isValidNome(tooLongName);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    public void testIsValidNomeWhenNameContainsSpecialCharactersThenReturnFalse() {
        // Arrange
        String nameWithSpecialCharacters = "Invalid@Name!";

        // Act
        boolean result = nomeValidator.isValidNome(nameWithSpecialCharacters);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    public void testIsValidNomeWhenNameIsEmptyThenReturnFalse() {
        // Arrange
        String emptyName = "";

        // Act
        boolean result = nomeValidator.isValidNome(emptyName);

        // Assert
        assertThat(result).isFalse();
    }
}
