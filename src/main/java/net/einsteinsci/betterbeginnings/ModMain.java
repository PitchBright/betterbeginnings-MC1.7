package net.einsteinsci.betterbeginnings;

import net.einsteinsci.betterbeginnings.config.Config;
import net.einsteinsci.betterbeginnings.event.BBEventHandler;
import net.einsteinsci.betterbeginnings.network.PacketCampfireState;
import net.einsteinsci.betterbeginnings.network.ServerProxy;
import net.einsteinsci.betterbeginnings.register.RegisterBlocks;
import net.einsteinsci.betterbeginnings.register.RegisterItems;
import net.einsteinsci.betterbeginnings.register.RegisterRecipes;
import net.einsteinsci.betterbeginnings.register.RegisterTileEntities;
import net.einsteinsci.betterbeginnings.register.recipe.CampfireConfiggableRecipes;
import net.einsteinsci.betterbeginnings.util.LogUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ModMain.MODID, version = ModMain.VERSION, name = ModMain.NAME,
     guiFactory = "net.einsteinsci.betterbeginnings.config.BBConfigGuiFactory")
public class ModMain
{
	public static final String MODID = "betterbeginnings";
	public static final String VERSION = "0.9.5-Khufu";
	public static final String NAME = "Better Beginnings";
	public static final CreativeTabs tabBetterBeginnings = new CreativeTabs("tabBetterBeginnings")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return RegisterItems.fireBow;
		}
	};

	@Instance(ModMain.MODID)
	public static ModMain modInstance;
	public static Configuration configFile;
	public static SimpleNetworkWrapper network;
	@SidedProxy(clientSide = "net.einsteinsci.betterbeginnings.network.ClientProxy",
	            serverSide = "net.einsteinsci.betterbeginnings.network.ServerProxy")
	public static ServerProxy proxy;
	public BBEventHandler eventHandler = new BBEventHandler();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		LogUtil.log("Starting pre-initialization...");

		Config.init(e.getSuggestedConfigurationFile());
//		configFile = new Configuration(e.getSuggestedConfigurationFile());
//		configFile.load();
//		BBConfig.initialize();
//		BBConfig.syncConfig(configFile);

		proxy.registerNetworkStuff();
		proxy.registerRenderThings();


		FMLCommonHandler.instance().bus().register(eventHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);

		network = NetworkRegistry.INSTANCE.newSimpleChannel("bbchannel");

		network.registerMessage(PacketCampfireState.PacketHandler.class,
			PacketCampfireState.class, 1, Side.CLIENT);

		RegisterItems.register();
		RegisterBlocks.register();
		RegisterTileEntities.register();
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
//		RegisterRecipes.addCampfireConfiggableRecipes();
		CampfireConfiggableRecipes.init();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{

		Config.syncConfig();

		CampfireConfiggableRecipes.init();
//		BBConfig.fillAlwaysBreakable();
//		BBConfig.fillAlsoPickaxes();
//		BBConfig.fillAlsoAxes();


		LogUtil.log("Finished post-initialization.");
	}
}
