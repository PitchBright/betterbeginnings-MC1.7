package net.einsteinsci.betterbeginnings.register;

import net.einsteinsci.betterbeginnings.items.ItemCharredMeat;
import net.einsteinsci.betterbeginnings.items.ItemFireBow;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class RegisterItems
{
	public static final Item charredMeat = new ItemCharredMeat();
	public static final Item fireBow = new ItemFireBow();

	public static void register()
	{
		RegisterHelper.registerItem(charredMeat);
		RegisterHelper.registerItem(fireBow);

	}


}
