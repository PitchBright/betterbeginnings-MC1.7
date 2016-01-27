package net.einsteinsci.betterbeginnings.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import cpw.mods.fml.common.Optional;
import net.einsteinsci.betterbeginnings.ModMain;
import net.einsteinsci.betterbeginnings.register.RegisterBlocks;
import net.minecraft.item.ItemStack;

@Optional.Interface(iface = "codechicken.nei.api.IConfigureNEI", modid = "NotEnoughItems")
public class NEIConfig implements IConfigureNEI
{
	@Override
	public void loadConfig()
	{
	
		NEICampfireRecipeHandler campfireRecipeHandler = new NEICampfireRecipeHandler();
		API.registerRecipeHandler(campfireRecipeHandler);
		API.registerUsageHandler(campfireRecipeHandler);

	}

	@Override
	public String getName()
	{
		return ModMain.NAME;
	}

	@Override
	public String getVersion()
	{
		return ModMain.VERSION;
	}
}
