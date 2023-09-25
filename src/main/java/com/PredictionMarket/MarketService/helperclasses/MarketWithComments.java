package com.PredictionMarket.MarketService.helperclasses;

import com.PredictionMarket.MarketService.models.Comment;
import com.PredictionMarket.MarketService.models.Market;

import java.util.List;

public class MarketWithComments {
    public Market market;
    public List<Comment> comments;

    public MarketWithComments(Market market, List<Comment> comments) {
        this.market = market;
        this.comments = comments;
    }
}