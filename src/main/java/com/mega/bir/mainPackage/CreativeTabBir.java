package com.mega.bir.mainPackage;

import com.mega.bir.helping.Reference;
import com.mega.bir.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Megabitus on 8/11/2014 and hour 11.
 */

public class CreativeTabBir {
    public static final CreativeTabs BIR_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return ModItems.renamer;
        }
    };
}
