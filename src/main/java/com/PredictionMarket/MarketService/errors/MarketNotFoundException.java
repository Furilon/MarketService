package com.PredictionMarket.MarketService.errors;

public class MarketNotFoundException extends RuntimeException {
    public MarketNotFoundException(Long id) {
        super("Could not find market " + id);
    }
}
