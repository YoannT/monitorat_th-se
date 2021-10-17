import java.lang.Math;

public class Meteo {

	public static final int MAXTEMP = 50;
	public static final int MINTEMP = -20;
	public static final int TEMPFROID = 0;
	public static final int TEMPCHAUD = 30;
	
	
	public static String getIntemperies(int temp, boolean intemp) {
		if(intemp) {
			if(temp<=-10) {
				return "il grele";
			}else if(temp<0) {
				return "il neige";
			}else if(temp<25) {
				return "il pleut";
			}else if(temp<45) {
				return "il y a un orage";
			}else {
				return "il y a une eruption volcanique";
			}
		}
		return "il fait beau";
	}
	
	public static int getTemp() {
		return (int)(Math.random()*(MAXTEMP-MINTEMP+1)+MINTEMP);
	}
	
	public static String getMeteo(int temp, boolean intemp) {
		String s = "Il fait "+temp+"C et "+getIntemperies(temp,intemp);
		if(temp<=TEMPFROID)
			s+=" (trop froid)";
		else if(temp>=TEMPCHAUD)
			s+=" (trop chaud)";
		return s;
	}
	
	public static boolean faitMauvais() {
		return Math.random()<.3;
	}
	
	private Meteo() {}
}
