package com.PredictionMarket.MarketService.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByMarketId(Long marketId);
}
