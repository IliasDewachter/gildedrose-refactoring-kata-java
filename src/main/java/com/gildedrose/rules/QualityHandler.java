package com.gildedrose.rules;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.rules.quality.*;

import java.util.HashMap;
import java.util.Map;

public class QualityHandler {
    private Map<String, QualityRule> rules = new HashMap<>();

    private QualityRule defaultRule;
    private QualityRule conjuredRule;

    public QualityHandler() {
        defaultRule = new CombinedQualityRule(new DefaultQualityRule(), new LimitQualityRule());
        conjuredRule = new CombinedQualityRule(new ConjuredQualityRule(), new LimitQualityRule());

        rules.put(ItemNames.AGED_BRIE, new CombinedQualityRule(new AgedBrieQualityRule(), new LimitQualityRule()));
        rules.put(ItemNames.BACKSTAGE_PASSES, new CombinedQualityRule(new BackstagePassedQualityRule(), new LimitQualityRule()));
        rules.put(ItemNames.SULFURAS, new LegendaryQualityRule());
    }

    public void applyQualityRule(Item item) {
        if (item.name.startsWith("Conjured")) {
            conjuredRule.apply(item);
        } else {
            rules.getOrDefault(item.name, defaultRule).apply(item);
        }
    }
}
