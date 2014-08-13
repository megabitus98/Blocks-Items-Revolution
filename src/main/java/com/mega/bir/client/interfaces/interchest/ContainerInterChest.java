package com.mega.bir.client.interfaces.interchest;

import com.mega.bir.block.tileentity.TileEntityInterChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Megabitus on 8/13/2014 and hour 23.
 */
public class ContainerInterChest extends Container{
    private TileEntityInterChest machine;

    public ContainerInterChest(InventoryPlayer invPlayer, TileEntityInterChest machine){
        this.machine = machine;
        for(int x = 0; x < 9; x++){
            addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
        }

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 9; x++){
                addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
            }
        }

        for(int x = 0; x < 9; x++){
            addSlotToContainer(new Slot(machine, x, 79 + 18 * x, 34));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer){
        return machine.isUseableByPlayer(entityplayer);
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i){
        return null;
    }
}
