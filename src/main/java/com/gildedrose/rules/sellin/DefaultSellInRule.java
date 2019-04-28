package com.gildedrose.rules.sellin;

import com.gildedrose.Item;
import com.gildedrose.rules.SellInRule;

public class DefaultSellInRule implements SellInRule {
    @Override
    public void apply(Item item) {
        item.sellIn--;
    }
}
