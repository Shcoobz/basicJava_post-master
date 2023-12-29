package org.shcoobz.service;

import org.shcoobz.postable.Box;
import org.shcoobz.model.BoxType;
import org.shcoobz.postable.Letter;
import org.shcoobz.postable.PostedItem;
import org.shcoobz.ui.UserInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a post office with functionalities for handling posted items.
 * This class provides methods for posting items, retrieving items posted on specific dates,
 * calculating income by item type and date, and printing information about posted items and income.
 */
public class PostOffice {
  private List<PostedItem> postedItems = new ArrayList<>();

  /**
   * Posts an item to the post office.
   *
   * @param item The item to be posted.
   */
  public void postItem(PostedItem item) {
    postedItems.add(item);
  }

  /**
   * Retrieves a list of items that were posted on a specific date.
   *
   * @param date The date for which posted items are to be retrieved.
   * @return A list of PostedItem instances posted on the specified date.
   */
  public List<PostedItem> getItemsPostedOn(LocalDate date) {
    return postedItems.stream()
        .filter(item -> item.getPostDate().equals(date))
        .collect(Collectors.toList());
  }

  // Helper method to check if an item's type matches a specified type
  private boolean typeMatches(PostedItem item, String type) {
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

  // Helper method to calculate total income by type and date
  private double calculateTotalIncomeByTypeAndDate(String type, LocalDate date) {
    BigDecimal totalIncome = postedItems.stream()
        .filter(item -> item.getPostDate().equals(date) && typeMatches(item, type))
        .map(PostedItem::calculatePrice)
        .map(BigDecimal::valueOf)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    return totalIncome.setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  /**
   * Prints information about items posted on a specific date, including item counts and total income.
   *
   * @param date The date for which information is to be printed.
   */
  public void printPostedItemsOnDate(LocalDate date) {
    List<PostedItem> itemsOnDate = getItemsPostedOn(date);

    Map<String, Integer> itemCounts = new HashMap<>();

    for (PostedItem item : itemsOnDate) {
      String itemType;

      if (item instanceof Letter) {
        itemType = "letter";
      } else if (item instanceof Box) {
        Box box = (Box) item;
        itemType = box.getBoxType() == BoxType.SMALL ? "small box" : "big box";
      } else {
        continue;
      }
      itemCounts.put(itemType, itemCounts.getOrDefault(itemType, 0) + 1);
    }

    UserInterface.printPostedItemsMsg();
    for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
      String itemType = entry.getKey();
      int itemCount = entry.getValue();
      double totalIncomeForType = calculateTotalIncomeByTypeAndDate(itemType, date);
      System.out.println(itemCount + " x " + itemType + " - Price: " + totalIncomeForType + " €");
    }
  }

  /**
   * Prints the total income generated on a specific date from all types of posted items.
   *
   * @param date The date for which income information is to be printed.
   */
  public void printIncomeOnDate(LocalDate date) {
    double incomeFromLetters = calculateTotalIncomeByTypeAndDate("letter", date);
    double incomeFromSmallBoxes = calculateTotalIncomeByTypeAndDate("small box", date);
    double incomeFromBigBoxes = calculateTotalIncomeByTypeAndDate("big box", date);


    System.out.println("\nTotal income: " + (incomeFromLetters + incomeFromSmallBoxes + incomeFromBigBoxes) + " €");
  }
}


