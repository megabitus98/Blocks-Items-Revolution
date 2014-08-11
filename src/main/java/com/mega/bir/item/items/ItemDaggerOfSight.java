package com.mega.bir.item.items;

import com.mega.bir.creativetab.CreativeTabBir;
import com.mega.bir.helping.Names;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/11/2014 and hour 19.
 */

public class ItemDaggerOfSight extends ItemSword{
    public static int OK;
    public ItemDaggerOfSight(ToolMaterial material){
        super(material);
        this.setCreativeTab(CreativeTabBir.BIR_TAB);
        this.setUnlocalizedName(Names.Item_Dagger_Of_Sight);
        this.setTextureName(Names.Item_Dagger_Of_Sight);
    }
    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isHeld) {
        if(isHeld)OK=1;
        else OK=0;
    }
}
