package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.QualityRule;

public class LimitQualityRule implements QualityRule {

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    @Override
    public void apply(Item item) {
        if (item.quality < MIN_QUALITY) item.quality = MIN_QUALITY;
        else if (item.quality > MAX_QUALITY) item.quality = MAX_QUALITY;
    }
}
