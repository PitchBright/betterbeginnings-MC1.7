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
