package com.mega.bir.client.interfaces.interchest;

import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.block.tileentity.TileEntityMachine;
import com.mega.bir.client.interfaces.machine.ContainerMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Megabitus on 8/13/2014 and hour 23.
 */

@SideOnly(Side.CLIENT)
public class GuiInterChest extends GuiContainer{

    private static final ResourceLocation texture = new ResourceLocation("bir", "textures/gui/inter_chest.png");

    public GuiInterChest(InventoryPlayer invPlayer, TileEntityInterChest machine){
        super(new ContainerInterChest(invPlayer, machine));
        xSize = 176;
        ySize = 166;
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y){
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString("Inter Chest", 8, 6, 0x404040);
        fontRendererObj.drawString("Inventory", 10, 66, 0x404040);
    }
}
