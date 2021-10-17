/**
* Cette classe permet de creer des personnes
* @author Louise Le Reun
*/
public class Personne implements Enfant, Adulte{
	private int age;
	private String nom;

	/**Constructeur de personne
	@param age age de la personne
	@param nom nom de la personne
	@exception ErrAge si l'age n'est pas conforme
	*/
	public Personne(int age, String nom) throws ErrAge{
		if(age<=5 || age>=70){
			throw new ErrAge("Erreur age de "+nom+" :"+age+" ans.");
		}else {
			this.age=age;
			this.nom=nom;
		}
	}

	/**Constructeur par copie
	@param p personne a copier
	@exception ErrAge si l'age n'est pas conforme
	*/
	Personne(Personne p) throws ErrAge{
		age=p.age;
		nom=p.nom;
	}

	/**Accesseur de l'age
	*/
	public int getAge(){
		return age;
	}

	/**Accesseur du nom
	*/
	public String getNom(){
		return nom;
	}

	/**Modifie le nom de la Personne (uniquement pour les Personnes crees par copie)
	@param nom nouveau nom
	*/
	public void setNom(String nom){
		this.nom=nom;
	}

	/**tarif annuel a payer par la personne
	@param age age de la personne
	*/
	public int tarifAnnuel(int age){
		int prix=200;
		if(age<18){
			return prix;
		}else if(age<40){
			int i=18;
			while(prix>=155 || i<age){
				prix=prix-5;
				i++;
			}
			return prix;
		}else{
			return 100;
		}
	}

	/**augmente l'age d'un an
	*/
	public void vieillir(){
		age++;
	}

	/**tarif familial a payer (uniquement pour les adultes)
	@param p enfant a gerer
	*/
	public int famille(Enfant p){
		return tarifAnnuel(age)+p.tarifAnnuel(p.getAge());
	}
}