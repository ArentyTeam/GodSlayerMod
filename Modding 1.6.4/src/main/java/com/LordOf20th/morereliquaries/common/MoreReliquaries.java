package com.LordOf20th.morereliquaries.common;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import com.LordOf20th.morereliquaries.biomes.BiomeDivineOverworld;
import com.LordOf20th.morereliquaries.blocks.BlockDivineDirt;
import com.LordOf20th.morereliquaries.blocks.BlockDivineGrass;
import com.LordOf20th.morereliquaries.blocks.BlockOreDivine;
import com.LordOf20th.morereliquaries.proxy.MRCommonProxy;
import com.LordOf20th.morereliquaries.world.CastleBouse;
import com.LordOf20th.morereliquaries.world.WorldCastleBouse;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "morereliquaries", name = "More Reliquaries", version = "0.1.0", acceptedMinecraftVersions = "[1.6.4,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class MoreReliquaries
{
	@SidedProxy(clientSide = "com.LordOf20th.morereliquaries.proxy.MRClientProxy", serverSide = "com.LordOf20th.morereliquaries.proxy.MRCommonProxy")
	public static MRCommonProxy proxy;

	@Instance("MoreReliquaries")
	public static MoreReliquaries instance;
	public static Block oreDivine;
	public static Block divineLog;
	public static Block divineLeaves;
	public static Block divineSapling;
	public static Block divineGrass;
	public static Block divineDirt;
	public static BiomeGenBase divineOverBiome;
	public static int divineBiomeOverID;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		// Configuration
		// On définit la config
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		// On la charge
		config.load();

		// blocks conf
		int oreDivineID = config.getBlock("oreDivineBlock", 2500).getInt();
		int divineDirtID = config.getBlock("divineDirt", 204).getInt();
		int divineGrassID = config.getBlock("divineGrass", 205).getInt();
		// Biomes Configuration
		 divineBiomeOverID = config.get("Biomes", "divineBiomeOverworld", 8).getInt();
	
		// On la sauvegarde
		config.save();
		// Blocks
		oreDivine = new BlockOreDivine(oreDivineID).setTextureName("morereliquaries:ore_divine").setLightValue(0.3F).setResistance(10.0F).setHardness(5.0F).setUnlocalizedName("Divine Ore");
		divineDirt = new BlockDivineDirt(divineDirtID).setTextureName("morereliquaries:divine_dirt").setUnlocalizedName("Divine Dirt").setHardness(0.5F).setStepSound(Block.soundGravelFootstep);
		divineGrass = new BlockDivineGrass(divineGrassID).setTextureName("morereliquaries:divine_grass").setUnlocalizedName("Divine Grass").setHardness(0.6F).setStepSound(Block.soundGravelFootstep);

		// Items

		// Achievements

	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		// Biomes
		divineOverBiome = new BiomeDivineOverworld(divineBiomeOverID).setBiomeName("Divine Biome").setMinMaxHeight(0.3F, 0.5F);
		// Registry
		GameRegistry.registerBlock(oreDivine, "Divine Ore");
		LanguageRegistry.addName(oreDivine, "Divine Ore");
		
		GameRegistry.registerBlock(divineGrass, "Divine Grass");
		LanguageRegistry.addName(divineGrass, "Divine Grass");

		GameRegistry.registerBlock(divineDirt, "Divine Dirt");
		LanguageRegistry.addName(divineDirt, "Divine Dirt");

		GameRegistry.registerWorldGenerator(new WorldCastleBouse());
		
		WorldType.DEFAULT.addNewBiome(divineOverBiome);
		GameRegistry.addBiome(divineOverBiome);

		// Mobs

		// Render
		proxy.registerRender();
		// NetWork

		// Recipe

	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		// Intégration avec les autres mods
	}
}
