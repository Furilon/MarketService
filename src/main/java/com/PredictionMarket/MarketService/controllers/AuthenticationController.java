package com.PredictionMarket.MarketService.controllers;

import com.PredictionMarket.MarketService.auth.objects.AuthenticationRequest;
import com.PredictionMarket.MarketService.auth.objects.AuthenticationResponse;
import com.PredictionMarket.MarketService.auth.services.AuthenticationService;
import com.PredictionMarket.MarketService.auth.objects.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://localhost:8081")
@RequestMapping("/auth")
public class AuthenticationController {

    public final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
