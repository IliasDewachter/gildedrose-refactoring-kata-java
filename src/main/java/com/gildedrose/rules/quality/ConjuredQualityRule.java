package com.gildedrose.rules.quality;

import com.gildedrose.Item;

public class ConjuredQualityRule extends MinMaxQualityRule {
    @Override
    public void apply(Item item) {
        if (item.sellIn < 0) item.quality -= 4;
        else item.quality -= 2;
        super.apply(item);
    }
}
