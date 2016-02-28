package net.einsteinsci.betterbeginnings.config;



import java.io.BufferedReader;
import java.io.File;
import java.util.Hashtable;

import net.einsteinsci.betterbeginnings.register.recipe.CampfireConfiggableRecipes;
import net.einsteinsci.betterbeginnings.util.MUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

public class Config {

	private static Hashtable<String, String> CFGOBJ = new Hashtable();

	public static String NIL = "NULL";
	private static Configuration Config;

	private static final String CATEGORY_Campfire = "Campfire";


	private static BufferedReader m_in;

	private static File configDir;

	public static void init(File ConfigFile) {

		configDir = new File(ConfigFile.getParent());

		Config = new Configuration(ConfigFile);

		Config.load();

	}

	
	private static void analyzeWoodRecipe(String val) {
		String[] split;

		ItemStack in = null;
		ItemStack out = null;
		int inLength;
		int outLength;

		int inDam;
		int outDam;

		Item inItem;
		Item outItem;

		if (val.contains(";")) {
			split = val.split(";");

		} else {
			return;
		}

		if (split.length == 7) {
			if (MUtils.isInt(split[2]) && MUtils.isInt(split[5])) {
				inLength = Integer.parseInt(split[2]);
				outLength = Integer.parseInt(split[5]);

				if (!MUtils.hasReg(split[0]) && !MUtils.hasReg(split[3])) {
					return;
				}
				inItem = CampfireConfiggableRecipes.getItemCrossMOD(split[0]);
				outItem = CampfireConfiggableRecipes.getItemCrossMOD(split[3]);

				if (MUtils.isInt(split[1]) && MUtils.isInt(split[4])) {
					inDam = Integer.parseInt(split[1]);
					outDam = Integer.parseInt(split[4]);

					in = new ItemStack(inItem, inDam, inLength);
					out = new ItemStack(outItem, outDam, outLength);

					if (MUtils.isFloat(split[6])) {
						CampfireConfiggableRecipes.func_151396_a(in, out,
								Float.parseFloat(split[6]));
					}
				}
			}
		}

	}

	

	public static String getConfig(String name) {
		if (CFGOBJ.containsKey(name)) {

			return CFGOBJ.get(name);
		}

		return NIL;
	}

	private static String[] CampfireRecipes;

	public static void syncConfig() {
		CFGOBJ.clear();

	

		CampfireRecipes = Config.getStringList("Campfire Recipes", "recipes",
				new String[] { "minecraft:cake;1;0;minecraft:cake;1;0;0",
						"minecraft:stick;1;0;minecraft:cake;1;0;0" },
				"The Campfire recipes is a human readable form");

		for (int i = 0; i < CampfireRecipes.length; i++) {
			analyzeWoodRecipe(CampfireRecipes[i]);
		}

		// END Recipes


		if (Config.hasChanged())
			Config.save();
	}

}