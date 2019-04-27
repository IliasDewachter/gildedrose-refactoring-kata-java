package com.gildedrose.rules.quality;

import com.gildedrose.Item;

public class AgedBrieQualityRule extends MinMaxQualityRule {
    @Override
    public void apply(Item item) {
        if (item.sellIn < 0) item.quality += 2;
        else item.quality++;
        super.apply(item);
    }
}
