package net.einsteinsci.betterbeginnings.register;

import net.einsteinsci.betterbeginnings.register.recipe.CampfireRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

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


//		CampfirePanRecipes.addRecipe(Items.beef, new ItemStack(Items.cooked_beef), 0.1f);
//		CampfirePanRecipes.addRecipe(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.1f);
//		CampfirePanRecipes.addRecipe(Items.chicken, new ItemStack(Items.cooked_chicken), 0.1f);
//		CampfirePanRecipes.addRecipe(new ItemStack(Items.fish, 1, 0), new ItemStack(Items.cooked_fished, 1, 0), 0.1f);
//		CampfirePanRecipes.addRecipe(new ItemStack(Items.fish, 1, 1), new ItemStack(Items.cooked_fished, 1, 1), 0.1f);
	}


//	public static void addShapedRecipes()
//	{
//			if (BBConfig.moduleCampfire)
//		{
//			// Campfire
//			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegisterBlocks.campfire),
//				"//", "ss",
//				'/', "stickWood",
//				's', "itemString"));
//
//			// Fire Bow
//			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegisterItems.fireBow),
//				"//", "/s",
//				'/', "stickWood",
//				's', "itemString"));
//		}
//	}
}
