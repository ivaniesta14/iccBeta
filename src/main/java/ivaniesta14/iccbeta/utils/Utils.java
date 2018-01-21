package ivaniesta14.iccbeta.utils;

import net.minecraftforge.fml.common.Loader;

public class Utils {
	public static boolean isLoaded(String m){
		return Loader.isModLoaded(m);
	}
}