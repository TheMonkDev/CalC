package com.themonkdev.controller;

import com.themonkdev.model.Expression;
import com.themonkdev.service.ParserService.ParserService;
import com.themonkdev.validator.ValidationGroups.ExpressionValidationSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalC {
    @Autowired
    private ParserService parserService;

    @PostMapping("/calculate")
    public double calculate(@Validated(ExpressionValidationSequence.class) @RequestBody Expression expression) {
        expression.setParserService(parserService);
        return expression.parseExpression();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
