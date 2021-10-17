/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public abstract class Joueur{
	protected String nom;
	protected double Pbtaper=0.9;
	protected double Pbprecision=0.5;
	protected int pointTournois;

	protected Joueur(String name){
		nom=name;
		pointTournois=0;
	}

	public String getNom(){
		return nom;
	}
	public String toString(){
		return "Je suis un joueur : "+nom;
	}
	public abstract int getClassement();
	public abstract void setClassement(int a);
	public void setPbtaper(double d){
		Pbtaper=d;
	}

	public void setPbprecision(double d){
		Pbprecision=d;
	}

	public double getPbtaper(){
		return Pbtaper;
	}

	public double getPbprecision(){
		return Pbprecision;
	}

	public void setPointTournois(int a){
		pointTournois=a;
	}

	public int getPointTournois(){
		return pointTournois;
	}

	public abstract boolean renvoyerBien();

	public abstract boolean renvoyerBienPro(Joueur j, boolean coupe, boolean lift, boolean smash);//joueur adverse en parametre


}
