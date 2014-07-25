package com.LordOf20th.morereliquaries.blocks;

import com.LordOf20th.morereliquaries.common.MoreReliquaries;
import com.sun.org.apache.bcel.internal.generic.LOR;

import scala.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreDivine extends Block
{
	public BlockOreDivine(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
	return MoreReliquaries.oreDivine.blockID;
	}
	public int quantityDropped(Random random)
	{
	return 1;
	}
}
