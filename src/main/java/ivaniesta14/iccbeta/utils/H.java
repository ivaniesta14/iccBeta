package ivaniesta14.iccbeta.utils;

import ivaniesta14.iccbeta.items.T;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class H implements IItemColor{
	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex){
		if(!(stack.getItem() instanceof T))
			return T.white;
		return ((T)(stack.getItem())).c;
	}
}