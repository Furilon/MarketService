package com.PredictionMarket.MarketService;

public class MarketNotFoundException extends RuntimeException {
    MarketNotFoundException(Long id) {
        super("Could not find market " + id);
    }
}
