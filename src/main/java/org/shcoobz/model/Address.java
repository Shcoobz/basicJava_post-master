package org.shcoobz.model;

/*
* simple and concise way to create immutable data-carrying objects
* simple data class representing an address
* automatically generate getter methods for all components (fields) declared in record, making it easy to access the data
* */

// public record Address(String street, String city, String postalCode) {}

public record Address(String city) {}


