package com.gildedrose.rules.sellin;

import com.gildedrose.Item;
import com.gildedrose.rules.SellInRule;

public class LegendarySellInRule implements SellInRule {
    @Override
    public void apply(Item item) {
        //Legendary items are bind on pickup so you can't sell them!
    }
}
