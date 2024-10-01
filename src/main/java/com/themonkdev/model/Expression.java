package com.themonkdev.model;

import com.themonkdev.validator.ExpressionConstraint;
import com.themonkdev.validator.ValidationGroups.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Expression {
    @NotNull(message = "Expression cannot be null", groups = ParameterValidation.class)
    @NotEmpty(message = "Expression cannot be empty", groups = ParameterValidation.class)
    @ExpressionConstraint(groups = ExpressionValidation.class)
    private String expression;

    public Expression() {}

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return this.expression;
    }

    public double parseExpression() {
        return 1;
    }
}
