/**
 * 
 */
 
/**
* @author Louise Le Reun
* Cette classe permet de creer des ressources de type Pierre
*/
public class Pierre extends Ressource{
	private int valeur;
	
	/**Constructeur de Ressource de type Pierre
    *@param type nom de la pierre
    *@param quantite quantite de la ressource
    */
	public Pierre(String type, int quantite){
		super(type,quantite);

        //affectation de la valeur de la pierre
        //si c'est une Roche, sa valeur est 0
        if (type=="Roche"){
            this.valeur=0;
        //sinon
        }else{
		    this.valeur=(int)(Math.random()*(2000-100)) + 100;
        }
	}

	/**Accesseur de type
	*@return le nom de la pierre
	*/
    public String getType(){
		return type;
	}

	/**Accesseur de valeur
	*@return la valeur de la pierre
	*/
    public int getValeur(){
		return valeur;
	}
}