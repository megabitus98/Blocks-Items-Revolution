package com.mega.bir.helping;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Megabitus on 8/11/2014 and hour 23.
 */

public class Utilitys {
    public boolean searchForBlock(World world, int x, int y, int z,Block block){
        boolean found = false;
        for (int i = x - 2; i <= x + 2; ++i)
        {
            for (int k = z - 2; k <= z + 2; ++k)
            {
                for (int j = y - 1; j <= y + 1; ++j)
                {
                    if (i!=0 || k != 0 || j != 0)
                    {
                        if (world.getBlock(i, j, k) == block)
                        {
                            found = true;
                        }
                    }
                }
            }
        }
        return found;
    }
}
