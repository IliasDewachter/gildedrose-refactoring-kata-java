package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(ItemNames.SULFURAS)) continue;

            item.sellIn--;

            if (item.name.equals(ItemNames.AGED_BRIE)) {
                if (item.sellIn < 0) item.quality += 2;
                else item.quality++;
            } else if (item.name.equals(ItemNames.BACKSTAGE_PASSES)) {
                if (item.sellIn < 0) item.quality = 0;
                else if (item.sellIn < 5) item.quality += 3;
                else if (item.sellIn < 10) item.quality += 2;
                else item.quality++;
            } else {
                if (item.sellIn < 0) item.quality -= 2;
                else item.quality--;
            }

            if (item.quality > 50) item.quality = 50;
            if (item.quality < 0) item.quality = 0;
        }
    }
}