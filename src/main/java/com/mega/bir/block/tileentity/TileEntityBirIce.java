package com.mega.bir.block.tileentity;


import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Nitu on 8/19/2014.
 */
public class TileEntityBirIce extends TileEntity {
    int i = 0;
    @Override
    public void updateEntity() {
        i++;
        if(i % 120 == 0){
            worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Blocks.water);
        }
    }
}
