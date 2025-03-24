package com.gildedtros;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String name;

    @Builder.Default
    private ItemType itemType = ItemType.REGULAR;

    private int sellIn;
    private int quality;
}
