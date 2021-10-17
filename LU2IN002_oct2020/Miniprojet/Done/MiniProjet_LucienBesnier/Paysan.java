public class Paysan extends Personne{
	private String nom;
	private int i,j;
	
	public Paysan(String nom,int i,int j){
		super(i,j);
		this.nom=nom;
		}
	
	public Paysan(){
		this("Pierre",(int)(Math.random()*20),(int)(Math.random()*20));
		}
			
	public String toString(){
		return nom;
		}
			
	public String RepresentationGraph(){
		return "P";
		}
} 


