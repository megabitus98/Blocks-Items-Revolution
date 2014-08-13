package com.mega.bir.block.blocks;

import com.mega.bir.MainClass;
import com.mega.bir.block.tileentity.TileEntityMachine;
import com.mega.bir.creativetab.CreativeTabBir;
import com.mega.bir.helping.Names;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/11/2014 and hour 23.
 */

public class BlockMachine extends BlockContainer {
    public BlockMachine(){
        super(Material.rock);
        this.setBlockName(Names.Block_Machine);
        this.setBlockTextureName(Names.Block_Machine);
        this.setCreativeTab(CreativeTabBir.BIR_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityMachine();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        if(!world.isRemote){
            FMLNetworkHandler.openGui(player, MainClass.instance, 0, world, x, y, z);
        }
        return true;
    }
}
