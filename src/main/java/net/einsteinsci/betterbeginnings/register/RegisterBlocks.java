package net.einsteinsci.betterbeginnings.register;

import net.einsteinsci.betterbeginnings.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterBlocks
{

	public static final Block campfire = new BlockCampfire(false);
	public static final Block campfireLit = new BlockCampfire(true);


	public static void register()
	{


		RegisterHelper.registerBlock(campfire);
		RegisterHelper.registerBlock(campfireLit);



//		oreDictionary();
	}

//	public static void oreDictionary()
//	{
//		OreDictionary.registerOre("craftingTableWood", Blocks.crafting_table);
//	}
}
