package ivaniesta14.iccbeta;

import org.apache.logging.log4j.*;

public abstract class O{
	private static Logger l=LogManager.getLogger("ICCBeta");
	public static void o(Level lv,Throwable e,Object m){
		o(lv,m);
		e.printStackTrace();
	}
	public static void o(Level lv,Object m){
		l.log(lv,m);
	}
	public static void o(Object m){
		o(Level.INFO,m);
	}
	public static void f(Object m) {
		o(Level.FATAL,m);
	}
}
