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
            addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 136));
        }

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 9; x++){
                addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 78 + y * 18));
            }
        }

        for(int x = 0; x < TileEntityInterChest.INVENTORY_SIZE; x++){
            addSlotToContainer(new Slot(machine, x, 8 + 18 * x, 22));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer){
        return machine.isUseableByPlayer(entityplayer);
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex){
        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack slotItemStack = slot.getStack();
            itemStack = slotItemStack.copy();

            if (slotIndex < TileEntityInterChest.INVENTORY_SIZE)
            {

                if (!this.mergeItemStack(slotItemStack, 1, inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else
            {
                if (!this.mergeItemStack(slotItemStack, 0, TileEntityInterChest.INVENTORY_SIZE, false))
                {
                    return null;
                }
            }

            if (slotItemStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }
}

