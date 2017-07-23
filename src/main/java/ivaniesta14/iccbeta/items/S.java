package ivaniesta14.iccbeta.items

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class S {
	private static final boolean f=false,t=true;
	public int color;
	public String material;
	public T ingot,ingotDouble,ingotTriple,ingotQuad,ingotQuin;
	public T dust,dustSmall,dustTiny;
	public T gemMaster,gemHuge,gemBig,gem,gemSmall,gemTiny;
	public T leaf,nugget;
	
	public T[] ingots={ingot,ingotDouble,ingotTriple,ingotQuad,ingotQuin};
	public T[] dusts={dustTiny,dustSmall,dust};
	public T[] gems={gemTiny,gemSmall,gem,gemBig,gemHuge,gemMaster};
	
	public S(int c,String m){
		color=c;
		material=m;
		for(T ing:ingots){
			ing=new T(color);
		}
		for(T dst:dusts){
			dst=new T(color);
		}
		for(T gm:gems){
			gm=new T(color);
		}
		leaf=new T(color);
		nugget=new T(color);
	}
	public S r() throws Exception{
		for(int i=0;i<ingots.length;i++){
			R.r(ingots[i],ingots.length-i,
				"ingot"+material+String.valueOf(i),f,
				"ingot"+String.valueOf(i));
		}
		for(int i=0;i<dusts.length;i++){
			R.r(dusts[i],9,
				"dust"+material+String.valueOf(i),f,
				"dust"+String.valueOf(i));
		}
		for(int i=0;i<gems.length;i++){
			R.r(gems[i],gems.length-i,
				"gem"+material+String.valueOf(i),f,
				"gem"+String.valueOf(i));
		}
		R.r(leaf,16,"leaf"+material,f,"leaf");
		R.r(nugget,9,"nugget"+material,f,"nugget");
		return this;
	}
}
