package com.gildedrose.rules;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.rules.quality.*;

import java.util.HashMap;
import java.util.Map;

public class QualityHandler {
    private static Map<String, QualityRule> rules = new HashMap<>();

    private static QualityRule defaultRule = new MinMaxQualityRule(new DefaultQualityRule());
    private static QualityRule conjuredRule = new MinMaxQualityRule(new ConjuredQualityRule());

    static {
        rules.put(ItemNames.AGED_BRIE, new MinMaxQualityRule(new AgedBrieQualityRule()));
        rules.put(ItemNames.BACKSTAGE_PASSES, new MinMaxQualityRule(new BackstagePassedQualityRule()));
        rules.put(ItemNames.SULFURAS, new LegendaryQualityRule());
    }

    public static void applyQualityRule(Item item) {
        if (item.name.startsWith("Conjured")) {
            conjuredRule.apply(item);
        } else {
            rules.getOrDefault(item.name, defaultRule).apply(item);
        }
    }
}
