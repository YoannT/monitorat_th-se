

/**
 * 
 * @author Amy Sylla
 *Cette classe décrit les sportifs de la discipline course de sport
 */



public class Automobiliste extends Sportif{

	private static int identifiant = 0;
	
	
	/**
	 * Constructeur
	 * @param nom  le nom de l'automobiliste
	 * @param age l'age de l'automobiliste
	 * @param poids le poids de l'automobiliste
	 */
	public Automobiliste(String nom, int age, double poids){
		super(nom,age,"course automobile",poids);
		identifiant++;
	}
	
	
	/**
	 * accesseur de identifiant
	 * @return l'identifiant de l'automobiliste
	 */
	public int getIdentifiant(){
		return identifiant;
	}
	
	
	/**
	 * affichage de l'automobiliste
	 * @return l'identifiant, le nom, le sport pratiqué et le niveau
	 */
	public String toString(){
		return "Numero: " + identifiant + " " + super.toString();
	}
	
}