package com.mega.bir.item;

import com.mega.bir.MainClass;
import com.mega.bir.handler.ToolsHandler;
import com.mega.bir.helping.Names;
import com.mega.bir.helping.Reference;
import com.mega.bir.item.items.ItemDaggerOfSight;
import com.mega.bir.item.items.ItemEye;
import com.mega.bir.item.items.ItemRenamer;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by Megabitus on 8/11/2014 and hour 10.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ItemsManager {
    public static final ItemBir renamer = new ItemRenamer();
    public static final ItemBir eye = new ItemEye();
    public static final Item daggerOfSight = new ItemDaggerOfSight(ToolsHandler.DaggerMaterial);

    public static void register(){
        GameRegistry.registerItem(renamer, Names.Item_Renamer);
        GameRegistry.registerItem(eye,Names.Item_Eye);
        GameRegistry.registerItem(daggerOfSight, Names.Item_Dagger_Of_Sight);
    }
}
