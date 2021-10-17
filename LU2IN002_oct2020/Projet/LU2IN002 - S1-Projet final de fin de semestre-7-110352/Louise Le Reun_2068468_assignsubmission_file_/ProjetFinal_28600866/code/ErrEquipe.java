/**
*Cette classe leve une exception sur les equipes des sports
*@author Louise Le Reun
*/
public class ErrEquipe extends Exception{
	
	/**Constructeur de ErrEquipe
	@param mes message a afficher
	*/
	ErrEquipe(String mes){
		super(mes);
	}
}