package org.shcoobz.postable;

import org.shcoobz.model.Address;

import java.time.LocalDate;

/**
 * Represents a letter in the postal system. This class implements the PostedItem interface
 * and provides the functionality for managing letter-related information such as address and posting date.
 * It also includes the pricing logic specific to a letter.
 */
public class Letter implements PostedItem {
  private final Address address;
  private final LocalDate postDate;
  private static final double PRICE = 1.99;

  /**
   * Constructs a Letter instance with an address and posting date.
   *
   * @param address The address to which the letter is to be sent.
   * @param postDate The date on which the letter is posted.
   */
  public Letter(Address address, LocalDate postDate) {
    this.address = address;
    this.postDate = postDate;
  }

  /**
   * Retrieves the posting date of the letter.
   *
   * @return The date on which the letter is posted.
   */
  @Override
  public LocalDate getPostDate() {
    return postDate;
  }

  /**
   * Calculates the price of posting the letter.
   * The price for a letter is a fixed amount.
   *
   * @return The price for posting the letter.
   */
  @Override
  public double calculatePrice() {
    return PRICE;
  }
}

