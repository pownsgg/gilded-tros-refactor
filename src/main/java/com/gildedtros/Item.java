package com.gildedtros;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Item {
    private String name;
    private ItemType itemType;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this(name, ItemType.REGULAR, sellIn, quality);
    }

    public Item(String name, ItemType itemType, int sellIn, int quality) {
        this.name = name;
        this.itemType = itemType;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}
