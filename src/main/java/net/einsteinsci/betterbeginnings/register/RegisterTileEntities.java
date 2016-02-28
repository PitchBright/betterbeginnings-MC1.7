package net.einsteinsci.betterbeginnings.register;

import cpw.mods.fml.common.registry.GameRegistry;
import net.einsteinsci.betterbeginnings.ModMain;
import net.einsteinsci.betterbeginnings.tileentity.*;

public class RegisterTileEntities
{
	public static void register()
	{
		GameRegistry.registerTileEntity(TileEntityCampfire.class, ModMain.MODID + ":TileEntityCampfire");
	}
}
