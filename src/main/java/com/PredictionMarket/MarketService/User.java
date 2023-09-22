package com.PredictionMarket.MarketService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    User() {}

    User(String username) {
        this.username = username;
    }
}
