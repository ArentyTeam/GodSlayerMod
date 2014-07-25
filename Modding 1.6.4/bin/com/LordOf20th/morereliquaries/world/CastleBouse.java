/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.minecraft.src;
import java.util.Random;

public class ConstruToJava extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			Block.grass.blockID,
			Block.dirt.blockID
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 0){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public ConstruToJava() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 5, j, k) || !LocationIsValidSpawn(world, i + 5, j, k + 6) || !LocationIsValidSpawn(world, i, j, k + 6))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 0, -56);
		world.setBlock(i + 0, j + 0, k + 1, -56);
		world.setBlock(i + 0, j + 0, k + 2, -56);
		world.setBlock(i + 0, j + 0, k + 3, -56);
		world.setBlock(i + 0, j + 0, k + 4, -56);
		world.setBlock(i + 0, j + 0, k + 5, -56);
		world.setBlock(i + 0, j + 0, k + 6, -56);
		world.setBlock(i + 0, j + 1, k + 1, -56);
		world.setBlock(i + 0, j + 1, k + 3, -56);
		world.setBlock(i + 0, j + 1, k + 5, -56);
		world.setBlock(i + 1, j + 0, k + 0, -56);
		world.setBlock(i + 1, j + 0, k + 6, -56);
		world.setBlock(i + 1, j + 1, k + 0, -56);
		world.setBlock(i + 1, j + 1, k + 6, -56);
		world.setBlock(i + 2, j + 0, k + 0, -56);
		world.setBlock(i + 2, j + 0, k + 6, -56);
		world.setBlock(i + 3, j + 0, k + 0, -56);
		world.setBlock(i + 3, j + 0, k + 6, -56);
		world.setBlock(i + 3, j + 1, k + 0, -56);
		world.setBlock(i + 3, j + 1, k + 6, -56);
		world.setBlock(i + 4, j + 0, k + 0, -56);
		world.setBlock(i + 4, j + 0, k + 6, -56);
		world.setBlock(i + 5, j + 0, k + 0, -56);
		world.setBlock(i + 5, j + 0, k + 1, -56);
		world.setBlock(i + 5, j + 0, k + 2, -56);
		world.setBlock(i + 5, j + 0, k + 3, -56);
		world.setBlock(i + 5, j + 0, k + 4, -56);
		world.setBlock(i + 5, j + 0, k + 5, -56);
		world.setBlock(i + 5, j + 0, k + 6, -56);
		world.setBlock(i + 5, j + 1, k + 0, -56);
		world.setBlock(i + 5, j + 1, k + 2, -56);
		world.setBlock(i + 5, j + 1, k + 4, -56);
		world.setBlock(i + 5, j + 1, k + 6, -56);

		return true;
	}
}