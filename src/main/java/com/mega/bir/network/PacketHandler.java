package com.mega.bir.network;

import com.mega.bir.handler.MessageHandler;
import com.mega.bir.helping.Reference;
import com.mega.bir.network.message.MainMessage;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by Megabitus on 8/14/2014 and hour 20.
 */
public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.CHANNEL);
    public static void initPackets(){
        INSTANCE.registerMessage(MessageHandler.class, MainMessage.class, 0, Side.CLIENT);
    }
}
