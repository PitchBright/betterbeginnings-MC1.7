package net.einsteinsci.betterbeginnings.register;

import cpw.mods.fml.common.registry.GameRegistry;
import net.einsteinsci.betterbeginnings.config.BBConfig;
import net.einsteinsci.betterbeginnings.register.recipe.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.*;

public class RegisterRecipes
{


	public static void addFurnaceRecipes()
	{

		addCampfireRecipes();
	}



	

	private static void addCampfireRecipes()
	{
		CampfireRecipes.addRecipe(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.15f);
		CampfireRecipes.addRecipe(Blocks.log2, new ItemStack(Items.coal, 1, 1), 0.15f);
		CampfireRecipes.addRecipe(new ItemStack(Blocks.sponge, 1, 1), new ItemStack(Blocks.sponge, 1, 0), 0.1f);

		CampfireRecipes.addRecipe(Items.beef, new ItemStack(RegisterItems.charredMeat), 0.1f);
		CampfireRecipes.addRecipe(Items.porkchop, new ItemStack(RegisterItems.charredMeat), 0.1f);
		CampfireRecipes.addRecipe(Items.chicken, new ItemStack(RegisterItems.charredMeat), 0.1f);
		CampfireRecipes.addRecipe(new ItemStack(Items.fish, 1, 0), new ItemStack(RegisterItems.charredMeat), 0.1f);
		CampfireRecipes.addRecipe(new ItemStack(Items.fish, 1, 1), new ItemStack(RegisterItems.charredMeat), 0.1f);

		if (BBConfig.canCampfireDoAllKilnStuff)
		{
			CampfireRecipes.addRecipe(Items.clay_ball, new ItemStack(Items.brick), 0.35f);
			CampfireRecipes.addRecipe(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.1f);
			CampfireRecipes.addRecipe(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.1f);
			CampfireRecipes.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0),
				new ItemStack(Blocks.stonebrick, 1, 2), 0.1f);
			CampfireRecipes.addRecipe(Blocks.cactus, new ItemStack(Items.dye, 1, 2), 0.1f);
			CampfireRecipes.addRecipe(Blocks.sand, new ItemStack(Blocks.glass), 0.1f);
			CampfireRecipes.addRecipe(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1f);
		}

		CampfirePanRecipes.addRecipe(Items.beef, new ItemStack(Items.cooked_beef), 0.1f);
		CampfirePanRecipes.addRecipe(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.1f);
		CampfirePanRecipes.addRecipe(Items.chicken, new ItemStack(Items.cooked_chicken), 0.1f);
		CampfirePanRecipes.addRecipe(new ItemStack(Items.fish, 1, 0), new ItemStack(Items.cooked_fished, 1, 0), 0.1f);
		CampfirePanRecipes.addRecipe(new ItemStack(Items.fish, 1, 1), new ItemStack(Items.cooked_fished, 1, 1), 0.1f);
	}


	public static void addShapedRecipes()
	{
			if (BBConfig.moduleCampfire)
		{
			// Campfire
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegisterBlocks.campfire),
				"//", "ss",
				'/', "stickWood",
				's', "itemString"));

			// Fire Bow
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegisterItems.fireBow),
				"//", "/s",
				'/', "stickWood",
				's', "itemString"));
		}
	}
}
