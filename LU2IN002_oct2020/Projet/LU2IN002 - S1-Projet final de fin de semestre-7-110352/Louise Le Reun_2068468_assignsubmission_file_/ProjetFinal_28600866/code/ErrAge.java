/**
*Cette classe leve une exception sur l'age d'une personne
*@author Louise Le Reun
*/
public class ErrAge extends Exception{
	
	/**Constructeur de ErrAge
	@param mes message a afficher
	*/
	ErrAge (String mes){
		super(mes);
	}
}