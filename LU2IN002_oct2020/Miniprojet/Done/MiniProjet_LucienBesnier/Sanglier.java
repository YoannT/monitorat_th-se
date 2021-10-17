public class Sanglier{
	private static int i=0;
	private int comp;
	private static int j=0;
	private static int id = 0;
	private int cpt;
	
	public Sanglier(){
		i=comp;
		this.j=j;
		id=cpt++;
		}
		
	public static int getID(){
		return id;
		}
		
	public static String RepresentationGraph(){
		return "S";
		}
		
	public String toString(){
		return "Sanglier numero "+id;
		}
}
