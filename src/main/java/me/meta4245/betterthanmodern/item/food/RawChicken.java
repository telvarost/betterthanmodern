package me.meta4245.betterthanmodern.item.food;

import net.modificationstation.stationapi.api.template.item.TemplateStackableFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class RawChicken extends TemplateStackableFoodItem {
    public RawChicken(Identifier identifier) {
        super(identifier, 2, true, 64);
    }
}
