package org.shcoobz;

import org.shcoobz.model.Address;
import org.shcoobz.model.BoxType;
import org.shcoobz.service.PostOffice;
import org.shcoobz.ui.UserInterface;
import org.shcoobz.util.PostUtil;

import java.time.LocalDate;

/**
 * The main class of the post office simulator application.
 * This class is responsible for initializing the post office, posting items, and displaying details about the posted items.
 */
public class Main {
  private static PostOffice postOffice = new PostOffice();

  /**
   * The entry point of the application. It sets up the user interface, posts items for today and a specific date,
   * and then prints details about the posted items for both dates.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    UserInterface.printLogo();
    UserInterface.printWelcome();


    LocalDate today = LocalDate.now();
    LocalDate specificDate = LocalDate.of(2022, 12, 3);

    postItemsForToday(today);
    postItemsForSpecificDate(specificDate);

    UserInterface.printPostOfficeDetailsForDate(today, postOffice);
    UserInterface.printPostOfficeDetailsForDate(specificDate, postOffice);
  }

  /**
   * Posts a series of letters and boxes for the given date using utility methods.
   * This method demonstrates how items can be posted to the post office for a specific date.
   *
   * @param date The date for which items are to be posted.
   */
  private static void postItemsForToday(LocalDate date) {
    PostUtil.postLetter(postOffice, new Address("Wien"), date);
    PostUtil.postBox(postOffice, new Address("Urb"), date, 500, BoxType.SMALL);
    PostUtil.postBox(postOffice, new Address("Retz"), date, 1500, BoxType.BIG);
    PostUtil.postBox(postOffice, new Address("Wien"), date, 2500, BoxType.BIG);
    PostUtil.postBox(postOffice, new Address("Wien"), date, 3500, BoxType.BIG);
  }

  /**
   * Posts a series of letters and boxes for a specific past date using utility methods.
   * This method demonstrates how items can be posted to the post office for a past date.
   *
   * @param date The specific past date for which items are to be posted.
   */
  private static void postItemsForSpecificDate(LocalDate date) {
    PostUtil.postLetter(postOffice, new Address("Wien"), date);
    PostUtil.postBox(postOffice, new Address("Urb"), date, 500, BoxType.SMALL);
    PostUtil.postBox(postOffice, new Address("Retz"), date, 1500, BoxType.BIG);
    PostUtil.postBox(postOffice, new Address("Wien"), date, 2500, BoxType.BIG);
    PostUtil.postBox(postOffice, new Address("Wien"), date, 3500, BoxType.BIG);
  }
}


