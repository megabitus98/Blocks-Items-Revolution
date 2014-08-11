package com.mega.bir.block;

import com.mega.bir.block.blocks.BlockInterChest;
import com.mega.bir.helping.Names;
import com.mega.bir.helping.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Megabitus on 8/11/2014 and hour 10.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class BlocksManager {
    public static final BlockBir interChest = new BlockInterChest();
    
    public static void register()
    {
        GameRegistry.registerBlock(interChest, Names.Block_Inter_Chest);
    }
}
