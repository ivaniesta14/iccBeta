package ivaniesta14.iccbeta.items;

import cpw.mods.fml.relaucher.Side;
import cpw.mods.fml.relaucher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class T extends Item{
	public static final int red=0xFF0000, yellow=0xFFFF00, green=0x00FF00,
	public static final int cyan=0x00FFFF, blue=0x0000FF, magenta=0xFF00FF;
	public static final int white=0xFFFFFF, black=0x000000, gray=0x7F7F7F;
	private int c=white;
	public T(){}
	public T(int o){
		c=o;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack i,int r){
		return c;
	}
	public static ItemStack s(Item i){
		return s(i,0);
	}
	public static ItemStack s(Item i,int m){
		return new ItemStack(i,1,m);
	}
	public static ItemStack s(Block b){
		return s(b,0);
	}
	public static ItemStack s(Block b,int m){
		return new ItemStack(b,1,m);
	}
}
