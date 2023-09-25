package com.PredictionMarket.MarketService.models;

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

//    @ManyToOne
//    private User user;

    Comment() {}

//    Comment(String commentContent, Market market, User user) {
//        this.commentContent = commentContent;
//        this.market = market;
//        this.user = user;
//    }

    public Comment(String commentContent, Market market) {
        this.commentContent = commentContent;
        this.market = market;
    }

    public Comment(Long id, String commentContent, Market market) {
        this.id = id;
        this.commentContent = commentContent;
        this.market = market;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String newCommentContent) {
        this.commentContent = newCommentContent;
    }
}
