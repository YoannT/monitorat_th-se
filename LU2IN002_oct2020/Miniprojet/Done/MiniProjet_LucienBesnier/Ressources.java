public class Ressources{
	private int i;
	private int j;
	private static int id = 0;
	private int cpt;
	
	public Ressources(int i, int j){
		this.i=i;
		this.j=j;
		id=cpt++;
		}
		
	public int getID(){
		return id;
		}
		
	public int getX(){
		return i;
		}
		
	public int getY(){
		return j;
		}
	
	public String toString(){
		return "Ressources numero "+id;
		}
	
}
