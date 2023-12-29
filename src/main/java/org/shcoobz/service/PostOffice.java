package org.shcoobz.service;

import org.shcoobz.model.Box;
import org.shcoobz.model.BoxType;
import org.shcoobz.model.Letter;
import org.shcoobz.model.PostedItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class representing a post office.
 *
 * provides methods for posting items,
 * retrieving posted items on a specific date,
 * calculating income by item type and date,
 * printing information about posted items and income.
 */

public class PostOffice {
  private List<PostedItem> postedItems = new ArrayList<>();
  // can dynamically grow or shrink in size as elements are added or removed
  // maintains order of things as posted
  // add, remove, get, set, size, contains, isEmpty

  public void postItem(PostedItem item) {
    postedItems.add(item);
  }

  public List<PostedItem> getItemsPostedOn(LocalDate date) {
    // filters items with specified post date and collects them into list
    return postedItems.stream()
        .filter(item -> item.getPostDate().equals(date))
        .collect(Collectors.toList());
  }

  private boolean typeMatches(PostedItem item, String type) {
    // checks if item's type matches specified type and returns true or false accordingly
    if (type.equalsIgnoreCase("letter") && item instanceof Letter) {
      return true;
    } else if (type.equalsIgnoreCase("small box") && item instanceof Box) {
      Box box = (Box) item;
      return box.getBoxType() == BoxType.SMALL;
    } else if (type.equalsIgnoreCase("big box") && item instanceof Box) {
      Box box = (Box) item;
      return box.getBoxType() == BoxType.BIG;
    }
    return false;
  }

  private double calculateTotalIncomeByTypeAndDate(String type, LocalDate date) {
    // filters items by date and type
    // calculates their prices
    // sums them to compute total income
    return postedItems.stream()
        // sequence of elements that can be processes
        // for filtering
        .filter(item -> item.getPostDate().equals(date) && typeMatches(item, type))
        .mapToDouble(PostedItem::calculatePrice) // makes stream of objects into stream of primitive double values
        .sum();
  }

  public void printPostedItemsOnDate(LocalDate date) {
    List<PostedItem> itemsOnDate = getItemsPostedOn(date);

    Map<String, Integer> itemCounts = new HashMap<>();
    // unordered list
    // can be looped over
    // key value pairs

    for (PostedItem item : itemsOnDate) {
      String itemType;

      if (item instanceof Letter) {
        itemType = "letter";
      } else if (item instanceof Box) {
        Box box = (Box) item;
        itemType = box.getBoxType() == BoxType.SMALL ? "small box" : "big box";
      } else {
        continue; // if it's neither, skip to the next item
      }
      itemCounts.put(itemType, itemCounts.getOrDefault(itemType, 0) + 1);
    }

    System.out.println("Posted Items on " + date + ":");
    for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) { // iterate through entrySet to access key-value pairs
      System.out.println(entry.getValue() + " x " + entry.getKey());
    }
  }

  public void printIncomeOnDate(LocalDate date) {
    double incomeFromLetters = calculateTotalIncomeByTypeAndDate("letter", date);
    double incomeFromSmallBoxes = calculateTotalIncomeByTypeAndDate("small box", date);
    double incomeFromBigBoxes = calculateTotalIncomeByTypeAndDate("big box", date);

   /* System.out.println("\nTotal income from letters on " + date + ": " + incomeFromLetters);
    System.out.println("Total income from small boxes on " + date + ": " + incomeFromSmallBoxes);
    System.out.println("Total income from big boxes on " + date + ": " + incomeFromBigBoxes);*/

    System.out.println("\nTotal income " + date + ": \n" + (incomeFromLetters + incomeFromSmallBoxes + incomeFromBigBoxes) + " €");
  }

}


