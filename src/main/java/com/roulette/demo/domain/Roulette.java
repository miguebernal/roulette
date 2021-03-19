package com.roulette.demo.domain;

import java.io.Serializable;

public class Roulette implements Serializable {
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
