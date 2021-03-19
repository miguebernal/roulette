package com.roulette.demo.controller;

import com.roulette.demo.domain.Roulette;
import com.roulette.demo.repository.RouletteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RouletteController {
    private RouletteRepository rouletteRepository;

    public RouletteController(RouletteRepository rouletteRepository) {
        this.rouletteRepository = rouletteRepository;
    }

    @GetMapping("/roulettes")
    public Map<String, Roulette> findAll() {
      return rouletteRepository.findAll();
    }

    @PostMapping("/roulettes")
    public String createRoulette(@RequestBody Roulette roulette) {
      return rouletteRepository.save(roulette);
    }

    @PutMapping("/roulettes/{id}")
    public String openRoulette(@PathVariable String id, @RequestBody Roulette roulette) {
      return rouletteRepository.openRoulette(id, roulette);
    }
}
