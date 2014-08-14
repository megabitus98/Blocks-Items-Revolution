package com.mega.bir.block.tileentity;

import com.mega.bir.helping.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import sun.misc.JavaIOAccess;

import java.io.*;


/**
 * Created by Megabitus on 8/13/2014 and hour 23.
 */

public class TileEntityInterChest extends TileEntity implements IInventory{
    public static String TextName;
    PrintWriter writer;
    FileInputStream fstream;
    private ItemStack[] items;

    public TileEntityInterChest(){
        items = new ItemStack[9];
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
        return "Inter Chest";
    }

    @Override
    public boolean hasCustomInventoryName(){
        return true;
    }

    @Override
    public int getInventoryStackLimit(){
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer){
        return entityPlayer.getDistance(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <=64;
    }

    @Override
    public void openInventory(){}

    @Override
    public void closeInventory(){

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_){
        return true;
    }

    private void fileRead(String FileName){
        try {
            fstream = new FileInputStream(FileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println (strLine);
            }
            in.close();
        }catch (IOException ex){
            LogHelper.warn("Error while reading: " + ex);
        }
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
                try {
                    writer = new PrintWriter(new FileWriter(TextName, true));
                    writer.write(stack.getItem().getUnlocalizedName() + " " + stack.stackSize);
                    writer.write('\n');
                    writer.write(stack.stackSize);
                    writer.close();
                }catch (IOException ex){
                    LogHelper.warn("Error while writing NBT file: " + ex);
                }finally {
                    writer.close();
                }
            }
        }
        compound.setTag("Items", items);
        if(TextName != null){
            compound.setString("Text", TextName);
        }else if(TextName == null){
            TextName = "Enter Text Here!";
            compound.setString("Text", TextName);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        //TODO ALSO READ FROM INTERNET THING!?
        super.readFromNBT(compound);
        NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < items.tagCount(); i++){
            NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
            int slot = item.getByte("Slot");
            if(slot >= 0 && slot < getSizeInventory()){
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
            }
        }
        TextName = compound.getString("Text");
    }
}
