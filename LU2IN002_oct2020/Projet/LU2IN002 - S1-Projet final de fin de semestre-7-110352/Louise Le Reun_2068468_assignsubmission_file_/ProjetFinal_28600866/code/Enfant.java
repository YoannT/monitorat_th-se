/**
*Enfant.java
*Interface Enfant
*@author Louise Le Reun
*/
public interface Enfant{

	/**Accesseur de l'age
	@return age*/
	int getAge();

	/**Accesseur du nom
	@return le nom*/
	String getNom();

	/**Tarif annuel a payer
	@param age age de l'enfant
	@return le tarif*/
	int tarifAnnuel(int age);

	/**Vieillit l'enfant d'un an
	*/
	void vieillir();
}