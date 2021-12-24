package com.codejava.validator;

import com.codejava.annotation.UserId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdValidator implements ConstraintValidator<UserId, String> {
    private static final String UserId_PREFIX = "user";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) return false;
        return s.startsWith(UserId_PREFIX);
    }
}
