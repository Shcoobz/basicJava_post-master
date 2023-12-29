package org.shcoobz.ui;

import org.shcoobz.service.PostOffice;

import java.time.LocalDate;

/**
 * Provides static methods to display various elements of the user interface for a post office simulator.
 * This class is used for presenting visual elements and information in the console.
 */
public class UserInterface {

  /**
   * Prints the application logo to the console.
   * The logo is displayed as ASCII art representing the theme of the post office simulator.
   */
  public static void printLogo() {
    System.out.println("    _____                  _                           ");
    System.out.println("   |  __ \\                | |                          ");
    System.out.println("   | |__) |   ___    ___  | |_                         ");
    System.out.println("   |  ___/   / _ \\  / __| | __|                        ");
    System.out.println("   | |      | (_) | \\__ \\ | |_                         ");
    System.out.println("   |_|       \\___/  |___/  \\__|                        ");
    System.out.println("                                                        ");
    System.out.println("                                                        ");
    System.out.println("              __  __                 _                 ");
    System.out.println("             |  \\/  |               | |                ");
    System.out.println("             | \\  / |   __ _   ___  | |_    ___   _ __ ");
    System.out.println("             | |\\/| |  / _` | / __| | __|  / _ \\ | '__|");
    System.out.println("             | |  | | | (_| | \\__ \\ | |_  |  __/ | |   ");
    System.out.println("             |_|  |_|  \\__,_| |___/  \\__|  \\___| |_|   ");
    System.out.println("                                                        ");
    System.out.println("                                                        ");
  }

  /**
   * Prints a welcome message to the console when the application starts.
   * This message greets the users upon starting the post office simulator.
   */
  public static void printWelcome() {
    System.out.println("\nWelcome to my post office simulator!");
  }

  /**
   * Prints detailed information about the post office activities for a specific date,
   * including posted items and total income generated on that date.
   *
   * @param date The date for which details are to be printed.
   * @param postOffice The post office instance from which to retrieve details.
   */
  public static void printPostOfficeDetailsForDate(LocalDate date, PostOffice postOffice) {
    System.out.println("\n***** Post Office Details for " + date + ":");
    postOffice.printPostedItemsOnDate(date);
    postOffice.printIncomeOnDate(date);
  }

  /**
   * Prints a header message indicating the start of posted items' details.
   */
  public static void printPostedItemsMsg() {
    System.out.println("\nPosted Items:");
  }
}
