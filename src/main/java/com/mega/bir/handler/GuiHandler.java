package com.mega.bir.handler;

import com.mega.bir.MainClass;
import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.block.tileentity.TileEntityMachine;
import com.mega.bir.client.interfaces.interchest.ContainerInterChest;
import com.mega.bir.client.interfaces.interchest.GuiInterChest;
import com.mega.bir.client.interfaces.machine.ContainerMachine;
import com.mega.bir.client.interfaces.machine.GuiMachine;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
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
        switch(ID){
            case 0:
                TileEntity te = world.getTileEntity(x,y,z);
                if(te != null && te instanceof TileEntityMachine){
                    return new ContainerMachine(player.inventory, (TileEntityMachine)te, world);
                }
                break;
            case 1:
                te = world.getTileEntity(x,y,z);
                if(te != null && te instanceof TileEntityInterChest){
                    return new ContainerInterChest(player.inventory, (TileEntityInterChest)te);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        switch(ID){
            case 0:
                TileEntity te = world.getTileEntity(x,y,z);
                if(te != null && te instanceof TileEntityMachine){
                    return new GuiMachine(player.inventory, (TileEntityMachine)te, world);
                }
                break;
            case 1:
                te = world.getTileEntity(x,y,z);
                if(te != null && te instanceof TileEntityInterChest){
                    return new GuiInterChest(player.inventory, (TileEntityInterChest)te);
                }
                break;
        }
        return null;
    }
}
