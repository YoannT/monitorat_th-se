public class Fourmillière {
	private int réserve_protéine;
	private int réserve_glucid;
	private int réserve_graine;
	public int x;
	public int y;
	public Fourmillière(int inix,int iniy){
		réserve_protéine= 0;
		réserve_glucid= 0;
		réserve_graine= 0;
		x= inix;
		y= iniy;
	}
	public void set_reserve_protéine(int quantitée){
		réserve_protéine= réserve_protéine+quantitée;
	}
	public void set_reserve_glucid(int quantitée){
		réserve_glucid= réserve_glucid+quantitée;
	}
	public void set_reserve_graine(int quantitée){
		réserve_graine= réserve_graine+quantitée;
	}
		
	public String get_reserve(){
		return "("+réserve_protéine+","+réserve_glucid+","+réserve_graine+")";
	}
	public String get_androit(){
		return "("+x+y+")";
	}
}
	
