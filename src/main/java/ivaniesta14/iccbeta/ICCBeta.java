package ivaniesta14.iccbeta;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import ivaniesta14.iccbeta.utils.Utils;

@Mod(modid="iccbeta",name="ICCBeta",version="0.1")
public class ICCBeta {
	private static boolean E=false,F=false,G=false,C=true;
	private static final String[] r={
			"AWWayofTime",		"AdvancedSolarPanel",
			"Avaritia", 		"Botania",
			"DCakeMod",
			"ExtraUtilities",	"IC2",
			"Metallurgy",		"ProjectE",
			"ThermalDynamics",	"ThermalExpansion",
			"Thaumcraft",		"appliedenergistics2",
			"extracells",		"harvestcraft"
	};
	
	@Mod.EventHandler
	public void h(@SuppressWarnings("unused") FMLPreInitializationEvent ev){
		try{
			L.h();
		}
		catch(Throwable e){
			E=true;
			O.o(e);
		}
		finally{
			if(!E)
				O.o("No problems during ICCBeta PreInit!");
			else
				O.f("An exception has been caught during ICCBeta PreInit!");
		}
	}
	@Mod.EventHandler
	public void i(@SuppressWarnings("unused") FMLInitializationEvent ev){
		if(!E)
			try{
				try{
					d();
				}catch(Throwable e){
					C=false;
					O.o(e);
				}finally{
					if(C)
						L.i();
					else
						F=true;
				}
			}catch(Throwable e){
				F=true;
				O.o(e);
			}finally{
				if(!F)
					O.o("No problems during ICCBeta Init!");
				else if(!C)
					O.f("An exception has been caught during ICCBeta Init!");
				else
					O.f("A required mod was not found or loaded during "
						+"ICCBeta Init!");
			}
		else
			O.f("Previous exception caught. ICCBeta Init not executed.");
	}
	public void j(@SuppressWarnings("unused") FMLPostInitializationEvent ev){
		if(E||F)
			O.f("Previous exception caught. ICCBeta PostInit not executed");
		else
			try{
				L.j();
			}catch(Throwable e){
				G=true;
				O.o(e);
			}finally{
				if(!G)
					O.o("No problems duing ICCBeta PostInit");
				else
					O.f("An exception has been caught during ICCBeta "+
						"PostInit!");
			}
	}
	private void d() throws Exception{
		for(int i=0;i<r.length;i++)
			if(Utils.isLoaded(r[i]))
				O.o("Successfully detected mod: "+r[i]+"!");
			else
				throw new Exception(r[i]+" has not been found or is not "
					+"loaded!");
	}
}