package com.gildedtros;

import java.util.Arrays;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("AXXES CODE KATA - GILDED TROS");

        Item[] items = new Item[] {
            new Item("Ring of Cleansening Code", 10, 20),
            new Item("Good Wine", ItemType.AGED_QUALITY_INCREASE, 2, 49),
            new Item("Elixir of the SOLID", 5, 7),
            new Item("B-DAWG Keychain", ItemType.LEGENDARY, 0, 80),
            new Item("B-DAWG Keychain", ItemType.LEGENDARY, -1, 80),
            new Item("Backstage passes for Re:Factor", ItemType.BACKSTAGE_PASS, 15, 20),
            new Item("Backstage passes for Re:Factor", ItemType.BACKSTAGE_PASS, 10, 49),
            new Item("Backstage passes for HAXX", ItemType.BACKSTAGE_PASS, 5, 49),
            new Item("Duplicate Code", 3, 6),
            new Item("Long Methods", 3, 6),
            new Item("Ugly Variable Names", 3, 6)
        };

        GildedTros app = new GildedTros(items);

        int days = 2;
        if (args.length > 0) {
            try {
                int daysFromArgument = Integer.parseInt(args[0]);
                days = daysFromArgument + 1;
            } catch (NumberFormatException ex) {
                System.out.println("Please provide a number value for the amount of days!");
            }
        }

        for (int i = 0; i <= days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");

            Arrays.stream(items)
                .sequential()
                .forEach(System.out::println);

            System.out.println();
            app.updateQuality();
        }
    }

}
