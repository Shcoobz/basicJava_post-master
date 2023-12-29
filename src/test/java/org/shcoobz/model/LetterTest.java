package org.shcoobz.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {
  @Test
  public void letterCreationAndPriceTest() {
    Address address = new Address("TestCity");
    Letter letter = new Letter(address, LocalDate.now());

    assertEquals(1.99, letter.calculatePrice(), 0.01);
  }

}