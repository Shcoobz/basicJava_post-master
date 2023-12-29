package org.shcoobz.model;

/**
 * A simple immutable data-carrying object representing an address.
 * This record is a concise way to encapsulate address information.
 * It automatically generates a getter method for the city component.
 */
public record Address(String city) {

  /**
   * Retrieves the city component of the address.
   *
   * @return The city as a String.
   */

  // The getter method for 'city' is implicitly provided by the record.
}


