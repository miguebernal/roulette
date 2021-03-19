package com.roulette.demo.repository;

import com.roulette.demo.domain.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class RouletteRepository implements RedisRouletteRepository {
    private static final String KEY = "Roulette";

    private RedisTemplate<String, Roulette> redisTemplateRoulette;
    private HashOperations hashOperations;

    public RouletteRepository(RedisTemplate<String, Roulette> redisTemplateRoulette) {
      this.redisTemplateRoulette = redisTemplateRoulette;
    }

    @PostConstruct
    private void init() {
      hashOperations = redisTemplateRoulette.opsForHash();
    }

    @Override
    public Map<String, Roulette> findAll() {
      return hashOperations.entries(KEY);
    }

    @Override
    public String save(Roulette roulette) {
      String id = UUID.randomUUID().toString();
      hashOperations.put(KEY, id, roulette);
      return id;
    }

    @Override
    public String openRoulette(String id, Roulette roulette) {
      hashOperations.put(KEY, id, roulette);
      return "Successfully updated";
    }
}
