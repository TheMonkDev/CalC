package com.themonkdev.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExpressionValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExpressionConstraint {
    String message() default "Invalid Expression";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
