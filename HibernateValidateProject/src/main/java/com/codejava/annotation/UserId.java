package com.codejava.annotation;

import com.codejava.validator.UserIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserId {

    String message() default "Id phai bat dau voi user";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
