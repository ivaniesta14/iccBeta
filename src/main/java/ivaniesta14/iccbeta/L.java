package ivaniesta14.iccbeta;

import ivaniesta14.iccbeta.blocks.B;
import ivaniesta14.iccbeta.items.S;
import ivaniesta14.iccbeta.items.T;
import ivaniesta14.iccbeta.utils.H;
import ivaniesta14.iccbeta.utils.P;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class L {
	public static S copper,silver,iron,gold;
	public static S[] s={copper,silver,iron,gold};
	public static B I=new B(){@Override public int getRecipeInputSize(){return 1;}};
	public static B[] b={I};
	public static void h(){
		copper=new S("Copper",0xff6400);
		silver=new S("Silver",0xdcdcff);
		iron=new S("Iron",0xc8c8c8);
		gold=new S("Gold",0xffe650);
		B.recipes.addElement(
				new P<>(new ItemStack(Items.APPLE),
						new ItemStack[]{new ItemStack(Items.ARROW)}));
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
	@SubscribeEvent public void registerBlocks(RegistryEvent.Register<Block> ev){
		for(B b0:b)
			ev.getRegistry().register(b0);
	}
	public static void c(String gr,ItemStack out,Object... in){
		GameRegistry.addShapedRecipe(new ResourceLocation(ICCBeta.modid,"r"),
				new ResourceLocation(ICCBeta.modid,gr),out,in);
	}
}
