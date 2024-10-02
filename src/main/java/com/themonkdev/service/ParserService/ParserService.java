package com.themonkdev.service.ParserService;

import java.util.List;

public interface ParserService {
    List<String> tokenize(String expression);
    double evaluate(String expression);
}
