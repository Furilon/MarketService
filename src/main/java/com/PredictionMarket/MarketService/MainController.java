package com.PredictionMarket.MarketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private MarketRepository marketRepository;

    MainController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @GetMapping("/markets")
    List<Market> all() {
        return marketRepository.findAll();
    }

    @PostMapping("/markets")
    Market newMarket(@RequestBody Market newMarket) {
        return marketRepository.save(newMarket);
    }

    @GetMapping("/markets/{id}")
    Market one(@PathVariable Long id) {
        return marketRepository.findById(id)
                .orElseThrow(() -> new MarketNotFoundException(id));
    }

    @PutMapping("/markets/{id}")
    Market replaceMarket(@RequestBody Market newMarket, @PathVariable Long id) {
        return marketRepository.findById(id)
                .map(market -> {
                    market.setDescription(newMarket.getDescription());
                    market.setQuestion(market.getQuestion());
                    market.setClosingDate(market.getClosingDate());
                    return marketRepository.save(market);
                })
                .orElseGet(() -> {
                    newMarket.setId(id);
                    return marketRepository.save(newMarket);
                });
    }

    @DeleteMapping("/markets/{id}")
    void deleteMarket(@PathVariable Long id) {
        marketRepository.deleteById(id);
    }

}
