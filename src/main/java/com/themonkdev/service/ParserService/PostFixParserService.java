package com.themonkdev.service.ParserService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
@Primary
public class PostFixParserService implements ParserService {

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException exp) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String token) {
        return switch (token) {
            case "+", "-", "*", "/", "**", "(", ")" -> true;
            default -> false;
        };
    }

    private int getPrecedence(String operator) {
        return switch(operator) {
            case "+", "-" -> 2;
            case "*", "/" -> 5;
            case "**" -> 7 ;
            case "(", ")" -> 9;
            default -> 0;
        };
    }

    private boolean hasPrecedence(String operator1, String operator2) {
        if (operator2.equals("(") || operator2.equals(")")) return false;
        return this.getPrecedence(operator1) <= this.getPrecedence(operator2);
    }

    private String calculate(String operand1, String operator, String operand2) throws ArithmeticException {
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);
        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                yield num1 / num2;
            }
            case "**" -> Math.pow(num1, num2);
            default -> 0;
        };
        ;
        return "" + result;
    }

    @Override
    public List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (this.isOperator(expression.substring(i, i+1))) {
                if (!token.isEmpty())
                    tokens.add(token.toString());
                token = new StringBuilder(expression.substring(i, i + 1));
                if (i < expression.length() - 1 && this.isOperator(expression.substring(i, i+2))) {
                    token = new StringBuilder(expression.substring(i, i + 2));
                    i++;
                }
                tokens.add(token.toString());
                token = new StringBuilder();
            } else {
                token.append(expression.charAt(i));
            }
        }
        if (!token.isEmpty())
            tokens.add(token.toString());
        return tokens;
    }

    @Override
    public double evaluate(String expression) throws ArithmeticException {
        List<String> tokens = this.tokenize(expression);
        Stack<String> operators = new Stack<>();
        Stack<String> evaluationStack = new Stack<>();
        for (var token: tokens) {
            if (this.isNumber(token)) {
                evaluationStack.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while(!operators.empty() && !operators.peek().equals("(")) {
                    String operand2 = evaluationStack.pop();
                    String operand1 = evaluationStack.pop();
                    String operator = operators.pop();
                    String result = this.calculate(operand1, operator, operand2);
                    evaluationStack.push(result);
                }
                operators.pop();
            } else if (this.isOperator(token)) {
                while (!operators.empty() && this.hasPrecedence(token, operators.peek())) {
                    String operand2 = evaluationStack.pop();
                    String operand1 = evaluationStack.pop();
                    String operator = operators.pop();
                    String result = this.calculate(operand1, operator, operand2);
                    evaluationStack.push(result);
                }
                operators.push(token);
            }
        }
        while (!operators.empty()) {
            String operand2 = evaluationStack.pop();
            String operand1 = evaluationStack.pop();
            String operator = operators.pop();
            String result = this.calculate(operand1, operator, operand2);
            evaluationStack.push(result);
        }
        return Double.parseDouble(evaluationStack.pop());
    }
}
