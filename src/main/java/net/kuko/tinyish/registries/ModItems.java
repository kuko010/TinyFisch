package net.kuko.tinyish.registries;

import net.kuko.tinyish.TinyIsh;
import net.kuko.tinyish.registries.item.MarkerItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TinyIsh.MOD_ID);

    public static final DeferredItem<Item> MARKER = ITEMS.registerItem( "marker",
            MarkerItem::new, props -> props);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
