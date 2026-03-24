package net.kuko.tinyish.data;

import net.kuko.tinyish.TinyIsh;
import net.kuko.tinyish.registries.ModBlocks;
import net.kuko.tinyish.registries.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TinyIsh.MOD_ID);
    }


    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        blockModels.createTrivialCube(ModBlocks.INVERSE_BLOCK.get());
        itemModels.generateFlatItem(ModItems.MARKER.get(), Items.STICK, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().filter(ModModelProvider::excludeBlocks);
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream().filter(ModModelProvider::excludeItems);
    }

    private static boolean excludeBlocks(DeferredHolder<Block, ? extends Block> x) {

//        return x.get() != ModBlocks.PEDESTAL.asItem() && x.get() != ModBlocks.CHAIR.asItem()
//                && !x.is(ModItems.TOMAHAWK);
        // x -> !x.is(ModBlocks.PEDESTAL) && !x.is(ModBlocks.CHAIR
        return true;
    }

    private static boolean excludeItems(DeferredHolder<Item, ? extends Item> x) {

//        return x.get() != ModBlocks.PEDESTAL.asItem() && x.get() != ModBlocks.CHAIR.asItem()
//                && !x.is(ModItems.TOMAHAWK);
        return true;
    }
}
