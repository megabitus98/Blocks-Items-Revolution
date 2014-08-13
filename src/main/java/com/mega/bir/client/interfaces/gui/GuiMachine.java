package com.mega.bir.client.interfaces.gui;

import com.mega.bir.block.tileentity.TileEntityMachine;
import com.mega.bir.client.interfaces.containers.ContainerMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Megabitus on 8/13/2014 and hour 19.
 */

@SideOnly(Side.CLIENT)
public class GuiMachine extends GuiContainer{

    private static final ResourceLocation texture = new ResourceLocation("bir", "textures/gui/machine.png");

    public GuiMachine(InventoryPlayer invPlayer, TileEntityMachine machine){
        super(new ContainerMachine(invPlayer, machine));
        xSize = 256;
        ySize = 256;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y){
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}