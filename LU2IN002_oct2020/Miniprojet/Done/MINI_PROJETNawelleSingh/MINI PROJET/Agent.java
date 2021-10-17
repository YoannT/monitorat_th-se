import java.util.Random;
/**
 * @author Nawelle SINGH
 * Cette classe permet de gerer un agent sur le terrain
 */

public class Agent{
	/**
	 * Attributs correspondants a la position de l'agent
	 */
	private int posX;
	private int posY;
	/**
	 * Constructeur standard a partir de deux reels
	 * @param x : coordonnee sur la ligne
	 * @param y : coordonnee sur la colonne
	 */
	protected Agent(int x, int y){
		posX = x;
		posY = y;
	}
	/**
	 * Constructeur standard ou les coordonnees sont donnees au hasard
	 */
	
	protected Agent(){
		Random random = new Random();
		posX = random.nextInt(Terrain.NBLIGNESMAX);
		posY = random.nextInt(Terrain.NBCOLONNESMAX);
	}
	/**
	 * @return la coordonnee sur la ligne
	 */
	public int getPosX(){
		return posX;
	}
	/**
	 * @return la coordonnee sur la colonne
	 */
	public int getPosY(){
		return posY;
	}
	/**
	 * @param x : coordonnee-ligne finale
	 * @param y : coordonnee-colonne finale
	 * @return la distance euclidienne entre les deux coordonnées
	 */
	public double distance(int x, int y){
		return Math.sqrt(Math.pow(posX-x,2.0) + Math.pow(posY-y,2.0));
	}
	/**
	 * Permet de deplacer l'aventurier en fournissant de nouvelles coordonnees
	 * @param xnew : coordonnee-ligne nouvelle
	 * @param ynew : coordonnee-colonne nouvelle
	 */
	public void seDeplacer(int xnew, int ynew){
		posX = xnew;
		posY = ynew;
	}
	/**
	 * @return la position sous forme [x,y]
	 */
	public String toString(){
		return "[" + posX + "," + posY + "]";
	}
	/**
	 * Permet de cloner un agent
	 */
	public Agent clone(){
		return new Agent(this.posX,this.posY);
	}
	
}