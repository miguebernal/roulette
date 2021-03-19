package com.roulette.demo.repository;

import com.roulette.demo.domain.Roulette;
import java.util.Map;

public interface RedisRouletteRepository {
  Map<String, Roulette> findAll();
  String save(Roulette roulette);
  String openRoulette(String id, Roulette roulette);
}
