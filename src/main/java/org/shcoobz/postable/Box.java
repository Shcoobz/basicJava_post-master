package org.shcoobz.postable;

import org.shcoobz.model.Address;
import org.shcoobz.model.BoxType;

import java.time.LocalDate;

/**
 * Represents a box that can be posted. This class implements the PostedItem interface
 * and provides the functionality for managing box-related information such as address,
 * posting date, weight, and box type. It also includes logic for calculating the price
 * based on box characteristics.
 */
public class Box implements PostedItem {
  private final Address address;
  private final LocalDate postDate;
  private final int weight;
  private final BoxType boxType;

  private static final double SMALL_BOX_PRICE = 7.99;
  private static final double BIG_BOX_BASE_PRICE = 10.29;
  private static final double BIG_BOX_WEIGHT_MULTIPLIER = 0.29;

  /**
   * Constructs a Box instance with an address, posting date, weight, and box type.
   *
   * @param address The address to which the box is to be sent.
   * @param postDate The date on which the box is posted.
   * @param weight The weight of the box in grams.
   * @param boxType The type of the box (e.g., SMALL or BIG).
   */
  public Box(Address address, LocalDate postDate, int weight, BoxType boxType) {
    this.address = address;
    this.postDate = postDate;
    this.weight = weight;
    this.boxType = boxType;
  }

  /**
   * Retrieves the weight of the box.
   *
   * @return The weight of the box in grams.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Retrieves the type of the box.
   *
   * @return The type of the box (SMALL or BIG).
   */
  public BoxType getBoxType() {
    return boxType;
  }

  /**
   * Retrieves the posting date of the box.
   *
   * @return The date on which the box is posted.
   */
  @Override
  public LocalDate getPostDate() {
    return postDate;
  }

  /**
   * Calculates the price of posting the box based on its type and weight.
   * The price calculation differs between small and big boxes.
   *
   * @return The calculated price for posting the box.
   */
  @Override
  public double calculatePrice() {
    return switch (boxType) {
      case SMALL -> SMALL_BOX_PRICE; // if box type is SMALL, return constant SMALL_BOX_PRICE
      case BIG -> {
        // if box type is BIG, calculate price based on weight over 20 kg
        double additionalCharge = weight > 3000 ? (weight - 3000) * BIG_BOX_WEIGHT_MULTIPLIER : 0;
        yield BIG_BOX_BASE_PRICE + additionalCharge;
      }
    };
  }
}

