package com.graphql.inventoryservice.record;

public record ProductInput(String name, String category, Float price, Integer stock) {

}
