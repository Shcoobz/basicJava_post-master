package org.shcoobz.model;

import java.time.LocalDate;

/*
* blueprint for a class
* defines set of abstract methods that any class implementing the interface must provide concrete implementations for
* */

public interface PostedItem {
  LocalDate getPostDate(); // gets date when item was posted
  double calculatePrice(); // calc & returns price of posted item
}