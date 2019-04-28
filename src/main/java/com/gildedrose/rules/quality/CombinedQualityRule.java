package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.QualityRule;

public class CombinedQualityRule implements QualityRule {

    private QualityRule[] rules;
    public CombinedQualityRule(QualityRule... rules) {
        this.rules = rules;
    }

    @Override
    public void apply(Item item) {
        for (QualityRule rule : this.rules) {
            rule.apply(item);
        }
    }
}
