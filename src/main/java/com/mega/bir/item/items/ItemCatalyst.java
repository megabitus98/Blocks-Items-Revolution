package com.mega.bir.item.items;

import com.mega.bir.helping.LogHelper;
import com.mega.bir.helping.Names;
import com.mega.bir.item.ItemBir;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/15/2014 and hour 09.
 */
public class ItemCatalyst extends ItemBir {
    public ItemCatalyst() {
        super();
        this.setUnlocalizedName(Names.Item_Catalyst);
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity entity, int par4, boolean par5) {
        if (entity instanceof EntityPlayerMP && ((EntityPlayerMP) entity).getCurrentEquippedItem() == item) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                int i = MathHelper.floor_double(player.posX);
                int j = MathHelper.floor_double(player.boundingBox.minY - 1);
                int k = MathHelper.floor_double(player.posZ);
                Material m = world.getBlock(i, j, k).getMaterial();
                boolean flag = (m == Material.water);
                LogHelper.info("Flagu nostru este: " + flag);
                if (flag && player.motionY < 0.0D) {
                    player.posY += -player.motionY;
                    player.motionY = 0.0D;
                    player.fallDistance = 0.0F;

                }
            }
        }
    }
}
