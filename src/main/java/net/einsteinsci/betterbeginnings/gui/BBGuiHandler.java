package net.einsteinsci.betterbeginnings.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.einsteinsci.betterbeginnings.inventory.*;
import net.einsteinsci.betterbeginnings.tileentity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Some issues with this. Please note the server doesn't register items or blocks. At all.
 */
public class BBGuiHandler implements IGuiHandler
{
	public static final int CAMPFIRE_ID = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		

		if (ID == CAMPFIRE_ID)
		{
			TileEntityCampfire campfire = (TileEntityCampfire)world.getTileEntity(x, y, z);
			return new ContainerCampfire(player.inventory, campfire);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
	
		if (ID == CAMPFIRE_ID)
		{
			TileEntityCampfire campfire = (TileEntityCampfire)world.getTileEntity(x, y, z);
			return new GuiCampfire(player.inventory, campfire);
		}

		return null;
	}
}
