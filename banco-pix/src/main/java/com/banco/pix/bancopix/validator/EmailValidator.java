package com.banco.pix.bancopix.validator;

import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Service
public class EmailValidator {
    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        if (email.length() > 77) {
            return false;
        }
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
