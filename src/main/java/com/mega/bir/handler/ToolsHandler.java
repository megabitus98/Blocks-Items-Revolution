package com.mega.bir.handler;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by Megabitus on 8/11/2014 and hour 21.
 */

public class ToolsHandler {
    private float DMG = 1.5F;

    public final Item.ToolMaterial Dagger = EnumHelper.addToolMaterial("Dagger", 3, 151, 12.0F, DMG, 22);
}
