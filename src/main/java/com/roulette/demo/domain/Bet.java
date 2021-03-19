package com.roulette.demo.domain;

import java.io.Serializable;

public class Bet implements Serializable {
  private String idRoulette;
  private int number;
  private String color;
  private int amount;



  public String getIdRoulette() {
  	return idRoulette;
  }

  public void setIdRoulette(String idRoulette) {
  	this.idRoulette = idRoulette;
  }

  public int getNumber() {
  	return number;
  }

  public void setNumber(int number) {
  	this.number = number;
  }

  public String getColor() {
  	return color;
  }

  public void setColor(String color) {
  	this.color = color;
  }

  public int getAmount() {
  	return amount;
  }

  public void setAmount(int amount) {
  	this.amount = amount;
  }
}
