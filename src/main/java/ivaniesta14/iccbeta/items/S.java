package ivaniesta14.iccbeta.items

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import tonius.simplyjetpacks.setup.ModItems;
import WayofTime.bloodmagic.api.registry.AltarRecipeRegistry;
import static WayofTime.bloodmagic.api.registry.AltarRecipeRegistry.AltarRecipe;
import WayofTime.bloodmagic.api.altar.EnumAltarTier;
import vazkii.botania.api.BotaniaAPI;
import ivaniesta14.iccbeta.L;

public class S {
	public static final boolean f=false,t=true;
	public int color;
	public String material;
	public T ingot,ingotDouble,ingotTriple,ingotQuad,ingotQuin;
	public T dust,dustSmall,dustTiny;
	public T gemMaster,gemHuge,gemBig,gem,gemSmall,gemTiny;
	public T leaf,nugget,hammer,binder,mortar;
	public T plate,plateDouble,plateTriple,plateQuad,plateQuin,plateHex,plateHept,plateOcta,plateDense;
	protected S prev=null;
	
	public T[] ingots={ingot,ingotDouble,ingotTriple,ingotQuad,ingotQuin};
	public T[] dusts={dustTiny,dustSmall,dust};
	public T[] gems={gemTiny,gemSmall,gem,gemBig,gemHuge,gemMaster};
	public T[] plates={plate,plateDouble,plateTriple,plateQuad,plateQuin,plateHex,plateHept,plateOcta,plateDense};
	
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
		hammer=new T(color);
		binder=new T(color);
		mortar=new T(color);
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
		R.r(hammer,1,"hammer"+material,f,"hamm");
		R.r(binder,1,"binder"+material,f,"bind");
		///TODO: Add bind.png to assets
		for(int i=0;i<plates.length;i++)
			R.r(plates[i],plates.length-i,
				"plate"+material+String.valueOf(i),f,
				"plate"+String.valueOf(i));
		///TODO: Add plate?.png to assets 
		R.r(mortar,1,"hammer"+material,f,"mortar");
		return this;
	}
	public enum CM{
		PB, //This set should bypass prev==null check. 
		IR, //this should use the Original Hammer, the Original Binder and the Original Mortar, not prev's ones; requires flag PB.
	}
	public S c(Item mat, CM... flags) throws Exception{
		if(prev==null&&!hasFlag(CM.PB, flags)
			throw new Exception("S.c(IC...): prev is null and flag PB was not set! ");
		Item ham=prev.hammer;
		Item bind=prev.binder;
		Item mort=prev.mortar;
		if(hasFlag(CM.IR, flags)){
			ham=L.OHammer;
			bind=L.OBinder;
			mort=L.OMortar;
		}
		R.c(this.hammer,
			"pp ",
			"PPs",
			"pp ",
			'p', plateDense,
			'P', plateOcta,
			's', Items.stick);
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
	}
	protected static boolean hasFlag(CM f, CM... flags){
		for(CM flag:flags)
			if(flag==f)
				return t; 
		return f;
	}
}
