package com.gildedrose.rules;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.rules.sellin.DefaultSellInRule;
import com.gildedrose.rules.sellin.LegendarySellInRule;

import java.util.HashMap;
import java.util.Map;

public class SellInHandler {

    private static Map<String, SellInRule> sellInRules = new HashMap<>();
    private static SellInRule defaultSellInRule = new DefaultSellInRule();

    static {
        sellInRules.put(ItemNames.SULFURAS, new LegendarySellInRule());
    }

    public static void applySellInRule(Item item) {
        sellInRules.getOrDefault(item.name, defaultSellInRule).apply(item);
    }
}
