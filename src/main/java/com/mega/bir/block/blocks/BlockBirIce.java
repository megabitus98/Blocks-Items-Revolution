package com.mega.bir.block.blocks;

import com.mega.bir.MainClass;
import com.mega.bir.block.BlockBir;
import com.mega.bir.block.tileentity.TileEntityBirIce;
import com.mega.bir.creativetab.CreativeTabBir;
import com.mega.bir.helping.LogHelper;
import com.mega.bir.helping.Names;
import net.minecraft.block.BlockIce;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Nitu on 8/19/2014.
 */

public class BlockBirIce extends BlockIce implements ITileEntityProvider {
    public BlockBirIce(){
        super();
        this.setBlockName(Names.Bir_Ice);
        this.setBlockTextureName(Names.Bir_Ice);
        this.setCreativeTab(CreativeTabBir.BIR_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityBirIce();
    }
}
