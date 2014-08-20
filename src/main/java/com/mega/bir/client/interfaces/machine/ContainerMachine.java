package com.mega.bir.client.interfaces.machine;

import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.block.tileentity.TileEntityMachine;

import com.mega.bir.helping.ItemHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/13/2014 and hour 19.
 */

public class ContainerMachine extends Container{
    private TileEntityMachine machine;
    private World worldObj;
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 1);
    public IInventory craftResult = new InventoryCraftResult();

    public ContainerMachine(InventoryPlayer invPlayer, TileEntityMachine machine){
        this.machine = machine;
        for(int x = 0; x < 9; x++){
            addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 142));
        }

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 9; x++){
                addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
            }
        }
        this.addSlotToContainer(new Slot(this.craftMatrix, 0, 30, 34));
        this.addSlotToContainer(new Slot(this.craftMatrix, 1, 130, 34));
        this.addSlotToContainer(new SlotCrafting(invPlayer.player, this.craftMatrix, this.craftResult, 2, 79, 34));
        onCraftMatrixChanged(craftMatrix);
    }
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer){
        return machine.isUseableByPlayer(entityplayer);
    }
    @Override
    protected boolean mergeItemStack(ItemStack itemStack, int slotMin, int slotMax, boolean ascending)
    {
        boolean slotFound = false;
        int currentSlotIndex = ascending ? slotMax - 1 : slotMin;

        Slot slot;
        ItemStack stackInSlot;

        if (itemStack.isStackable())
        {
            while (itemStack.stackSize > 0 && (!ascending && currentSlotIndex < slotMax || ascending && currentSlotIndex >= slotMin))
            {
                slot = (Slot) this.inventorySlots.get(currentSlotIndex);
                stackInSlot = slot.getStack();

                if (slot.isItemValid(itemStack) && ItemHelper.equalsIgnoreStackSize(itemStack, stackInSlot))
                {
                    int combinedStackSize = stackInSlot.stackSize + itemStack.stackSize;
                    int slotStackSizeLimit = Math.min(stackInSlot.getMaxStackSize(), slot.getSlotStackLimit());

                    if (combinedStackSize <= slotStackSizeLimit)
                    {
                        itemStack.stackSize = 0;
                        stackInSlot.stackSize = combinedStackSize;
                        slot.onSlotChanged();
                        slotFound = true;
                    }
                    else if (stackInSlot.stackSize < slotStackSizeLimit)
                    {
                        itemStack.stackSize -= slotStackSizeLimit - stackInSlot.stackSize;
                        stackInSlot.stackSize = slotStackSizeLimit;
                        slot.onSlotChanged();
                        slotFound = true;
                    }
                }

                currentSlotIndex += ascending ? -1 : 1;
            }
        }

        if (itemStack.stackSize > 0)
        {
            currentSlotIndex = ascending ? slotMax - 1 : slotMin;

            while (!ascending && currentSlotIndex < slotMax || ascending && currentSlotIndex >= slotMin)
            {
                slot = (Slot) this.inventorySlots.get(currentSlotIndex);
                stackInSlot = slot.getStack();

                if (slot.isItemValid(itemStack) && stackInSlot == null)
                {
                    slot.putStack(ItemHelper.cloneItemStack(itemStack, Math.min(itemStack.stackSize, slot.getSlotStackLimit())));
                    slot.onSlotChanged();

                    if (slot.getStack() != null)
                    {
                        itemStack.stackSize -= slot.getStack().stackSize;
                        slotFound = true;
                    }

                    break;
                }

                currentSlotIndex += ascending ? -1 : 1;
            }
        }

        return slotFound;
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
    @Override
    public void onCraftMatrixChanged(IInventory iinventory)
    {
    //    craftResult.setInventorySlotContents(0, MachineCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }
    @Override
    public void onContainerClosed(EntityPlayer entityplayer)
    {
        super.onContainerClosed(entityplayer);
        for(int i = 0; i < TileEntityInterChest.INVENTORY_SIZE; i++)
        {
            ItemStack itemstack = craftMatrix.getStackInSlot(i);
            if(itemstack != null)
            {
                entityplayer.entityDropItem(itemstack, 0.05F);
            }
        }
    }
}
