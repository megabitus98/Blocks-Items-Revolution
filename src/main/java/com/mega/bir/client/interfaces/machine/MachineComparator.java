package com.mega.bir.client.interfaces.machine;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

/**
 * Created by Megabitus on 8/20/2014.
 */

public class MachineComparator implements Comparator {
    final MachineCraftingManager machineCraftingManager;

    public MachineComparator(MachineCraftingManager par1MachineCraftingManager)
    {
        this.machineCraftingManager = par1MachineCraftingManager;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof MachineShapelessRecipes && par2IRecipe instanceof MachineShapedRecipes ? 1 : (par2IRecipe instanceof MachineShapelessRecipes && par1IRecipe instanceof MachineShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}
