package ivaniesta14.iccbeta;

import gregapi.data.MT;
import ivaniesta14.iccbeta.items.*;
import ivaniesta14.iccbeta.utils.H;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class L {
	public static S copper,silver,iron,gold;//TODO
	public static S[] s={copper,silver,iron,gold};
	public static void h(){
		copper=new S(MT.Cu);
		silver=new S(MT.Ag);
		iron=new S(MT.Fe);
		gold=new S(MT.Au);
	}
	public static void i(){
		for(S s0:s)
			for(T t:s0.allItems)
				Minecraft.getMinecraft().getItemColors().registerItemColorHandler(
						new H(),t);
	}
	public static void j(){}//TODO
	@SubscribeEvent public void registerItems(RegistryEvent.Register<Item> ev){
		for(S s0:s){
			for(T t:s0.allItems)
				ev.getRegistry().register(t);
		}
	}
	public static void c(String gr,ItemStack out,Object... in){
		GameRegistry.addShapedRecipe(new ResourceLocation(ICCBeta.modid,"r"),
				new ResourceLocation(ICCBeta.modid,gr),out,in);
	}
}
