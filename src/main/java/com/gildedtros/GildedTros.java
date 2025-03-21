package com.gildedtros;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class GildedTros {
    private final Item[] items;

    public void updateQuality() {
	    for (Item item : items) {
            String itemName = item.getName();
            int itemQuality = item.getQuality();
            int itemSellIn = item.getSellIn();

		    if (!itemName.equals("Good Wine")
			    && !itemName.equals("Backstage passes for Re:Factor")
			    && !itemName.equals("Backstage passes for HAXX")) {
			    if (itemQuality > 0) {
				    if (!itemName.equals("B-DAWG Keychain")) {
					    itemQuality = itemQuality - 1;
				    }
			    }
		    } else {
			    if (itemQuality < 50) {
				    itemQuality = itemQuality + 1;

				    if (itemName.equals("Backstage passes for Re:Factor") || itemName.equals("Backstage passes for HAXX")) {
					    if (itemSellIn < 11) {
						    if (itemQuality < 50) {
							    itemQuality = itemQuality + 1;
						    }
					    }

					    if (itemSellIn < 6) {
						    if (itemQuality < 50) {
							    itemQuality = itemQuality + 1;
						    }
					    }
				    }
			    }
		    }

		    if (!itemName.equals("B-DAWG Keychain")) {
			    itemSellIn = itemSellIn - 1;
		    }

		    if (itemSellIn < 0) {
			    if (!itemName.equals("Good Wine")) {
				    if (!itemName.equals("Backstage passes for Re:Factor") && !itemName.equals("Backstage passes for HAXX")) {
					    if (itemQuality > 0) {
						    if (!itemName.equals("B-DAWG Keychain")) {
							    itemQuality = itemQuality - 1;
						    }
					    }
				    } else {
					    itemQuality = itemQuality - itemQuality;
				    }
			    } else {
				    if (itemQuality < 50) {
					    itemQuality = itemQuality + 1;
				    }
			    }
		    }

            // TODO: Update item objects
	    }
    }
}