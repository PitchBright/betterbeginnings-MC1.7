package net.einsteinsci.betterbeginnings.util;

import net.einsteinsci.betterbeginnings.ModMain;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class LogUtil
{


	public static void log(Level level, String text)
	{
		FMLLog.log(ModMain.NAME, level, text);
	}

	public static void log(String text)
	{
		log(Level.INFO, text);
	}
}
