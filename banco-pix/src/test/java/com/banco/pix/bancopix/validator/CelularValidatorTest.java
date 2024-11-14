package com.banco.pix.bancopix.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CelularValidatorTest {

    @Autowired
    private CelularValidator celularValidator;

    @Test
    public void testIsValidCelularWhenValidPhoneNumberThenReturnTrue() {
        // Arrange
        String validPhoneNumber = "+55011964006995";

        // Act
        boolean result = celularValidator.isValidCelular(validPhoneNumber);

        // Assert
        assertThat(result).isTrue();
    }

    @Test
    public void testIsValidCelularWhenInvalidPhoneNumberThenReturnFalse() {
        // Arrange
        String invalidPhoneNumber = "1234567890";

        // Act
        boolean result = celularValidator.isValidCelular(invalidPhoneNumber);

        // Assert
        assertThat(result).isFalse();
    }
}
