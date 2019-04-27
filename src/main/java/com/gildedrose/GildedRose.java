package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals(ItemNames.SULFURAS)) {
                item.sellIn--;
            }

            if (item.name.equals(ItemNames.AGED_BRIE)) {
                this.increaseQuality(item);
                if (item.sellIn < 0) {
                    this.increaseQuality(item);
                }
            } else if (item.name.equals(ItemNames.BACKSTAGE_PASSES)) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else {
                    this.increaseQuality(item);
                    if (item.sellIn < 10) {
                        this.increaseQuality(item);
                        if (item.sellIn < 5) {
                            this.increaseQuality(item);
                        }
                    }
                }
            } else if (!item.name.equals(ItemNames.SULFURAS)) {
                this.decreaseQuality(item);
                if (item.sellIn < 0) {
                    this.decreaseQuality(item);
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.name.equals(ItemNames.SULFURAS)) return;
        if (item.quality >= 50) return;
        item.quality++;
    }

    private void decreaseQuality(Item item) {
        if (item.name.equals(ItemNames.SULFURAS)) return;
        if (item.quality <= 0) return;
        item.quality--;
    }
}