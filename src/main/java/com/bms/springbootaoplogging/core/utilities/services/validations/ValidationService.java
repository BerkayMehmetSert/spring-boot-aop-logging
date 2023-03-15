package com.bms.springbootaoplogging.core.utilities.services.validations;


import com.bms.springbootaoplogging.core.exceptions.ValidationException;

public class ValidationService {
    public void notEmpty(String string, String message) {
        if (string == null || string.isEmpty())
            throw new ValidationException(message);
    }

    public void maxLength(String string, int maxLength, String message) {
        if (string.length() > maxLength)
            throw new ValidationException(message);
    }

    public void minLength(String string, int minLength, String message) {
        if (string.length() < minLength)
            throw new ValidationException(message);
    }

    public void greaterThan(int value, int min, String message) {
        if (value > min)
            throw new ValidationException(message);
    }

    public void lessThan(int value, int max, String message) {
        if (value < max)
            throw new ValidationException(message);
    }

    public void greaterThanOrEqual(int value, int min, String message) {
        if (value >= min)
            throw new ValidationException(message);
    }

    public void lessThanOrEqual(int value, int max, String message) {
        if (value <= max)
            throw new ValidationException(message);
    }

    public void email(String email, String regex, String message) {
        if (!email.matches(regex))
            throw new ValidationException(message);
    }

}
