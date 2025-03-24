package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void testSaleDaysLeftDecrease() {
        // Arrange
        Item regular = Item.builder()
            .name("Potion of Loose Coupling")
            .sellIn(0)
            .quality(40)
            .build();

        Item agingProduct = Item.builder()
            .name("Gouda Cheese")
            .itemType(ItemType.AGED_QUALITY_INCREASE)
            .sellIn(2)
            .quality(40)
            .build();

        Item backstagePass = Item.builder()
            .name("Backstage passes for Vrienden van Amstel")
            .itemType(ItemType.BACKSTAGE_PASS)
            .sellIn(30)
            .quality(40)
            .build();

        Item legendary = Item.builder()
            .name("Custom Mechanical Keyboard")
            .itemType(ItemType.LEGENDARY)
            .sellIn(-1)
            .quality(40)
            .build();

        Item[] items = new Item[] { regular, agingProduct, backstagePass, legendary };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(-1, regular.getSellIn());
        assertEquals(1, agingProduct.getSellIn());
        assertEquals(29, backstagePass.getSellIn());
        assertEquals(-1, legendary.getSellIn());
    }

    @Test
    void testNormalQualityDecrease() {
        // Arrange
        Item regular = Item.builder()
            .name("Potion of Loose Coupling")
            .sellIn(1)
            .quality(40)
            .build();
        Item[] items = new Item[] { regular };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(39, regular.getQuality());
    }

    @Test
    void testNormalExpiredQualityDecrease() {
        // Arrange
        Item regular = Item.builder()
            .name("Potion of Loose Coupling")
            .sellIn(0)
            .quality(40)
            .build();
        Item[] items = new Item[] { regular };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(38, regular.getQuality());
    }

    @Test
    void testRegularAgeQualityIncrease() {
        // Arrange
        Item goudaCheese = new Item("Gouda Cheese", ItemType.AGED_QUALITY_INCREASE, 3, 40);
        Item[] items = new Item[] { goudaCheese };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(41, goudaCheese.getQuality());
    }

    @Test
    void testExpiredAgeQualityIncrease() {
        // Arrange
        Item agingProduct = Item.builder()
            .name("Gouda Cheese")
            .itemType(ItemType.AGED_QUALITY_INCREASE)
            .sellIn(0)
            .quality(40)
            .build();
        Item[] items = new Item[] { agingProduct };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(42, agingProduct.getQuality());
    }

    @Test
    void testNormalBackstagePassQualityIncrease() {
        // Arrange
        Item backstagePass = Item.builder()
            .name("Backstage passes for Vrienden van Amstel")
            .itemType(ItemType.BACKSTAGE_PASS)
            .sellIn(11)
            .quality(40)
            .build();
        Item[] items = new Item[] { backstagePass };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(41, backstagePass.getQuality());
    }

    @Test
    void testFasterBackstagePassQualityIncrease() {
        // Arrange
        Item backstagePass = Item.builder()
            .name("Backstage passes for Vrienden van Amstel")
            .itemType(ItemType.BACKSTAGE_PASS)
            .sellIn(10)
            .quality(40)
            .build();
        Item[] items = new Item[] { backstagePass };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(42, backstagePass.getQuality());
    }

    @Test
    void testFastestBackstagePassQualityIncrease() {
        // Arrange
        Item backstagePass = Item.builder()
            .name("Backstage passes for Vrienden van Amstel")
            .itemType(ItemType.BACKSTAGE_PASS)
            .sellIn(5)
            .quality(40)
            .build();
        Item[] items = new Item[] { backstagePass };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(43, backstagePass.getQuality());
    }

    @Test
    void testExpiredBackstagePassQuality() {
        // Arrange
        Item backstagePass = Item.builder()
            .name("Backstage passes for Vrienden van Amstel")
            .itemType(ItemType.BACKSTAGE_PASS)
            .sellIn(0)
            .quality(40)
            .build();
        Item[] items = new Item[] { backstagePass };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(0, backstagePass.getQuality());
    }

    @Test
    void testLegendaryItemImmutability() {
        // Arrange
        Item legendary = Item.builder()
            .name("Custom Mechanical Keyboard")
            .itemType(ItemType.LEGENDARY)
            .sellIn(-1)
            .quality(40)
            .build();
        Item[] items = new Item[] { legendary };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(-1, legendary.getSellIn());
        assertEquals(40, legendary.getQuality());
    }

    @Test
    void testMaxQualityCap() {
        // Arrange

        // In normal cases a backstage pass with less than 6 days of sale left should increase their quality by 3.
        // However, the quality level is already at 49 and should therefore cap at the max quality level of 50.
        Item backstagePass = Item.builder()
            .name("Backstage passes for Vrienden van Amstel")
            .itemType(ItemType.BACKSTAGE_PASS)
            .sellIn(1)
            .quality(49)
            .build();
        Item[] items = new Item[] { backstagePass };

        // Act
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        // Assert
        assertEquals(50, backstagePass.getQuality());
    }

}
