package org.shcoobz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
  @Test
  public void addressCreationTest() {
    Address address = new Address("TestCity");

    assertEquals("TestCity", address.city());
  }
}