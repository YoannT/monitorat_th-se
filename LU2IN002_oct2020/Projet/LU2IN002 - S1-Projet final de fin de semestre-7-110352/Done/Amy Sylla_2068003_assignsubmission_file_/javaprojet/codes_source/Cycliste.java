

/**
 * 
 * @author Amy Sylla
 * Cette classe décrit les sportifs de la discipline cyclisme
 */


public class Cycliste extends Sportif {
	
	private static int identifiant = 0;
	private double vitesse_moyenne;
	
	
	/**
	 * Constructeur
	 * @param nom le nom du cycliste
	 * @param age l'age du cycliste
	 * @param vitesse_moyenne la vitesse du cycliste
	 * @param poids le poids du cycliste
	 */
	
	public Cycliste(String nom, int age, double vitesse_moyenne, double poids){
		super(nom,age,"cyclisme",poids);
		identifiant++;
		vitesse_moyenne = vitesse_moyenne;
		
	}
	
	
	
	/**
	 * permet de modifier la vitesse courante du cycliste
	 * @param v la nouvelle vitesse
	 */
	public void setVitesseMoyenne(double v){
		vitesse_moyenne += v;
	}
	
	
	
	/**
	 * accesseur de identifiant
	 * @return l'identifiant du cycliste
	 */
	public static int getIdentifiant(){
		return identifiant;
	}
	
	
	
	/**
	 * accesseur de vitesse_moyenne
	 * @return la vitesse moyenne du cycliste
	 */
	public double getVitesseMoyenne(){
		return vitesse_moyenne;
	}
	
	
	
	/**
	 * affichage du cycliste
	 * @returnl'identifiant, le nom, le sport pratiqué et le niveau
	 */
	public String toString(){
		return "Numero: " + identifiant + " " + super.toString();
	}
	
}
