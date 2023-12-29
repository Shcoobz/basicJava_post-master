package org.shcoobz.util;

import org.shcoobz.model.Address;
import org.shcoobz.postable.Box;
import org.shcoobz.model.BoxType;
import org.shcoobz.postable.Letter;
import org.shcoobz.service.PostOffice;

import java.time.LocalDate;

/**
 * Utility class that provides static methods to facilitate the posting of various items
 * such as letters and boxes to a PostOffice instance.
 * This class simplifies the process of creating and posting items.
 */
public class PostUtil {

  /**
   * Posts a letter to a post office.
   *
   * @param postOffice The post office to which the letter is being posted.
   * @param address The address to which the letter will be sent.
   * @param date The date on which the letter is posted.
   */
  public static void postLetter(PostOffice postOffice, Address address, LocalDate date) {
    Letter letter = new Letter(address, date);
    postOffice.postItem(letter);
  }

  /**
   * Posts a box to a post office.
   *
   * @param postOffice The post office to which the box is being posted.
   * @param address The address to which the box will be sent.
   * @param date The date on which the box is posted.
   * @param weight The weight of the box in grams.
   * @param boxType The type of the box (e.g., SMALL or BIG).
   */
  public static void postBox(PostOffice postOffice, Address address, LocalDate date, int weight, BoxType boxType) {
    Box box = new Box(address, date, weight, boxType);
    postOffice.postItem(box);
  }
}
