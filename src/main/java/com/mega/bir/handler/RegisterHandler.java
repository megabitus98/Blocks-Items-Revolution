package com.mega.bir.handler;

import com.mega.bir.block.BlocksManager;
import com.mega.bir.item.ItemsManager;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Megabitus on 8/11/2014 and hour 20.
 */

public class RegisterHandler {
    public static void registerMain(){
        BlocksManager.register();
        ItemsManager.register();
        events();
    }

    private static void events(){
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }

}
