import java.util.ArrayList;

/**
 * 
 */
 
/**
* @author Louise Le Reun
* Cette classe permet de creer un atelier ou seront stockes les ressources
*/

public class Atelier{
	private int x,y;
	private ArrayList<Pierre> stock= new ArrayList<Pierre>();

	/**Constructeur de l'atelier
    *@param x numero de ligne
    *@param y numero de colonne
    *@param stock liste des ressources de type Pierre
    */
	public Atelier(int x, int y, ArrayList<Pierre> stock){
		this.x=x;
		this.y=y;
		this.stock=stock;
	}

	/**Ajoute la pierre passee en parametre au stock de l'atelier
	*@param p Pierre a ajouter au stock
	*/
	public void ajouterPierre(Pierre p){
		stock.add(p);
	}

	/**Retire la pierre passee en parametre au stock de l'atelier
	*@param p Pierre a enlever du sotck
	*/
	public void enleverPierre(Pierre p){
		stock.remove(p);
	}

	/**Accesseur de X
	*@return retourne le numero de ligne de l'atelier
	*/
	public int getX(){
		return x;
	}

	/**Accesseur de Y
	*@return retourne le numero de colonne de l'atelier
	*/
	public int getY(){
		return y;
	}

	/**Accesseur du stock
	*@return retourne le stock
	*/
	public ArrayList<Pierre> getStock(){
		return stock;
	}
}