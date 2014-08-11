package com.mega.bir.item;

import com.mega.bir.helping.Names;
import com.mega.bir.helping.Reference;
import com.mega.bir.item.items.ItemDaggerOfSight;
import com.mega.bir.item.items.ItemEye;
import com.mega.bir.item.items.ItemRenamer;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Megabitus on 8/11/2014 and hour 10.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ItemsManager {
    public static final ItemBir renamer = new ItemRenamer();
    public static final ItemBir eye = new ItemEye();
    public static final ItemBir daggerOfSight = new ItemDaggerOfSight();

    public static void register(){
        GameRegistry.registerItem(renamer, Names.Item_Renamer);
        GameRegistry.registerItem(eye,Names.Item_Eye);
        GameRegistry.registerItem(daggerOfSight, Names.Item_Dagger_Of_Sight);
    }
}
