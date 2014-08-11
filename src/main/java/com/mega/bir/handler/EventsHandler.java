package com.mega.bir.handler;

import com.mega.bir.item.ItemsManager;
import com.mega.bir.item.items.ItemDaggerOfSight;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * Created by Megabitus on 8/11/2014 and hour 21.
 */

public class EventsHandler {
    private boolean randomBoolean(){
        return Math.random() <0.5;
    }
    @SubscribeEvent
    public void onPlayerKill(LivingDeathEvent event){
        if(event.source.getEntity() instanceof EntityPlayer)
            if(event.entity instanceof EntityMob)
                if(ItemDaggerOfSight.OK == 1)
                    if(randomBoolean() == true)
                        event.entityLiving.dropItem(ItemsManager.eye, 1);
    }

}
