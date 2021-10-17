public class Chasseur extends Personne{
	private String nom;
	private int i;
	private int j;
	
	public Chasseur(int i, int j){
		super(i,j);
		this.nom="Jean"+super.getID();
		}
	
	public Chasseur(){
		this((int)(Math.random()*20),(int)(Math.random()*20));
		}	
		
	public String toString(){
		return nom;
		}
		
	public String RepresentationGraph(){
		return "C";
		}		
} 
