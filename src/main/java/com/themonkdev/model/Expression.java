package com.themonkdev.model;

import com.themonkdev.validator.ExpressionConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Expression {
    @NotNull(message = "Expression cannot be null")
    @NotEmpty(message = "Expression cannot be empty")
    @ExpressionConstraint
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
