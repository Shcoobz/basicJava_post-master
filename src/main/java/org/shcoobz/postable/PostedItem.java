package org.shcoobz.postable;

import java.time.LocalDate;

/**
 * Interface representing a posted item in the postal system. This interface defines a set of abstract methods
 * that any class implementing it must provide concrete implementations for. It serves as a blueprint
 * for different types of posted items (e.g., letters, boxes) within the postal system.
 */
public interface PostedItem {

  /**
   * Retrieves the date when the item was posted.
   * This method is intended to provide the posting date of the item for tracking and processing purposes.
   *
   * @return The LocalDate representing the date when the item was posted.
   */
  LocalDate getPostDate();

  /**
   * Calculates and returns the price of the posted item.
   * This method should implement the logic to calculate the price based on the specific attributes of the posted item.
   *
   * @return The calculated price of the posted item as a double value.
   */
  double calculatePrice(); // calc & returns price of posted item
}