package org.shcoobz;

import org.shcoobz.model.Address;
import org.shcoobz.model.Box;
import org.shcoobz.model.BoxType;
import org.shcoobz.model.Letter;
import org.shcoobz.service.PostOffice;

import java.time.LocalDate;

public class Main {
  private static PostOffice postOffice = new PostOffice();

  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    LocalDate specificDate = LocalDate.of(2022, 12, 3);

    // post letters and boxes for today
    postLetter(new Address("Wien"), today);
    postBox(new Address("Urb"), today, 500, BoxType.SMALL);
    postBox(new Address("Retz"), today, 1500, BoxType.BIG);
    postBox(new Address("Wien"), today, 2500, BoxType.BIG);

    // post letters and boxes for specific date
    postLetter(new Address("Wien"), specificDate);
    postBox(new Address("Urb"), specificDate, 500, BoxType.SMALL);
    postBox(new Address("Retz"), specificDate, 1500, BoxType.BIG);
    postBox(new Address("Wien"), specificDate, 2500, BoxType.BIG);

    printPostOfficeDetailsForDate(today);
    printPostOfficeDetailsForDate(specificDate);
  }

  // utility methods
  private static void postLetter(Address address, LocalDate date) {
    Letter letter = new Letter(address, date);
    postOffice.postItem(letter);
  }

  private static void postBox(Address address, LocalDate date, int weight, BoxType boxType) {
    Box box = new Box(address, date, weight, boxType);
    postOffice.postItem(box);
  }

  private static void printPostOfficeDetailsForDate(LocalDate date) {
    System.out.println("\n***** Post Office Details for " + date + ":");
    postOffice.printPostedItemsOnDate(date);
    postOffice.printIncomeOnDate(date);
  }
}


