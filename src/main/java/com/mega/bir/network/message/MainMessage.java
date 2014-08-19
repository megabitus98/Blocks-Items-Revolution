package com.mega.bir.network.message;

import com.mega.bir.block.tileentity.TileEntityInterChest;
import com.mega.bir.helping.LogHelper;
import com.mega.bir.helping.Reference;
import com.mega.bir.network.PacketHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Megabitus on 8/15/2014 and hour 11.
 */

public class MainMessage implements IMessage{
    public int mess;

    public MainMessage(){

    }
    public MainMessage(int a){
        this.mess = a;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.mess = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(mess);
    }
}
