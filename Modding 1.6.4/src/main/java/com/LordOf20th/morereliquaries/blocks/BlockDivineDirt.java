package com.LordOf20th.morereliquaries.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDivineDirt extends Block
{

	public BlockDivineDirt(int id)
	{
		super(id, Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
}
