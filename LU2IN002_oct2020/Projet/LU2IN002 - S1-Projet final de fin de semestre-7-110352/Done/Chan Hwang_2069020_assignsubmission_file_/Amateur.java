/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public class Amateur extends Joueur{

	/**
	* probabilit\u00e9 de taper correctement la balle
	*/
	private double Pbtaper=0.5;
	/**
	* probabilit\u00e9 de renvoyer la balle correctement sur le terrain adverse
	*/
	private double Pbprecision=0.4;

	/**
	* Constructeur standard a partir d'un nom
	* @param name : String
	*/
  public Amateur(String name){
	  super(name);
  }

	/**
	 * Methode pour retourner un classement excessif, pour les amateurs.
	 *@return Retourne arbitrairement 1000
	 */
	public int getClassement(){
		return 1000;
	}

	public void setClassement(int a){}

	public String toString(){
  		return "Je suis "+nom;
  }

  public String getNom(){
    return nom;
  }

	/**
	 * Methode pour voir si la balle a pu etre taper correctement ou non
	 * Le retour de balle doit etre precis egalement
	 */
	public boolean renvoyerBien(){
		double p=(Math.random()*(1));
		double t=(Math.random()*(1));
		if(p<=Pbtaper && t<=Pbprecision){
			return true;
		}
		if(p>Pbtaper)
			System.out.println(nom+ " n'a pas pu taper la balle");
		else if(t>Pbprecision)
			System.out.println("Let | Sortie de table");
		return false;
	}

	/**
	 * Methode exclusive aux pro
	 @return Renvoie toujours false
	 */
	public boolean renvoyerBienPro(Joueur j, boolean coupe, boolean lift, boolean smash){//joueur adversaire en parametre
		return false;
	}
}
