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

    Comment() {}

    Comment(String commentContent, Market market, User user) {
        this.commentContent = commentContent;
        this.market = market;
        this.user = user;
    }

    Comment(String commentContent, Market market) {
        this.commentContent = commentContent;
        this.market = market;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String newCommentContent) {
        this.commentContent = newCommentContent;
    }
}
