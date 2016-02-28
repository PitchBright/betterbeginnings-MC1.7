package net.einsteinsci.betterbeginnings.register;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper
{
	public static void registerBlock(Block block)
	{
		//substring(5) to remove the "tile." in "tile.blockNameHere".
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item)
	{
		//substring(5) to remove the "item." in "item.itemNameHere".
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}


}
