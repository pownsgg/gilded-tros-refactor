package com.gildedtros;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("AXXES CODE KATA - GILDED TROS");

        Item[] items = new Item[] {
            Item.builder().name("Ring of Cleansening Code").sellIn(10).quality(20).build(),
            Item.builder().name("Good Wine").itemType(ItemType.AGED_QUALITY_INCREASE).sellIn(2).quality(49).build(),
            Item.builder().name("Elixir of the SOLID").sellIn(5).quality(7).build(),
            Item.builder().name("B-DAWG Keychain").itemType(ItemType.LEGENDARY).sellIn(0).quality(80).build(),
            Item.builder().name("B-DAWG Keychain").itemType(ItemType.LEGENDARY).sellIn(-1).quality(80).build(),
            Item.builder().name("Backstage passes for Re:Factor").itemType(ItemType.BACKSTAGE_PASS).sellIn(15).quality(20).build(),
            Item.builder().name("Backstage passes for Re:Factor").itemType(ItemType.BACKSTAGE_PASS).sellIn(10).quality(49).build(),
            Item.builder().name("Backstage passes for HAXX").itemType(ItemType.BACKSTAGE_PASS).sellIn(5).quality(49).build(),
            Item.builder().name("Duplicate Code").sellIn(3).quality(6).build(),
            Item.builder().name("Long Methods").sellIn(3).quality(6).build(),
            Item.builder().name("Ugly Variable Names").sellIn(3).quality(6).build()
        };

        GildedTros app = new GildedTros(items);

        int days = 6;
        if (args.length > 0) {
            try {
	            days = Integer.parseInt(args[0]);
            } catch (NumberFormatException ex) {
                System.out.println("Please provide a number value for the amount of days!");
            }
        }

        for (int i = 0; i <= days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, item type, sellIn, quality");

            for (Item item : items) {
                System.out.println(item);
            }

            System.out.println();
            app.updateQuality();
        }
    }

}
