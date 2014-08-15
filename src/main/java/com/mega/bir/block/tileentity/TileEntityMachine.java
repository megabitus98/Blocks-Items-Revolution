package com.mega.bir.block.tileentity;

import com.mega.bir.helping.ItemHelper;
import com.mega.bir.helping.LogHelper;
import com.mega.bir.item.ItemsManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import sun.rmi.runtime.Log;

/**
 * Created by Megabitus on 8/11/2014 and hour 23.
 */

public class TileEntityMachine extends TileEntity implements IInventory{
    public static final int INVENTORY_SIZE = 1;
    private ItemStack[] items;

    public TileEntityMachine(){
        items = new ItemStack[INVENTORY_SIZE];
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
        ItemStack itemstack = getStackInSlot(0);
        if (searchForBlock(worldObj, xCoord, yCoord, zCoord, Blocks.water)) {
            if (worldObj.isDaytime()) {
                if(itemstack !=null){
                    if(itemstack.getItem() == ItemsManager.eye);
                    LogHelper.info("O trecut de apa, zi si null!!");
                }
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

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagList items = new NBTTagList();
        for(int i = 0; i < getSizeInventory(); i++){
            ItemStack stack = getStackInSlot(i);
            if(stack != null){
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", (byte)i);
                stack.writeToNBT(item);
                items.appendTag(item);
            }
        }
        compound.setTag("Items", items);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < items.tagCount(); i++){
            NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
            int slot = item.getByte("Slot");
            if(slot >= 0 && slot < getSizeInventory()){
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
            }
        }
    }
}
