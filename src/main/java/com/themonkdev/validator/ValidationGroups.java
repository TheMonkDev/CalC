package com.themonkdev.validator;

import jakarta.validation.GroupSequence;

public class ValidationGroups {
    public interface ParameterValidation {}
    public interface ExpressionValidation {}
    @GroupSequence({ParameterValidation.class, ExpressionValidation.class})
    public interface ExpressionValidationSequence {}
}
