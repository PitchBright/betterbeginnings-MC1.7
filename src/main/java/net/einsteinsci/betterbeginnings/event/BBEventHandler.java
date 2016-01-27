package net.einsteinsci.betterbeginnings.event;

import java.util.ArrayList;
import java.util.List;

import net.einsteinsci.betterbeginnings.ModMain;
import net.einsteinsci.betterbeginnings.config.BBConfig;
import net.einsteinsci.betterbeginnings.register.RegisterBlocks;
import net.einsteinsci.betterbeginnings.register.RegisterItems;
import net.einsteinsci.betterbeginnings.tileentity.TileEntityCampfire;
import net.einsteinsci.betterbeginnings.util.ChatUtil;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class BBEventHandler
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e)
	{
		if (BBConfig.greetUser)
		{
			ChatUtil.sendChatToPlayer(e.player, ChatUtil.LIME + "BetterBeginnings " + ModMain.VERSION +
				" loaded successfully.");
		}
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e)
	{
		if (e.modID.equals(ModMain.MODID))
		{
			BBConfig.syncConfig(ModMain.configFile);
		}
	}
	
	@SubscribeEvent
	public void onItemTooltip(ItemTooltipEvent e)
	{
		Item item = e.itemStack.getItem();
		
		if (item == RegisterItems.charredMeat)
		{
			e.toolTip.add("Not to be confused with charcoal");
		}


		if (item == RegisterItems.pan)
		{
			e.toolTip.add(ChatUtil.BLUE + "Fry stuff over a campfire!");
		}

		if (item == RegisterItems.fireBow)
		{
			e.toolTip.add(ChatUtil.ITALIC + "Not that kind of bow.");
		}

		if (item == Items.sugar)
		{
			e.toolTip.add(ChatUtil.ITALIC + "Yes please!");
		}

		if (item == Item.getItemFromBlock(RegisterBlocks.campfire) && !BBConfig.moduleCampfire)
		{
			e.toolTip.add(ChatUtil.RED + "Module disabled in config.");
		}



		Block block = Block.getBlockFromItem(item);
		if (block != null)
		{

		}

		if (isWIP(e.itemStack))
		{
			e.toolTip.add(ChatUtil.RED + "WIP. May not be fully functional.");
		}
	}

	public boolean isWIP(ItemStack stack)
	{
		List<ItemStack> wip = new ArrayList<>();

		// add WIP items here

		for (ItemStack test : wip)
		{
			if (stack.getItem() == test.getItem())
			{
				return true;
			}
		}

		return false;
	}


	@SubscribeEvent
	public void onRightClick(PlayerInteractEvent e)
	{
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)
		{
			if (e.entityPlayer.getHeldItem() != null)
			{
				ItemStack stack = e.entityPlayer.getHeldItem();
				Item item = stack.getItem();

				if (item == Items.flint_and_steel || item == RegisterItems.fireBow)
				{
					Block b = e.world.getBlock(e.x, e.y, e.z);

					if (b == RegisterBlocks.campfire || b == RegisterBlocks.campfireLit)
					{
						TileEntityCampfire campfire = (TileEntityCampfire)e.world.getTileEntity(e.x, e.y, e.z);

						campfire.lightFuel(); // Light it.
						//e.entityPlayer.getHeldItem().damageItem(1, e.entityPlayer);
					}
				}
			}
		}
	}

	
//	@SubscribeEvent
//	public void onEntityLivingDrops(LivingDropsEvent e)
//	{
//		Random rand = e.entity.worldObj.rand;
//
//		
//
//		if (BBConfig.flamingAnimalsDropCharredMeat)
//		{
//			// Flaming mobs drop charred meat instead of cooked meats
//			if (e.entityLiving instanceof EntityCow || e.entityLiving instanceof EntityPig ||
//					e.entityLiving instanceof EntityChicken)
//			{
//				int charredDrops = 0;
//
//				Iterator iterator = e.drops.iterator();
//				while (iterator.hasNext())
//				{
//					EntityItem entityItem = (EntityItem)iterator.next();
//					Item item = entityItem.getEntityItem().getItem();
//					if (item == Items.cooked_beef || item == Items.cooked_porkchop || item == Items.cooked_chicken)
//					{
//						iterator.remove();
//						charredDrops += entityItem.getEntityItem().stackSize;
//					}
//				}
//
//				e.entityLiving.dropItem(RegisterItems.charredMeat, charredDrops);
//			}
//		}
//	}
}
