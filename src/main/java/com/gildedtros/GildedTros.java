package com.gildedtros;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class GildedTros {
    private final Item[] items;

    public void updateQuality() {
	    for (Item item : this.items) {
            this.updateItemQuality(item);
	    }
    }

	private void updateItemQuality(Item item) {
		switch(item.getItemType()) {
			case AGED_QUALITY_INCREASE:
				this.increaseQuality(item);
				break;
			case BACKSTAGE_PASS:
				this.updateBackstagePass(item);
				break;
			case LEGENDARY:
				return;
			case REGULAR:
				this.decreaseQuality(item);
				break;
		}

		item.setSellIn(item.getSellIn() - 1);
		this.handleExpiredItem(item);
	}

	private void increaseQuality(Item item) {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
	}

	private void decreaseQuality(Item item) {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);
		}
	}

	private void updateBackstagePass(Item item) {
		this.increaseQuality(item);

		if (item.getSellIn() <= 10) {
			this.increaseQuality(item);
		}

		if (item.getSellIn() <= 5) {
			this.increaseQuality(item);
		}
	}

	private void handleExpiredItem(Item item) {
		if (item.getSellIn() >= 0) {
			return;
		}

		switch (item.getItemType()) {
			case AGED_QUALITY_INCREASE:
				this.increaseQuality(item);
				break;
			case BACKSTAGE_PASS:
				item.setQuality(0);
				break;
			default:
				this.decreaseQuality(item);
				break;
		}
	}
}