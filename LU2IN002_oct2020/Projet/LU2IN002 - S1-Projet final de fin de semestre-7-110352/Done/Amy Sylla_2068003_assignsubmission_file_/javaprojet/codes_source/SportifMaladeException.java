

/**
 * 
 * @author Amy Sylla
 * Cette classe permet de gerer l'etat de sante des sportifs du club
 */



public class SportifMaladeException extends Exception{

	
	/**
	 * Constructeur
	 * @param s le message à afficher
	 */
	public SportifMaladeException(String s){
		super(s);
	}
	
	
	/**
	 * affichage du message
	 */
	public String toString(){
		return "Ce sportif doit consulter un medecin.";
	}
	
}