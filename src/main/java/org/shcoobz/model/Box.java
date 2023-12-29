package org.shcoobz.model;

import java.time.LocalDate;

public class Box implements PostedItem {
  private final Address address;
  private final LocalDate postDate;
  private final int weight;
  private final BoxType boxType;

  private static final double SMALL_BOX_PRICE = 7.99;
  private static final double BIG_BOX_BASE_PRICE = 10.29;
  private static final double BIG_BOX_WEIGHT_MULTIPLIER = 0.29;

  // constructor to initialize everything
  public Box(Address address, LocalDate postDate, int weight, BoxType boxType) {
    this.address = address;
    this.postDate = postDate;
    this.weight = weight;
    this.boxType = boxType;
  }

  public int getWeight() {
    return weight;
  }

  public BoxType getBoxType() {
    return boxType;
  }

  @Override
  public LocalDate getPostDate() {
    return postDate;
  }

  @Override
  public double calculatePrice() {
    return switch (boxType) {
      case SMALL -> SMALL_BOX_PRICE; // if box type is SMALL, return constant SMALL_BOX_PRICE
      case BIG -> BIG_BOX_BASE_PRICE + weight * BIG_BOX_WEIGHT_MULTIPLIER; // if box type is BIG, calc price based on weight and return it
    };
  }
}

