package fr.hiddenblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public final class HiddenBlocksMod implements ModInitializer {
    public static final String MOD_ID = "hiddenblocks";

    /*
     * These vanilla blocks have no normal vanilla item. The mod creates a
     * dedicated BlockItem for each one and puts it in Operator Utilities.
     * Existing operator items (barrier, spawner, command blocks, light block,
     * structure block, jigsaw, etc.) are already supplied by vanilla and are
     * deliberately not duplicated.
     */
    private static final List<String> BLOCKS_WITHOUT_VANILLA_ITEMS = List.of(
        "nether_portal",
        "end_portal",
        "end_gateway",
        "fire",
        "soul_fire",
        "piston_head",
        "moving_piston"
    );

    @Override
    public void onInitialize() {
        List<Item> operatorItems = new ArrayList<>();

        for (String path : BLOCKS_WITHOUT_VANILLA_ITEMS) {
            Identifier blockId = Identifier.fromNamespaceAndPath("minecraft", path);
            Block block = BuiltInRegistries.BLOCK.getValue(blockId);

            if (block == null || block == Blocks.AIR) {
                continue;
            }

            Identifier itemId = Identifier.fromNamespaceAndPath(MOD_ID, path);
            Item item = Registry.register(
                BuiltInRegistries.ITEM,
                itemId,
                new BlockItem(block, new Item.Properties())
            );
            operatorItems.add(item);
        }

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.OP_BLOCKS)
            .register(output -> operatorItems.forEach(output::accept));
    }
}
