package com.LordOf20th.morereliquaries.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldCastleBouse implements IWorldGenerator
{

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		// case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateSurface(World world, Random rand, int l, int j)
	{

		for(int i = 0; i < 40; i++)
		{
			int Xcoord = l + rand.nextInt(16);
			int Zcoord = j + rand.nextInt(16);
			int Ycoord = rand.nextInt(16);

			for(int k = 0; k < 1; k++)
			{
				int RandPosX = l + rand.nextInt(16);
				int RandPosY = rand.nextInt(128);
				int RandPosZ = j + rand.nextInt(16);
				(new CastleBouse()).generate(world, rand, RandPosX, RandPosY, RandPosZ);

			}
		}
	}
}