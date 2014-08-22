package com.mega.bir.client.interfaces.interchest;

import com.mega.bir.block.blocks.BlockInterChest;
import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.helping.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

/**
 * Created by Megabitus on 8/13/2014 and hour 23.
 */

@SideOnly(Side.CLIENT)
public class GuiInterChest extends GuiContainer{

    private static final ResourceLocation texture = new ResourceLocation("bir", "textures/gui/inter_chest.png");
    private GuiTextField textfield;
    private final TileEntityInterChest tileEntityInterChest;
    private EntityPlayer player;
    public  String text;

    public GuiInterChest(InventoryPlayer invPlayer, TileEntityInterChest interChest){
        super(new ContainerInterChest(invPlayer, interChest));
        xSize = 176;
        ySize = 166;
        player = invPlayer.player;
        this.tileEntityInterChest = interChest;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y){
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        this.textfield.drawTextBox();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        fontRendererObj.drawString("Inter Chest", 8, 6, 0x404040);
        fontRendererObj.drawString("Inventory", 10, 66, 0x404040);
    }

    @Override
    public void initGui() {
        super.initGui();
        textfield = new GuiTextField(this.fontRendererObj, guiLeft + 7, guiTop + 43, 100,20);
        textfield.setFocused(true);
        textfield.setMaxStringLength(16);
        buttonList.clear();
        buttonList.add(new GuiButton(0, guiLeft + 111, guiTop + 43, 60, 20, "Sync"));
        LogHelper.fatal(tileEntityInterChest.ONameP);
        text = tileEntityInterChest.ONameP;
        LogHelper.fatal(text);
        textfield.setText(text);
    }

    @Override
    protected void keyTyped(char par1, int par2)
    {
        this.textfield.textboxKeyTyped(par1, par2);
        if(!( par2 ==  Keyboard.KEY_E  &&  this.textfield.isFocused())) super.keyTyped(par1, par2);
    }

    @Override
    protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x, y, btn);
        this.textfield.mouseClicked(x, y, btn);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if(button.id == 0){

            LogHelper.info("Button with id 0 HAS BEEN CLICKED cu mesaju:");
            //TODO Sync with other chests!
        }
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
        this.textfield.updateCursorCounter();
        if(org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_RETURN) || !textfield.isFocused()){
            text = textfield.getText();
            textfield.setFocused(false);
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        tileEntityInterChest.PlayerName = text;
    }
}
