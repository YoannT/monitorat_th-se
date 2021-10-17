


/**
 * 
 * @author Amy Sylla
 *Cette classe permet de gérer les sportifs du club
 */


public class Sportif extends Membre{
	
	protected String sportPratique;
	protected double energie;
	protected int niveau;
	protected double poids;
	
	
	/**
	 * Constructeur
	 * @param nom le nom du sportif
	 * @param age l'age du sportif
	 * @param sport le sport pratique par le sportif
	 * @param poids le poids du sportif
	 */
	public Sportif(String nom, int age, String sport, double poids){
		super(nom,age);
		sportPratique=sport;
		energie=100;  //energie initial d'un sportif
		niveau=0;    //niveau initial d'un sportif
		this.poids = poids;
	}
	
	
	/**
	 * Constructeur par copie
	 * @param s sportif à copier
	 */
	public Sportif(Sportif s){
		super(s.nom, s.age);
		sportPratique= s.sportPratique;
		energie= s.energie;
		niveau=s.niveau;
		poids=s.poids;
	}
	
	
	/**
	 * accesseur de poids
	 * @return le poids du sportif
	 * @throws SportifMaladeException
	 */
	public double getPoids() throws SportifMaladeException{
		if (poids < 55.0){
			throw new SportifMaladeException("Ce sportif devrait consulter un medecin.");
		}
		return poids;
	}
	
	
	/**
	 * permet de passer à un niveau supérieur
	 */
	public void sEntrainer(){
		if (Math.random() > 0.3){  //dans 30% des cas les sportifs qui s'entrainent passe au niveau superieur
			niveau++;
		}
	}
	
	
	/**
	 * permet de modifier l'energie
	 */
	public void fatiguer(){
		if (Math.random()<0.1){
			energie += -1;
		}
	}
	
	
	/**
	 * affichage du sportif
	 * @return le nom, le sport pratiqué et le niveau
	 */
	public String toString(){
		return "Nom: " + nom +", sport pratique: " + sportPratique + ", niveau: " + niveau;
	}
	
	
	
	/**
	 * accesseur de sportPratique
	 * @return le sport pratiqué par le sportif
	 * @throws SportInconnuException
	 */
	public String getSportPratique() throws SportInconnuException{
		if (sportPratique.compareTo("cyclisme")!=0 && sportPratique.compareTo("course automobile")!=0){
			throw new SportInconnuException("Sport inconnu.");
		}
		return sportPratique;
	}
	
	
	
	/**
	 * accesseur de energie
	 * @return
	 */
	public double getEnergie(){
		return energie;
	}
	
	
	
	/**
	 * accesseur de niveau
	 * @return le niveau du sportif
	 */
	public int getNiveau(){
		return niveau;
	}
}