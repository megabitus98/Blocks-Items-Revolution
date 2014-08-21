package com.mega.bir.proxy;

import com.mega.bir.block.tileentity.TileEntityBirIce;
import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.block.tileentity.TileEntityMachine;
import com.mega.bir.handler.EventsHandler;
import com.mega.bir.helping.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Megabitus on 8/10/2014 and hour 12.
 */

public abstract class CommonProxy implements IProxy{
    public void  registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityMachine.class, Names.Tile_Entity_Machine);
        GameRegistry.registerTileEntity(TileEntityInterChest.class, Names.Tile_Entity_Inter_Chest);
        GameRegistry.registerTileEntity(TileEntityBirIce.class, Names.Tile_Entity_Bir_Ice);
    }
    public void registerEventHandlers(){
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }

}
