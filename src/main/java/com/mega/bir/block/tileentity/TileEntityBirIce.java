package com.mega.bir.block.tileentity;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

import javax.swing.text.html.parser.Entity;

/**
 * Created by Megabitus on 8/19/2014.
 */

public class TileEntityBirIce extends TileEntity {
    int i = 0;
    public boolean anyPlayerInRange()
    {
        return this.worldObj.getClosestPlayer((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, 5) != null;
    }
    @Override
    public void updateEntity() {
        EntityPlayer player = this.worldObj.getClosestPlayer(this.xCoord, this.yCoord, this.zCoord, 3);
        i++;
        if(i % 120 == 0){
            if(this.anyPlayerInRange()){
            }else{
                worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Blocks.water);
            }
        }
    }
}
