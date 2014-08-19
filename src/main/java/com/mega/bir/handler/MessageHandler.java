package com.mega.bir.handler;

import com.mega.bir.network.message.MainMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Megabitus on 8/14/2014 and hour 18.
 */

public class MessageHandler implements IMessageHandler<MainMessage, IMessage> {
    @Override
    public IMessage onMessage(MainMessage message, MessageContext ctx) {
        System.out.println(String.format("Received %s from %s", message.mess, ctx.getServerHandler().playerEntity.getDisplayName()));
        return null;
    }
}
