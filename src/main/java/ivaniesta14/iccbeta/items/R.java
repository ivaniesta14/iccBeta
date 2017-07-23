package ivaniesta14.iccbeta.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class R{
	public static final CreativeTabs iccTab=new CreativeTabs("iccbeta"){
		@Override
		public Item getTabIconItem(){
			return Items.emerald;
		}
	};
    /**Registers an item with custom name <i>n</i>.*/
	public static void r(Item i,String n) throws Exception{
		if(i!=null){
			O.o("Registered an item with name "+n);
			GameRegistry.registerItem(i, n);
		}
		else throw new Exception("r(IS): i is null!");
	}
	/**Calls {@link #r(Item, String)} with <i>i</i>'s unlocalized name as <i>n</i>.*/
	public static void r(Item i) throws Exception{
		r(i,i.getUnlocalizedName());
	}
	/**Calls {@link #r(Item)}, sets creative tab to iccTab and texture name.<br>
	 * <i>b</i> is unused.*/
	public static void r(Item i,boolean b) throws Exception{
		r(i.setCreativeTab(iccTab));
		i.setTextureName("icc:"+i.getUnlocalizedName().substring(5));
	}
	/**Sets creative tab to iccTab, unlocalized name as <i>n</i>, then
	 * calls {@link #r(Item)}.<br>
	 * Sets custom texture name based on <i>b</i>.*/
	public static void r(Item i,String n,boolean b) throws Exception{
		r(i.setCreativeTab(iccTab).setUnlocalizedName(n));
		if (b)
			i.setTextureName("icc:"+i.getUnlocalizedName().substring(5));
	}
	/**Sets max stack size <i>n</i> for Item <i>i</i>.*/
	public static Item s(Item i,int n){
		return i.setMaxStackSize(n);
	}
	/**Calls {@link #r(Item, String, boolean)} and sets max stack size <i>n</i>.*/
	public static void r(Item i,int n,String a,boolean b) throws Exception{
		r(s(i,n),a,b);
	}
	/**Calls {@link #r(Item, int, String, boolean)}.<br>
	 * Sets texture name if <i>c</i> is not empty or null.<br>
	 * Texture name is not set by inner r() call.*/
	public static void r(Item i,int n,String a,boolean b,String c)
	throws Exception{
		if(c!=""&&c!=null){
			r(i,n,a,false);
			i.setTextureName("icc:"+c);
		}
		else throw new Exception("r(IiSbS): c is invalid!");
	}
	/**Calls {@link #r(Item, int, String, boolean, String)}
	 * if <i>d</i> is false.<br>
	 * Calls {@link #r(Item, int, String, boolean)} if <i>d</i> is true,
	 * and sets texture name <i>c</i> if it is nonempty and nonnull.<br>
	 * Texture name is set by inner calls according to <i>c</i> and <i>d</i>.
	 * */
	public static void r(Item i,int n,String a,boolean b,String c,boolean d)
	throws Exception{
		if(d&&(c!=""||c!=null)){
			r(i,n,a,false);
			i.setTextureName(c);
		}
		else if (d){
			throw new Exception("r(IiSbSb): \"d was set but \"c wasn't!");
		}
		else{
			r(i,n,a,b,c);
		}
	}
	/**Registers a recipe for ItemStack <i>o</i> with materials <i>m</i>.*/
	public static void c(ItemStack o,Object ... m){
		GameRegistry.addRecipe(o, m);
	}
	/**Registers a <i>shapeless</i> recipe for <i>o</i> with materials
	 * <i>m</i>.*/
	public static void s(ItemStack o,Object ... m){
		GameRegistry.addShapelessRecipe(o, m);
	}
	/**Calls {@link #c(ItemStack, Object...)}
	 * with "new ItemStack(<i>o</i>)" as <i>o</i>.*/
	public static void c(Item o,Object ... m){
		c(new ItemStack(o),m);
	}
	/**Calls {@link #s(ItemStack, Object...)}
	 * with new ItemStack(<i>o</i>) as <i>o</i>.*/
	public static void s(Item o,Object ... m){
		s(new ItemStack(o),m);
	}
	/**Fetches Item in the registry for mod <i>m</i> and name <i>n</i>
	 * @deprecated All direct calls to this method ought to be replaced by
	 * corresponding jar file/class lookup.
	 * */
	@Deprecated
	public static Item r(String m,String n){
		return GameRegistry.findItem(m,n);
	}
    /**Fetches an item or block, then returns its ItemStack
     * @deprecated All direct calls to this method ought to be replaced by
     * corresponding jar file/class lookup.
     * */
    @Deprecated
    public static ItemStack s(String m,String n){
        return T.s(r(m,n));
    }
}

}

