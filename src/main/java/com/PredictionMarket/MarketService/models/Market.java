package com.PredictionMarket.MarketService.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="markets")
public class Market {
    @Id
    @GeneratedValue
    private Long id;
    private String question;
    private Date closingDate;
    private String description;
//    @ManyToOne
//    private User user;

    Market() {}

    Market(String question, Date closingDate, String description, User user) {
        this.question = question;
        this.closingDate = closingDate;
        this.description = description;
//        this.user = user;
    }


    // @OneToMany?
    // private Comment[] comments;

    // @OneToMany?
    // private Trade[] trades;

    // @OneToMany?
    // private TradePosition[] positions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public User getUser() {
//        return user;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market)) return false;

        Market market = (Market) o;

        return Objects.equals(this.id, market.id) &&
                Objects.equals(this.closingDate, market.closingDate) &&
                Objects.equals(this.description, market.description) &&
                Objects.equals(this.question, market.question); /*&&*/
//                Objects.equals(this.user, market.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.closingDate, this.description, this.question); //this.user);
    }

    @Override
    public String toString() {
        return "Market{" + "id=" + this.id + ", question='" + this.question + '\'' + ", closingDate=" + this.closingDate + '\'' + /*this.user*/ + '}';
    }

}
