package com.themonkdev.model;

import com.themonkdev.service.ParserService.ParserService;
import com.themonkdev.validator.ExpressionConstraint;
import com.themonkdev.validator.ValidationGroups.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class Expression {

    private ParserService parserService;

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

    public void setParserService(ParserService parserService) {
        this.parserService = parserService;
    }

    public double parseExpression() {
        return this.parserService.evaluate(this.expression);
    }
}
