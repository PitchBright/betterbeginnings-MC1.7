package net.einsteinsci.betterbeginnings.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MUtils {

	public static boolean isInt(String str) {
		try {
			int f = Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static boolean isFloat(String str) {
		try {
			float f = Float.parseFloat(str);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static boolean isDouble(String str) {
		try {
			double f = Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	

	public static boolean hasItemReg(String name) {
		return Item.itemRegistry.containsKey(name);
	}

	public static boolean hasBlockReg(String name) {
		return Block.blockRegistry.containsKey(name);
	}
	
	public static boolean hasReg(String name) {
		return (hasBlockReg(name) || hasItemReg(name));
	}
	
	
}
