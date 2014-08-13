package com.mega.bir.block.blocks;

import com.mega.bir.MainClass;
import com.mega.bir.block.BlockBir;
import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.helping.Names;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/11/2014 and hour 10.
 */

public class BlockInterChest extends BlockBir implements ITileEntityProvider {
    public BlockInterChest(){
        super();
        this.setBlockName(Names.Block_Inter_Chest);
        this.setBlockTextureName(Names.Block_Inter_Chest);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityInterChest();
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        if(!world.isRemote){
            FMLNetworkHandler.openGui(player, MainClass.instance, 1, world, x, y, z);
        }
        return true;
    }
}
