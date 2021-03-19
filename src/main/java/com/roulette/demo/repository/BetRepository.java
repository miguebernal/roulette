package com.roulette.demo.repository;

import com.roulette.demo.domain.Bet;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class BetRepository implements RedisBetRepository {
    private static final String KEY = "Bet";

    private RedisTemplate<String, Bet> redisTemplateBet;
    private HashOperations hashOperations;

    public BetRepository(RedisTemplate<String, Bet> redisTemplateBet) {
      this.redisTemplateBet = redisTemplateBet;
    }

    @PostConstruct
    private void init() {
      hashOperations = redisTemplateBet.opsForHash();
    }

    @Override
    public String makeBet(Bet bet) {
      if (isMoreThan10000(bet.getAmount())) {
        return "Amount is greater than 10.000";
      }
      if (!isRedOrBlack(bet.getColor())) {
        return "Color must be red or black";
      }
      if (!validateNumber(bet.getNumber())) {
        return "Number must be between 0 and 36";
      }
      String id = UUID.randomUUID().toString();
      hashOperations.put(KEY, id, bet);
      return id;
    }

    private boolean isMoreThan10000(int amount) {
      return amount > 10000;
    }

    private boolean isRedOrBlack(String color) {
      return (color.equalsIgnoreCase("rojo") || color.equalsIgnoreCase("negro"));
    }

    private boolean validateNumber(int number) {
      return ( number >= 0 && number <= 36 );
    }
}
