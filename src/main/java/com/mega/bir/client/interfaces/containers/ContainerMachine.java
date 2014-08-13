package com.mega.bir.client.interfaces.containers;

import com.mega.bir.block.tileentity.TileEntityMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by Megabitus on 8/13/2014 and hour 19.
 */

public class ContainerMachine extends Container{
    private TileEntityMachine machine;
    public ContainerMachine(InventoryPlayer invPlayer, TileEntityMachine machine){
        this.machine = machine;
    }
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return machine.isUseableByPlayer(entityplayer);
    }
}
