/**
 * @author Nawelle SINGH
 * Cette classe permet de gerer un monstre qui possede un identifiant id et un flottant qui modelise son niveau de force.
 */

public class Mob extends Agent{
	/**
	 * Attributs correspondants à son id, et a son niveau de force
	 */
	private int id;
	private static int cpt = 1;
	private double niveau;
	/**
	 * Constructeur standard ou la position du monstre est aleatoire et ou le niveau du monstre est egalement aleatoire
	 */
	public Mob(){
		super();
		id = cpt;
		cpt++;
		niveau = Math.random()*100;
	}
	/**
	 * Constructeur standard ou la position du monstre est donnee par les parametres posX et posY et ou le niveau du monstre est aleatoire
	 * @param posX : coordonnee-ligne du monstre
	 * @param posY : coordonnee-colonne du monstre
	 */
	public Mob(int posX, int posY){
		super(posX,posY);
		id = cpt;
		cpt++;
		niveau = Math.random()*100;
	}
	/**
	 * Retourne l'id du monstre
	 * @return rend l'id du monstre
	 */
	public int getID(){
		return id;
	}
	/**
	 * Retourne le niveau de force du monstre
	 * @return rend le niveau du monstre
	 */
	public double getNiveau(){
		return niveau;
	}
	/**
	 * Retourne la position du monstre
	 * @return rend la position du monstre sous la forme d'un String [x,y]
	 */
	public String getPosition(){ 
		return super.toString();
	}
	/**
	 * @return rend un String de la forme xx Mob + [id] -- position: [x,y]
	 */
	public String toString(){
		return "xx Mob" + id + " -- position:"+super.toString();
	}
	
}