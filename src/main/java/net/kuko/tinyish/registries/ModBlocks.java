package net.kuko.tinyish.registries;

import net.kuko.tinyish.TinyIsh;
import net.kuko.tinyish.registries.block.InverseBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TinyIsh.MOD_ID);


    public static final DeferredBlock<Block> INVERSE_BLOCK = block("inverse",
            (properties) -> new InverseBlock(properties));




    private static <T extends Block> DeferredBlock<T> block(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(toReturn.get(),
                properties.useBlockDescriptionPrefix()));
        return toReturn;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
