package me.meta4245.betterthanmodern.event;

import me.meta4245.betterthanmodern.item.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class ItemRegistry {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item rawMutton;
    public static Item rawChicken;
    public static Item rawPorkchop;
    public static Item rawBeef;

    public static Item cookedChicken;
    public static Item cookedMutton;
    public static Item cookedPorkchop;
    public static Item steak;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        rawMutton = new RawMutton(NAMESPACE.id("raw_mutton")).setTranslationKey(NAMESPACE, "raw_mutton");
        rawChicken = new RawChicken(NAMESPACE.id("raw_chicken")).setTranslationKey(NAMESPACE, "raw_chicken");
        rawPorkchop = new RawPorkchop(NAMESPACE.id("raw_porkchop")).setTranslationKey(NAMESPACE, "raw_porkchop");
        rawBeef = new RawBeef(NAMESPACE.id("raw_beef")).setTranslationKey(NAMESPACE, "raw_beef");

        cookedChicken = new CookedChicken(NAMESPACE.id("cooked_chicken")).setTranslationKey(NAMESPACE, "cooked_chicken");
        cookedMutton = new CookedMutton(NAMESPACE.id("cooked_mutton")).setTranslationKey(NAMESPACE, "cooked_mutton");
        cookedPorkchop = new CookedPorkchop(NAMESPACE.id("cooked_porkchop")).setTranslationKey(NAMESPACE, "cooked_porkchop");
        steak = new Steak(NAMESPACE.id("steal")).setTranslationKey(NAMESPACE, "steak");
    }
}
