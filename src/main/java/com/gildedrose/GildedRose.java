package com.gildedrose;

import com.gildedrose.rules.QualityHandler;
import com.gildedrose.rules.SellInHandler;

class GildedRose {
    Item[] items;
    private SellInHandler sellInHandler;
    private QualityHandler qualityHandler;

    GildedRose(Item[] items) {
        this.items = items;
        this.sellInHandler = new SellInHandler();
        this.qualityHandler = new QualityHandler();
    }

    void updateQuality() {
        for (Item item : items) {
            sellInHandler.applySellInRule(item);
            qualityHandler.applyQualityRule(item);
        }
    }
}