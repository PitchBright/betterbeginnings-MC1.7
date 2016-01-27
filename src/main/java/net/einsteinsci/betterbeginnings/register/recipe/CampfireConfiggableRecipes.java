package net.einsteinsci.betterbeginnings.register.recipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;


public class CampfireConfiggableRecipes {

	private static final CampfireConfiggableRecipes SMELTING_BASE = new CampfireConfiggableRecipes();

	private static Map smeltingList = new HashMap();
	private static Map experienceList = new HashMap();

	public static CampfireConfiggableRecipes smelting() {
		return SMELTING_BASE;
	}

	public static Item getItemCrossMOD(String name) {
		String modid = name.split(":")[0];
		String itemName = name.split(":")[1];
		try {

			Item item = GameRegistry.findItem(modid, itemName);
			return item;
		} catch (Exception ex) {
			return Items.coal;
		}

	}

	public static void init() {
		// SOME TEMPORARY RECIPES
		// this.func_151393_a(Blocks.iron_ore, new ItemStack(Items.iron_ingot),
		// 0.7F);
		// this.func_151393_a(Blocks.gold_ore, new ItemStack(Items.gold_ingot),
		// 1.0F);
		// this.func_151393_a(Blocks.sand, new ItemStack(Blocks.glass), 0.35F);
		// this.func_151393_a(Blocks.cobblestone, new ItemStack(Blocks.stone),
		// 0.35F);
		// this.func_151396_a(Items.clay_ball, new ItemStack(Items.brick),
		// 0.3F);
		// this.func_151393_a(Blocks.log, new ItemStack(Items.coal, 1), 0.355F);
		// this.func_151393_a(Blocks.coal_ore, new ItemStack(Items.coal),
		// 0.35F);

		// func_151396_a(new ItemStack(MItems.itemCobblePile, 1, 8), new
		// ItemStack(MItems.itemQuicklime), 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("modid:unlocname"), 1,
		// 8), new ItemStack(MItems.itemQuicklime), 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("Aquaculture:item.loot"),
		// 1, 3), new ItemStack(getItemCrossMOD("Aquaculture:item.loot"), 1, 4),
		// 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("Aquaculture:item.loot"),
		// 1, 2), new ItemStack(getItemCrossMOD("Aquaculture:item.loot"), 1, 5),
		// 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("Aquaculture:item.loot"),
		// 1, 7), new ItemStack(getItemCrossMOD("Aquaculture:item.loot"), 1, 8),
		// 0.35F);
		// func_151396_a(new ItemStack(Items.potionitem, 1, 0), new
		// ItemStack(getItemCrossMOD("thirstmod:fresh_water"), 1, 0), 0.35F);
		// func_151396_a(new ItemStack(Items.water_bucket, 1, 0), new
		// ItemStack(getItemCrossMOD("thirstmod:clean_bucket")), 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("MoCreatures:ratraw"), 1,
		// 0), new ItemStack(getItemCrossMOD("MoCreatures:ratcooked"), 1, 0),
		// 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("MoCreatures:crabraw"),
		// 1, 0), new ItemStack(getItemCrossMOD("MoCreatures:crabcooked"), 1,
		// 0), 0.35F);
		// func_151396_a(new
		// ItemStack(getItemCrossMOD("MoCreatures:ostrichraw"), 1, 0), new
		// ItemStack(getItemCrossMOD("MoCreatures:ostrichcooked"), 1, 0),
		// 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("MoCreatures:turkeyraw"),
		// 1, 0), new ItemStack(getItemCrossMOD("MoCreatures:turkeycooked"), 1,
		// 0), 0.35F);
		// func_151396_a(new ItemStack(getItemCrossMOD("MoCreatures:mocegg"), 1,
		// 0), new ItemStack(getItemCrossMOD("MoCreatures:omelet"), 1, 0),
		// 0.35F);
		// func_151396_a(new ItemStack(Items.chicken, 1, 0), new
		// ItemStack(Items.cooked_chicken, 1, 0), 0.35F);
		// func_151396_a(new ItemStack(Items.porkchop, 1, 0), new
		// ItemStack(Items.cooked_porkchop, 1, 0), 0.35F);
		// func_151396_a(new ItemStack(Items.potato, 1, 0), new
		// ItemStack(Items.baked_potato, 1, 0), 0.35F);
		// func_151396_a(new ItemStack(Items.fish, 1, 0), new
		// ItemStack(Items.cooked_fished, 1, 0), 0.35F);
		// func_151396_a(new ItemStack(Items.fish, 1, 1), new
		// ItemStack(Items.cooked_fished, 1, 1), 0.35F);
		// func_151396_a(new ItemStack(Items.beef, 1, 0), new
		// ItemStack(Items.cooked_beef, 1, 0), 0.35F);
		// func_151396_a(new ItemStack(Item.getItemFromBlock(Blocks.cactus), 1,
		// 0), new ItemStack(Items.dye, 1, 2), 0.35F);

	}

	public static void func_151393_a(ItemStack stack, ItemStack stack2, float f) {
		func_151396_a(stack, stack2, f);
	}

	// -152111996428307187

	// NEEDS TO SUPPORT ITEMSTACKS
	public static void func_151396_a(ItemStack stack, ItemStack stack2, float f) {
		func_151394_a(stack, stack2, f);
	}

	//
	public static void func_151394_a(ItemStack p_151394_1_,
			ItemStack p_151394_2_, float p_151394_3_) {
		smeltingList.put(p_151394_1_, p_151394_2_);
		experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
	}

	public static ItemStack getSmeltingResult(ItemStack itemstack) {
		Iterator iterator = smeltingList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBeSmelted(itemstack, (ItemStack) entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private static boolean canBeSmelted(ItemStack itemstack,
			ItemStack itemstack2) {
		return itemstack2.getItem() == itemstack.getItem()
				&& (itemstack2.getItemDamage() == 32767 || itemstack2
						.getItemDamage() == itemstack.getItemDamage());
	}

	public static float giveExperience(ItemStack itemstack) {
		Iterator iterator = experienceList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return 0.0f;
			}

			entry = (Entry) iterator.next();
		} while (!canBeSmelted(itemstack, (ItemStack) entry.getKey()));

		if (itemstack.getItem().getSmeltingExperience(itemstack) != -1) {
			return itemstack.getItem().getSmeltingExperience(itemstack);
		}

		return ((Float) entry.getValue()).floatValue();
	}
	
	
}
