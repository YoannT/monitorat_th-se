/**
 * 
 */
 
/**
* @author Louise Le Reun
* Cette classe permet de creer des ressources de type Roche
*/
public class Roche extends Ressource{
	public final double chance;

	/**Constructeur de Ressource de type Roche
    *@param type nom de la pierre
    *@param quantite quantite de la ressource
    */
	public Roche(String type,int quantite){
		super(type,quantite);
		chance=Math.random();
	}

	/**Clone la roche sur laquelle la methode est appelee
	*@return nouvelle Roche
	*/
	public Roche clone(){
		return new Roche(this.type,this.quantite);
	}

	/**Accesseur de chance
	*@return retourne la chance d'obtenir une Pierre
	*/
    public double getChance(){
		return chance;
	}
}