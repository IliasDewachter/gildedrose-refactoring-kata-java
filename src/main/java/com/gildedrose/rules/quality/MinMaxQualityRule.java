package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.QualityRule;

public class MinMaxQualityRule implements QualityRule {

    private final static int MIN = 0;
    private final static int MAX = 50;

    private QualityRule qualityRule;
    public MinMaxQualityRule(QualityRule qualityRule) {
        this.qualityRule = qualityRule;
    }

    @Override
    public void apply(Item item) {
        this.qualityRule.apply(item);
        if (item.quality < MIN) item.quality = MIN;
        if (item.quality > MAX) item.quality = MAX;
    }
}
