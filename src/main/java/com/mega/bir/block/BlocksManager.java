package com.mega.bir.block;

import com.mega.bir.block.blocks.BlockBirIce;
import com.mega.bir.block.blocks.BlockInterChest;
import com.mega.bir.block.blocks.BlockMachine;
import com.mega.bir.block.blocks.BlockTelotriteOre;
import com.mega.bir.helping.Names;
import com.mega.bir.helping.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by Megabitus on 8/11/2014 and hour 10.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class BlocksManager {
    public static final BlockBir interChest = new BlockInterChest();
    public static final BlockBir telotriteOre = new BlockTelotriteOre();
    public static final BlockBir machine = new BlockMachine();
    public static final Block birice = new BlockBirIce();
    
    public static void register()
    {
        GameRegistry.registerBlock(interChest, Names.Block_Inter_Chest);
        GameRegistry.registerBlock(telotriteOre, Names.Block_Telotrite_Ore);
        GameRegistry.registerBlock(machine, Names.Block_Machine);
        GameRegistry.registerBlock(birice, Names.Bir_Ice);

    }
}
