package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn--;
            }

            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality++;
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    item.quality++;

                    if (item.sellIn < 10 && item.quality < 50) {
                        item.quality++;

                        if (item.sellIn < 5 && item.quality < 50) {
                            item.quality++;
                        }
                    }
                }
            } else if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality--;
            }

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else if (!item.name.equals("Sulfuras, Hand of Ragnaros") && item.quality > 0) {
                    item.quality--;
                }
            }
        }
    }
}