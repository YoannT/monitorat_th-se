

/**
 * 
 * @author Amy Sylla
 *Cette classe permet de verifier l'etat des velos et voitures du club
 */



public class VehiculeEnBonEtatException extends Exception{
	
	
	/**
	 * Constructeur
	 * @param s le message à afficher
	 */
	public VehiculeEnBonEtatException( String s){
		super(s);
	}
	
	
	/**
	 * affichage du message
	 */
	public String toString(){
		return "Ce vehicule doit etre remplace.";
	}
	
	
}
