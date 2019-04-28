package com.gildedrose.rules;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.rules.sellin.DefaultSellInRule;
import com.gildedrose.rules.sellin.LegendarySellInRule;

import java.util.HashMap;
import java.util.Map;

public class SellInHandler {
    private Map<String, SellInRule> sellInRules = new HashMap<>();

    private SellInRule defaultSellInRule;

    public SellInHandler() {
        defaultSellInRule = new DefaultSellInRule();

        sellInRules.put(ItemNames.SULFURAS, new LegendarySellInRule());
    }

    public void applySellInRule(Item item) {
        sellInRules.getOrDefault(item.name, defaultSellInRule).apply(item);
    }
}
