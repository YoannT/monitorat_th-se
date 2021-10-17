import java.lang.Math;
public class Agriculteur{
	private int x, y;
	private String nom;
	public Agriculteur(int ligne, int colonne,String nom){
		x = ligne;
		y = colonne;
		this.nom=nom;
	}

	//calcul de distance entre 2 points
	public double distance(int x1, int y1){
		return Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
	}

	//deplacement a de nouvelles coordonnees
	public String seDeplacer(int xnew, int ynew){
		x = xnew;
		y = ynew;
		return "("+x+","+y+")";
	}
	public String getNom(){
		return nom;
	}
	public Agriculteur clone(){
		return new Agriculteur(x,y,nom);
	}
}
