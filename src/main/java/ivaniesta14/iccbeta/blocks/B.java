package ivaniesta14.iccbeta.blocks;

import java.util.Arrays;
import java.util.Vector;

import ivaniesta14.iccbeta.utils.P;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class B extends Block{
	/**
	 * Key is out, Value is in.
	 * */
	public static Vector<P<ItemStack,ItemStack[]>>recipes=
			new Vector<>();
	public B(){
		super(Material.WOOD);
		if(this.getRecipeInputSize()>9||this.getRecipeInputSize()<1)
			throw new IllegalArgumentException(
					"Cannot construct B with invalid recipe size!");
		this.setCreativeTab(CreativeTabs.MISC);
	}
	@Override public boolean
	onBlockActivated(
			World worldIn, BlockPos pos, IBlockState state,
			EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ){
		if(worldIn.isRemote){
			return true;
		}
		ItemStack[] temp=new ItemStack[this.getRecipeInputSize()];
		for(int i=0;i<getRecipeInputSize();i++){
			int j=(playerIn.inventory.currentItem+i)%9;
			if(playerIn.inventory.getStackInSlot(j)==null||
					playerIn.inventory.getStackInSlot(j).getCount()!=1){
				return false;//Empty slot: use item|place block.
			}
			temp[i]=playerIn.inventory.getStackInSlot(i);
		}
		for(P<ItemStack,ItemStack[]> i:recipes){
			if(i.rhs.length!=this.getRecipeInputSize())
				continue;
			if(unorderedMatch(i.rhs,temp)){
				for(int j=0;j<getRecipeInputSize();j++){
					playerIn.inventory.decrStackSize(
							(playerIn.inventory.currentItem+j)%9,1);
				}
				playerIn.inventory.setInventorySlotContents(
						playerIn.inventory.currentItem,i.lhs.copy());
				return true;//Correct recipe found: do nothing.
			}
		}
		return false;//No recipe found: use item|place block.
	}
	public abstract int getRecipeInputSize();
	/**
	 * <strong>NEITHER lhs NOR rhs CAN CONTAIN REPEATED ITEMS OR WITH DATA VALUES!!
	 * */
	public static boolean unorderedMatch(ItemStack[] lhs,ItemStack[] rhs){
		if(lhs.length!=rhs.length)
			return false;
		int matches=0;
		for(int i=0;i<rhs.length;i++){
			int t=Arrays.asList(lhs).indexOf(rhs[i]);
			if(t==-1)
				return false;
			matches++;
		}
		if(matches==lhs.length)
			return true;
		return false;
	}
}
