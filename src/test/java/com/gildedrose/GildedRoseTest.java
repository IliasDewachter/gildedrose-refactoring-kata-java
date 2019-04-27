package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    private GildedRose app;
    private OriginalGildedRose originalApp;

    @Before
    public void setUp() {
        this.app = new GildedRose(this.generateItems());
        this.originalApp = new OriginalGildedRose(this.generateItems());
    }

    private Item[] generateItems() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)
        };
    }

    @Test
    public void testGildedRose() {
        for (int day = 0; day < 20; day++) {
            System.out.printf("--- day %d ---\n", day);
            app.updateQuality();
            originalApp.updateQuality();

            assertEquals(originalApp.items.length, app.items.length);
            for (int i = 0; i < app.items.length; i++) {
                Item item = app.items[i];
                Item originalItem = originalApp.items[i];

                System.out.println(item);
                System.out.println(originalItem);
                System.out.println("-----");

                assertEquals(originalItem.name, item.name);
                assertEquals(originalItem.quality, item.quality);
                assertEquals(originalItem.sellIn, item.sellIn);
            }
        }
    }
}
