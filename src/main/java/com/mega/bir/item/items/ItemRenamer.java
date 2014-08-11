package com.mega.bir.item.items;

import com.mega.bir.helping.Names;
import com.mega.bir.item.ItemBir;

/**
 * Created by Megabitus on 8/11/2014 and hour 10.
 */
public class ItemRenamer extends ItemBir{
    public ItemRenamer(){
        super();
        this.setUnlocalizedName(Names.Item_Renamer);
        this.setMaxStackSize(1);
    }
}
