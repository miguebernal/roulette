package com.roulette.demo.controller;

import com.roulette.demo.domain.Bet;
import com.roulette.demo.repository.BetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BetController {
    private BetRepository BetRepository;

    public BetController(BetRepository BetRepository) {
        this.BetRepository = BetRepository;
    }

    @PostMapping("/bets")
    public String makeBet(@RequestBody Bet bet) {
        return BetRepository.makeBet(bet);
    }
}
