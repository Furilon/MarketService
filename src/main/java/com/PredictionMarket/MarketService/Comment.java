package com.PredictionMarket.MarketService;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String commentContent;

    @ManyToOne
    private Market market;

    @ManyToOne
    private User user;


}
