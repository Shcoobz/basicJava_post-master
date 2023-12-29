package org.shcoobz.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.shcoobz.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostOfficeTest {
  private static Stream<Arguments> provideTestData() {
    return Stream.of(
        Arguments.of(LocalDate.now(), "Letter", 1),
        Arguments.of(LocalDate.now(), "Box", 1),
        Arguments.of(LocalDate.of(2022, 12, 3), "Letter", 1)
    );
  }

  @ParameterizedTest
  @MethodSource("provideTestData")
  public void testPostAndRetrieveItems(LocalDate date, String itemType, int expectedItemCount) {
    PostOffice postOffice = new PostOffice();
    postOffice.postItem(createItem(itemType, date));

    List<PostedItem> items = postOffice.getItemsPostedOn(date);
    long count = items.stream().filter(item -> item.getClass().getSimpleName().equals(itemType)).count();

    assertEquals(expectedItemCount, count);
  }

  private PostedItem createItem(String itemType, LocalDate date) {
    Address address = new Address("TestCity");

    if (itemType.equals("Letter")) {
      return new Letter(address, date);
    } else if (itemType.equals("Box")) {
      return new Box(address, date, 500, BoxType.SMALL);
    }
    throw new IllegalArgumentException("Unsupported item type");
  }
}
