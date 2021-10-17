public class Personne{
	private int i;
	private int j;
	private static int id = 0;
	private int cpt;
	
	public Personne(int i, int j){
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
		
}
