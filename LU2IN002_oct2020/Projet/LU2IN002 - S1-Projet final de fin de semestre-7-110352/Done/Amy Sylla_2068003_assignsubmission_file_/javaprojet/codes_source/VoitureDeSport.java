

/**
 * 
 * @author Amy Sylla
 *Cette classe permet de gerer les voitures du club sportif
 */

public class VoitureDeSport implements Fonctionnel{
	
	private int etat;
	private String marque;
	private double distance_parcourue;
	private double vitesse_moyenne;
	
	
	/**
	 * Constructeur
	 * @param marque la marque de la voiture
	 */
	public VoitureDeSport(String marque){
		this.marque = marque;
		etat = (int)(Math.random()*11);
		distance_parcourue = 0.0;
		vitesse_moyenne = Math.random()*100 + 100;
	}
	
	
	/**
	 * permet de controler l'etat de la voiture
	 * @return l'etat de la voiture
	 * @throws VehiculeEnBonEtatException declenche l'exception si la voiture n'est en bon etat
	 */
	public boolean enEtat() throws VehiculeEnBonEtatException{
		if (etat<7){
			throw new VehiculeEnBonEtatException("Ce velo doit etre remplace.");
		}
		return true;
	}
	
	
	/**
	 * permet de modifier la vitesse de la voiture
	 * @param v la nouvelle vitesse de la voiture
	 */
	public void setVitesseMoyenne( double v){
		vitesse_moyenne += v;
	}
	
	
	/**
	 * permet de modifier distance_parcourue
	 * @param d la nouvelle distance
	 */
	public void setDistanceParcourue(double d){
		distance_parcourue = d;
	}
	
	
	/**
	 * permet d'ajouter une certaine distance parcourue
	 * @param distance la distance à ajouter
	 */
	public void rouler(double distance){
		distance_parcourue += distance;
	}
	
	
	/**
	 * accesseur de etat
	 * @return l'etat de la voiture
	 */
	public int getEtat(){
		return etat;
	}
	
	
	/**
	 * accesseur de marque
	 * @return la marque de la voiture 
	 */
	public String getMarque(){
		return marque;
	}
	
	/**
	 * accesseur de distance_parcourue
	 * @return la distance parcourue par la voiture
	 */
	public double getDistanceParcourue(){
		return distance_parcourue;
	}
	
	
	/**
	 * accesseur de vitesse_moyenne
	 * @return la vitesse de la voiture
	 */
	public double getVitesseMoyenne(){
		return vitesse_moyenne;
	}
	
	
	/**
	 * affichage de la voiture
	 * @return la marque, l'etat, la distance parcourue et la vitesse moyenne
	 */
	public String toString(){
		return "Voiture de sport de la marque " + marque + ", etat:" + etat + ", distance_parcourue:" + distance_parcourue + " ,vitesse_moyenne:"+ vitesse_moyenne;
	}
}