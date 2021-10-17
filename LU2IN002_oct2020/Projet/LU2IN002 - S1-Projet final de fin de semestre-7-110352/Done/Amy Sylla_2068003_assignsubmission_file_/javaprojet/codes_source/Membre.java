

/**
 * 
 * @author Amy Sylla
 *Cette classe permet de gérer les membres du club
 */


public abstract class Membre{
	
	protected String nom;
	protected int age;
	
	
	/**
	 * Constructeur
	 * @param nom le nom du membre
	 * @param age l'age du membre
	 */
	public Membre(String nom, int age){
		this.nom = nom;
		this.age = age;
	}
	
	
	/**
	 * accesseur de nom
	 * @return le nom du membre
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * accessseur de age
	 * @return l'age du membre
	 */
	public int getAge(){
		return age;
	}
	
	
	/**
	 *affichage du membre 
	 * @return le nom et l'age du membre
	 */
	public String toString(){
		return "Nom: " + nom + ", age: " + age;
	}
	
	
	/**
	 * méthode pour entrainer les membres du club
	 */
	public abstract void sEntrainer();
}
