/**
 * 
 */
 
/**
* @author Louise Le Reun
* Cette classe permet de creer des mineurs
*/

public class Mineur{
	private int x,y;

	/**Constructeur de mineurs
    *@param x position de la ligne
    *@param y position de la colonne
    */
	public Mineur(int x,int y){
		this.x=x;
		this.y=y;
	}

	/**Calcule la distance qui separe le mineur de la case (x,y) passee en parametre
	*@param x1 ligne de la case
	*@param y1 colonne de la case
	*@return renvoie la distance qui separe le mineur de la case
	*/
    public int distance(int x1,int y1){
		return (int)Math.sqrt(Math.pow((double)(x-x1),2.0)+Math.pow((double)(y-y1),2.0));
	}

    /**Deplace le mineur sur la case (x,y) passee en parametre
	*@param xnew position de la ligne de la nouvelle case
	*@param ynew position de la colonne de la nouvelle case
	*/
	public void seDeplacer(int xnew, int ynew){
		x=xnew;
		y=ynew;
	}

    /**Accesseur de X
	*@return le numero de ligne
	*/
	public int getX(){
		return x;
	}

	/**Accesseur de Y
	*@return le numero de colonne
	*/
    public int getY(){
		return y;
	}
}