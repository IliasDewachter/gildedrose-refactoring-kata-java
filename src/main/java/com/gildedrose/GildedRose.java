package com.gildedrose;

import com.gildedrose.rules.QualityHandler;
import com.gildedrose.rules.SellInHandler;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            SellInHandler.applySellInRule(item);
            QualityHandler.applyQualityRule(item);
        }
    }
}