package ivaniesta14.iccbeta.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon
import cpw.mods.fml.relaucher.Side;
import cpw.mods.fml.relaucher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class B extends Item{
	private int bc=T.white, oc=T.white;
	private IIcon back, overlay; 
	public B(int b, int o){
		super();
		bc=b; 
		oc=o;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack i,int p){
		if(p==0)
			return bc;
		return oc; 
	}
	@SideOnly(Side.CLIENT) 
	@Override
	public IIcon getIcon(ItemStack i, int p){
		if(p==0)
			return back; 
		return overlay; 
	}
	@SideOnly(Side.CLIENT) 
	@Override 
	public boolean requiresMultipleRenderPasses(){
		return true; 
	}
	@SideOnly(Side.CLIENT) 
	@Override 
	public void registerIcons(IIconRegisterer ir){
			back=ir.registerIcon("iccbeta:batt");
		overlay=ir.registerIcon("iccbeta:batt_over");
	}
}
