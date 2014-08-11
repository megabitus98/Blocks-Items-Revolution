package com.mega.bir;

import com.mega.bir.handler.ConfigHandler;
import com.mega.bir.helping.LogHelper;
import com.mega.bir.helping.Reference;
import com.mega.bir.init.ModBlocks;
import com.mega.bir.init.ModItems;
import com.mega.bir.proxy.IProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Megabitus on 8/10/2014 and hour 12.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MainClass {
    @Mod.Instance(Reference.MOD_ID)
    public static  MainClass instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        ModItems.register();
        ModBlocks.register();
        LogHelper.info("Has passed the PreInitialization!");
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("Has passed the Initialization!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Has passed the PostInitialization!");
    }
}
