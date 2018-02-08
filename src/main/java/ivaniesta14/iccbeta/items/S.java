package ivaniesta14.iccbeta.items;

//import ivaniesta14.iccbeta.L;
//import net.minecraft.init.Items;
//import net.minecraft.item.Item;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//import tonius.simplyjetpacks.setup.ModItems;
//import vazkii.botania.api.BotaniaAPI;

public class S {
	public static final boolean f=false,t=true;
	public int color;
	public String material;
	public T ingot,ingotDouble,ingotTriple,ingotQuad,ingotQuin;
	public T dust,dustSmall,dustTiny;
	public T gemMaster,gemHuge,gemBig,gem,gemSmall,gemTiny;
	public T leaf,nugget,hammer,binder,mortar;
	public T plate,plateDouble,plateTriple,plateQuad,plateQuin,
					plateHex,plateHept,plateOcta,plateDense;
	
	public T[] ingots={ingot,ingotDouble,ingotTriple,ingotQuad,ingotQuin};
	public T[] dusts={dustTiny,dustSmall,dust};
	public T[] gems={gemTiny,gemSmall,gem,gemBig,gemHuge,gemMaster};
	public T[] plates={plate,plateDouble,plateTriple,plateQuad,plateQuin,
			plateHex,plateHept,plateOcta,plateDense};
	
	public final T[] allItems={ingot,ingotDouble,ingotTriple,ingotQuad,ingotQuin,
			dustTiny,dustSmall,dust,gemTiny,gemSmall,gem,gemBig,gemHuge,gemMaster,
			plate,plateDouble,plateTriple,plateQuad,plateQuin,
			plateHex,plateHept,plateOcta,plateDense};
	
	public S(String m,int c){
		color=c;
		material=m;
		for(@SuppressWarnings("unused") T ing:ingots)
			ing=new T(color);
		for(@SuppressWarnings("unused") T dst:dusts)
			dst=new T(color);
		for(@SuppressWarnings("unused") T gm:gems)
			gm=new T(color);
		leaf=new T(color);
		nugget=new T(color);
		hammer=new T(color);
		binder=new T(color);
		mortar=new T(color);
	}
		//TODO: Add bind.png to assets
		//TODO: Add plate?.png to assets
	/*public enum CM{ TODO: Move to L.j()
		/**No Null Check for prev NNC,
		/**Use Original tools OR,
	}
	public S c(Item mat, CM... flags) throws Exception{
		Item ham,bind,mort;
		if(hasFlag(CM.OR, flags)&&hasFlag(CM.NNC)){
			ham=L.OHammer;
			bind=L.OBinder;
			mort=L.OMortar;
		}
		else if(prev==null&&!hasFlag(CM.NNC, flags)
			throw new Exception("S.c(IC...): prev is null and flag NNC was not set! ");
		else{
			ham=prev.hammer;
			bind=prev.binder;
			mort=prev.mortar;
		}
		R.c(this.hammer,
			"pp ",
			"PPs",
			"pp ",
			'p', plateDense,
			'P', plateOcta,
			's', Items.STICK);
		R.c(this.binder,
			"isi",
			"scs",
			"isi",
			'i', ingot,
			's', ModItems.armorPlatingTE4,
			//'s', Fluix Pearl,
			//'c', Quantum Core 
			);
		R.c(this.mortar,
			"  i",
			"d d",
			"opo",
			'i', ingot,
			'd', plateDense,
			'o', plateOcta, 
			'p', plateQuin);
		
		for(int i=0;i<gems.length;i++){
			Item gm=gems[i];
			if(i==0){
				R.c(gm, 
					" m ",
					"mbm",
					" m ",
					'm', mat,
					'b', bind);
				continue;
			}
			Item gm0=gems[i-1];
			R.c(gm,
				" m ",
				"mbm",
				" m ",
				'm', gm0,
				'b', bind);
		}
		for(int i=0;i<dusts.length;i++){
			Item dst=dusts[i];
			if(dst==dustTiny){
				R.s(this.dustTiny,gemMaster,hamm);
				continue;
			}
			Item dst0=dusts[i-1];
			R.c(dst,
				"ddd",
				"ddd",
				"ddd",
				'd', dst0);
		}
		GameRegisry.addSmelting(dust, nugget, 0.001f);
		R.c(leaf,
			"nnn",
			"nnn",
			"nnn", 'n', nugget);
		R.c(ingot,
			" ll",
			"lll",
			"ll ", 'l', leaf);
		for(int i=1;i<ingots.length;i++){
			R.c(ingots[i],
				"h","i","s",
				'h',ham,'i',ingot,'s',ingots[i-1]);
		}
		AltarRecipeRegistry.registerRecipe(
			new AltarRecipeRegisrty.AltarRecipe(
				T.s(ingotQuin),T.s(plate),
				EnumAltarTier.SIX,1,1,1));
		for(int i=1;i<plates.length-1;i++){
			R.c(plates[i],
				"h","p","s",
				'h',ham,'p',plate,'s',plates[i-1]);
		}
		BotaniaAPI.registerElvenTrade(T.s(plateDense),T.s(plateOcta));

		return this;
	
	/*protected static boolean hasFlag(CM f, CM... flags){
		for(CM flag:flags)
			if(flag==f)
				return t;
		return S.f;
	}*/
}
