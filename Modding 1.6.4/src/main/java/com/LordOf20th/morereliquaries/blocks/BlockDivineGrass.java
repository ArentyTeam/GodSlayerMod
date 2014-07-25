package com.LordOf20th.morereliquaries.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

import com.LordOf20th.morereliquaries.common.MoreReliquaries;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDivineGrass extends Block{
	public BlockDivineGrass(int id)//Souvenez vous on a donné 2 paramètres donc on les récupère
	{
		super(id, Material.grass);//Puis on les renvoi à la classe mère (la classe Block) car elle demande un ID et un Material
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
    @SideOnly(Side.CLIENT)
    private Icon icon_top;
    private Icon icon_side;
    private Icon icon_bot;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.icon_top = par1IconRegister.registerIcon(this.getTextureName() + "_top");
    	this.icon_side = par1IconRegister.registerIcon(this.getTextureName() + "_side");
    	this.icon_bot = par1IconRegister.registerIcon(this.getTextureName() + "_bot");
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        if (par1 == 0)
        {
        	return this.icon_bot;
        }
        else if (par1 == 1)
        {
        	return this.icon_top;
        }
        else
        {
        	return this.icon_side;
        }    
     }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MoreReliquaries.divineDirt.idDropped(0, par2Random, par3);
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.setBlock(par2, par3, par4, MoreReliquaries.divineDirt.blockID);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    int l1 = par1World.getBlockId(i1, j1 + 1, k1);

                    if (par1World.getBlockId(i1, j1, k1) == MoreReliquaries.divineDirt.blockID && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, MoreReliquaries.divineGrass.blockID);
                    }
                }
            }
        }
    }

}
