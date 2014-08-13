package com.mega.bir.block.tileentity;

import com.mega.bir.helping.LogHelper;
import com.mega.bir.helping.Utilitys;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/11/2014 and hour 23.
 */

public class TileEntityMachine extends TileEntity implements IInventory{
    private ItemStack[] items;

    public TileEntityMachine(){
        items = new ItemStack[1];
    }

    public boolean searchForBlock(World world, int x, int y, int z, Block block) {
        boolean found = false;
        for (int i = x - 2; i <= x + 2; ++i) {
            for (int k = z - 2; k <= z + 2; ++k) {
                for (int j = y - 1; j <= y + 1; ++j) {
                    if (i != 0 || k != 0 || j != 0) {
                        if (world.getBlock(i, j, k) == block) {
                            found = true;
                        }
                    }
                }
            }
        }
        return found;
    }

    @Override
    public void updateEntity() {
        if (searchForBlock(worldObj, xCoord, yCoord, zCoord, Blocks.water)) {
            if (worldObj.isDaytime()) {
                LogHelper.info("Block has found WATER!!! + DAY!!!!!");
            }
        }
    }

    @Override
    public int getSizeInventory(){
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int i){
        return items[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int count){
        ItemStack itemstack = getStackInSlot(i);
        if(itemstack !=null){
            if(itemstack.stackSize <= count){
                setInventorySlotContents(i, null);
            }else{
                itemstack = itemstack.splitStack(count);
                markDirty();
            }
        }
        return itemstack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i){
        ItemStack item = getStackInSlot(i);
        setInventorySlotContents(i, null);
        return item;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack){
        items[i] = itemstack;
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
            itemstack.stackSize = getInventoryStackLimit();
        }
        markDirty();
    }

    @Override
    public String getInventoryName(){
        return "Machine";
    }

    @Override
    public boolean hasCustomInventoryName(){
        return true;
    }

    @Override
    public int getInventoryStackLimit(){
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer){
        return entityPlayer.getDistance(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <=64;
    }

    @Override
    public void openInventory(){}

    @Override
    public void closeInventory(){}

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_){
        return true;
    }
}
