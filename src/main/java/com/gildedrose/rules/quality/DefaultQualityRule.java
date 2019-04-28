package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.QualityRule;

public class DefaultQualityRule implements QualityRule {
    @Override
    public void apply(Item item) {
        if (item.sellIn < 0) item.quality -= 2;
        else item.quality--;
    }
}
