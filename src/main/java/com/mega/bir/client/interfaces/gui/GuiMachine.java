package com.mega.bir.client.interfaces.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Megabitus on 8/13/2014 and hour 19.
 */
@SideOnly(Side.CLIENT)
public class GuiMachine extends GuiContainer{
    private static final ResourceLocation texture = new ResourceLocation("bir", "textures/gui/machine.png");

    public GuiMachine(){
        xSize = 256;
        ySize = 256;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
