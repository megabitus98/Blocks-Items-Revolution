package com.mega.bir.helping;

import cpw.mods.fml.common.FMLLog;
import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IChatComponent;
import org.apache.logging.log4j.Level;

/**
 * Created by Megabitus on 8/11/2014 and hour 12.
 */

public class LogHelper {

    public static void log(Level logLevel, Object object)
    {
        FMLLog.log(Reference.MOD_NAME + " " + Reference.VERSION, logLevel, String.valueOf(object));
    }
    public static void all(Object object)
    {
        log(Level.ALL, object);
    }
    public static void debug(Object object)
    {
        log(Level.DEBUG, object);
    }
    public static void error(Object object)
    {
        log(Level.ERROR, object);
    }
    public static void fatal(Object object)
    {
        log(Level.FATAL, object);
    }
    public static void info(Object object)
    {
        log(Level.INFO, object);
    }
    public static void off(Object object)
    {
        log(Level.OFF, object);
    }
    public static void trace(Object object)
    {
        log(Level.TRACE, object);
    }
    public static void warn(Object object)
    {
        log(Level.WARN, object);
    }
}
