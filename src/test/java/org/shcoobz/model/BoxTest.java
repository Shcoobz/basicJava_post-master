package org.shcoobz.model;

import org.junit.jupiter.api.Test;
import org.shcoobz.postable.Box;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
  @Test
  public void boxCreationAndPriceCalculationTest() {
    Address address = new Address("TestCity");

    // small Box
    Box smallBox = new Box(address, LocalDate.now(), 500, BoxType.SMALL);

    assertEquals(500, smallBox.getWeight());
    assertEquals(BoxType.SMALL, smallBox.getBoxType());
    assertEquals(7.99, smallBox.calculatePrice(), 0.01);

    // big Box
    Box bigBox = new Box(address, LocalDate.now(), 1500, BoxType.BIG);

    assertEquals(1500, bigBox.getWeight());
    assertEquals(BoxType.BIG, bigBox.getBoxType());
    assertEquals(10.29 + 1500 * 0.29, bigBox.calculatePrice(), 0.01);
  }
}