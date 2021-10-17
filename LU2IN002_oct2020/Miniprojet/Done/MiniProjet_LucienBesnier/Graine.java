public class Graine extends Ressources{
	private int i;
	private int j;
		
	public Graine(int i, int j){
		super(i,j);
		}
	
	public Graine(){
		this((int)(Math.random()*20),(int)(Math.random()*20));
		}
			
	public static String RepresentationGraph(){
		return "G";
		}		
}

