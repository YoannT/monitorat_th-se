

/**
 * 
 * @author Amy Sylla
 * Cette classe permet de verifier les disciplines sportives du club
 *
 */




public class SportInconnuException extends Exception{
	
	
	/**
	 * Constructeur
	 * @param s le message à afficher
	 */
	public SportInconnuException(String s){
		super(s);
	}
	
	
	/**
	 * affichage du message
	 */
	public String toString(){
		return "Ce club ne gere pas ce sport.";
	}
}
