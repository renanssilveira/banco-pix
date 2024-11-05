package com.banco.pix.bancopix.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SobreNomeValidatorTest {

    @Autowired
    private SobreNomeValidator sobreNomeValidator;

    @Test
    public void testIsValidSobreNomeWhenNameIsValidThenReturnTrue() {
        // Arrange
        String validName = "ValidSurname123";

        // Act
        boolean result = sobreNomeValidator.isValidSobreNome(validName);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    public void testIsValidSobreNomeWhenNameIsTooLongThenReturnFalse() {
        // Arrange
        String tooLongName = "ThisSurnameIsWayTooLongToBeValidAndExceedsTheMaximumAllowedLength";

        // Act
        boolean result = sobreNomeValidator.isValidSobreNome(tooLongName);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    public void testIsValidSobreNomeWhenNameContainsSpecialCharactersThenReturnFalse() {
        // Arrange
        String nameWithSpecialCharacters = "Invalid@Surname!";

        // Act
        boolean result = sobreNomeValidator.isValidSobreNome(nameWithSpecialCharacters);

        // Assert
        assertThat(result).isFalse();
    }

    @Test
    public void testIsValidSobreNomeWhenNameIsEmptyThenReturnTrue() {
        // Arrange
        String emptyName = "";

        // Act
        boolean result = sobreNomeValidator.isValidSobreNome(emptyName);

        // Assert
        assertThat(result).isTrue();
    }
}