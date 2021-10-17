/**
*Adulte.java
*Interface Adulte
*@author Louise Le Reun
*/
public interface Adulte{

	/**Accesseur de l'age
	@return age*/
	int getAge();

	/**Accesseur du nom
	@return le nom*/
	String getNom();

	/**Tarif annuel a payer
	@param age age de l'adulte
	@return le tarif*/
	int tarifAnnuel(int age);

	/**Vieillit l'adulte d'un an
	*/
	void vieillir();

	/**Donne le tarif familial
	@param p enfant a charge
	@return le prix total
	*/
	int famille(Enfant p);
}