package com.mega.bir.handler;


import com.mega.bir.helping.LogHelper;
import com.mega.bir.helping.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Megabitus on 8/10/2014 and hour 13.
 */

public class ConfigHandler{
    public static Configuration configuration;
    //Config statements
    public static boolean fuelReq;
    //End of config statments
    public static void init(File configFile) {
    // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    private static void loadConfiguration(){
        fuelReq = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "Do the chest need power to work?|True=yes,False=no");
        if (configuration.hasChanged())
        {
            LogHelper.info("Has saved the configuration file!");
            configuration.save();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }
}

