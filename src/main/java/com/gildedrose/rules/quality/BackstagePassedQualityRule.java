package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.QualityRule;

public class BackstagePassedQualityRule implements QualityRule {
    @Override
    public void apply(Item item) {
        if (item.sellIn < 0) item.quality = 0;
        else if (item.sellIn < 5) item.quality += 3;
        else if (item.sellIn < 10) item.quality += 2;
        else item.quality++;
    }
}
