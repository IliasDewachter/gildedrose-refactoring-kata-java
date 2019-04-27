package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.QualityRule;

public class LegendaryQualityRule implements QualityRule {
    @Override
    public void apply(Item item) {
        //Legendary items can't lose quality!
    }
}
