package com.roulette.demo.repository;

import com.roulette.demo.domain.Bet;
import java.util.Map;

public interface RedisBetRepository {
  String makeBet(Bet bet);
}
