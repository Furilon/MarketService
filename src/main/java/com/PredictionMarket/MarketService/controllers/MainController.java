package com.PredictionMarket.MarketService.controllers;

import com.PredictionMarket.MarketService.errors.MarketNotFoundException;
import com.PredictionMarket.MarketService.helperclasses.CommentUpdateRequestData;
import com.PredictionMarket.MarketService.helperclasses.MarketWithComments;
import com.PredictionMarket.MarketService.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://localhost:8081")
public class MainController {

    @Autowired
    private MarketRepository marketRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    MainController(MarketRepository marketRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.marketRepository = marketRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    // ---------------------
    // Markets mapping START
    // ---------------------

    @GetMapping("/markets")
    List<Market> allMarkets() {
        return marketRepository.findAll();
    }

    @PostMapping("/markets")
    Market newMarket(@RequestBody Market newMarket) {
        return marketRepository.save(newMarket);
    }

    @GetMapping("/markets/{id}")
    Market oneMarket(@PathVariable Long id) {
        return marketRepository.findById(id)
                .orElseThrow(() -> new MarketNotFoundException(id));
    }

    @GetMapping("/markets/withComments/{id}")
    MarketWithComments oneMarketWithComments(@PathVariable Long id) {
        Market market = marketRepository.findById(id)
                .orElseThrow(() -> new MarketNotFoundException(id));

        List<Comment> comments = this.allCommentsForMarket(id);

        return new MarketWithComments(market, comments);
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

    // ---------------------
    // Markets mappings END
    // ---------------------

    // ---------------------
    // Comment mappings START
    // ---------------------

    @GetMapping("/comments/{marketId}")
    List<Comment> allCommentsForMarket(@PathVariable Long marketId) {
        return commentRepository.findByMarketId(marketId);
    }

    @PostMapping("/comments/{marketId}")
    Comment newComment(@RequestBody String comment, @PathVariable Long marketId) {
        Market market = this.oneMarket(marketId);
        Comment newComment = new Comment(comment, market);

        return commentRepository.save(newComment);
    }

    @PutMapping("/comments/{marketId}")
    Comment replaceComment(@RequestBody CommentUpdateRequestData requestData, @PathVariable Long marketId) {
        return commentRepository.findById(requestData.commentId)
                .map(comment -> {
                    comment.setCommentContent(requestData.newComment);
                    return commentRepository.save(comment);
                }).orElseGet(() -> {
                    Market market = this.oneMarket(marketId);
                    Comment newComment = new Comment(requestData.commentId, requestData.newComment, market);
                    return commentRepository.save(newComment);
                });
    }

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
