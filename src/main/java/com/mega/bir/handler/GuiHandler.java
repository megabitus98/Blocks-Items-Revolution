package com.mega.bir.handler;

import com.mega.bir.MainClass;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/13/2014 and hour 20.
 */

public class GuiHandler implements IGuiHandler{
    public GuiHandler(){
        NetworkRegistry.INSTANCE.registerGuiHandler(MainClass.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        return null;
    }
}
