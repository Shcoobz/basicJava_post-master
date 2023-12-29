package org.shcoobz.model;

import java.time.LocalDate;

// provides concrete code for all abstract methods declared in interface

public class Letter implements PostedItem {
  private final Address address;
  private final LocalDate postDate;
  private static final double PRICE = 1.99;

  public Letter(Address address, LocalDate postDate) {
    this.address = address;
    this.postDate = postDate;
  }

  @Override // indicates implementation of method from interface
  public LocalDate getPostDate() {
    return postDate;
  }

  @Override
  public double calculatePrice() {
    return PRICE;
  }
}

