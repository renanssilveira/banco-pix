package com.banco.pix.bancopix.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmailValidatorTest {

    @InjectMocks
    private EmailValidator emailValidator;

    @Test
    public void testIsValidEmailAddressWhenValidEmailThenReturnTrue() {
        // Arrange
        String validEmail = "test@example.com";

        // Act
        boolean result = emailValidator.isValidEmailAddress(validEmail);

        // Assert
        assertTrue(result, "Expected true for a valid email address");
    }

    @Test
    public void testIsValidEmailAddressWhenInvalidEmailThenReturnFalse() {
        // Arrange
        String invalidEmail = "invalid-email";

        // Act
        boolean result = emailValidator.isValidEmailAddress(invalidEmail);

        // Assert
        assertFalse(result, "Expected false for an invalid email address");
    }

    @Test
    public void testIsValidEmailAddressWhenEmailLengthMoreThan77ThenReturnFalse() {
        // Arrange
        String longEmail = "thisisaverylongemailaddresswhichexceedsthemaximumallowedlengthofseventysevencharacters@example.com";

        // Act
        boolean result = emailValidator.isValidEmailAddress(longEmail);

        // Assert
        assertFalse(result, "Expected false for an email address longer than 77 characters");
    }
}
