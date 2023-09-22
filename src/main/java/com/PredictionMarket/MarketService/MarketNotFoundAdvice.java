package com.PredictionMarket.MarketService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MarketNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MarketNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String marketNotFoundHandler(MarketNotFoundException ex) {
        return ex.getMessage();
    }
}
