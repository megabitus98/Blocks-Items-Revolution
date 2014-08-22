package com.mega.bir.block.tileentity;

import com.mega.bir.block.blocks.BlockInterChest;
import com.mega.bir.helping.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import sun.misc.JavaIOAccess;
import sun.org.mozilla.javascript.internal.ast.Block;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Megabitus on 8/13/2014 and hour 23.
 */

public class TileEntityInterChest extends TileEntity implements IInventory{

    public static final int INVENTORY_SIZE = 9;
    private ItemStack[] items;
    public String PlayerName = BlockInterChest.PlayerName;
    public TileEntityInterChest(){
        items = new ItemStack[INVENTORY_SIZE];
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
    public void closeInventory(){}

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_){
        return true;
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
        this.PlayerName = compound.getString("Name");
        LogHelper.info("Am citit: " + compound.getString("Name"));
   //     addFileItemsToChest();
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagList items = new NBTTagList();
        for(int i = 0; i < getSizeInventory(); i++){
            ItemStack stack = getStackInSlot(i);
            if(stack != null) {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", (byte) i);
                stack.writeToNBT(item);
                items.appendTag(item);
            }
        }
        compound.setTag("Items", items);
        LogHelper.info("Am scris: " + this.PlayerName);
        compound.setString("Name", this.PlayerName);
        addChestItemsToFile(PlayerName);
    }

    public void addChestItemsToFile(String playerName){
        String fileName = "InterChestInventory " + playerName + ".bin";
        try{
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            if(!file.exists()){
                file.createNewFile();
            }
            for(int acitf = 0; acitf < getSizeInventory(); acitf++){
                ItemStack stack = getStackInSlot(acitf);
                if(stack != null) {
                    String ItemName = stack.getItem() + "\r" + stack.stackSize + "\r";
                    bufferedWriter.write(ItemName);
                }
            }
            bufferedWriter.close();
        }catch (IOException e){
            LogHelper.fatal("Error while making a new InterChest file: " + e);
        }
    }

    public void addFileItemsToChest(String playerName){
        String fileName = "InterChestInventory " + playerName + ".bin";
        try{
            String CurrentLine;
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(fileName));
            for(int afittc = 0; afittc < getSizeInventory() * 2; afittc++){
                CurrentLine = br.readLine();
                System.out.println(CurrentLine);
            }
            br.close();
        }catch (IOException e){
            LogHelper.fatal("Error while reading a InterChest file: " + e);
        }
    }

}
