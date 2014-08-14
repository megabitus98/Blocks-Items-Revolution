package com.mega.bir.handler;

import com.mega.bir.block.BlocksManager;
import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.block.tileentity.TileEntityMachine;
import com.mega.bir.helping.Names;
import com.mega.bir.item.ItemsManager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by Megabitus on 8/11/2014 and hour 20.
 */

public class RegisterHandler {
    public static void registerMain(){
        BlocksManager.register();
        ItemsManager.register();
        recipes();
        events();
        tileEntities();
    }

    private static void events(){
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }
    private static void recipes(){
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsManager.daggerOfSight), "stickWood", "ingotIron"));
    }
    private static void tileEntities(){
        GameRegistry.registerTileEntity(TileEntityMachine.class, Names.Tile_Entity_Machine);
        GameRegistry.registerTileEntity(TileEntityInterChest.class, Names.Tile_Entity_Inter_Chest);
    }

}
