

/**
 * 
 * @author Amy Sylla
 *Cette classe permet de gerer les velos du club sportif
 */



public class Velo implements Fonctionnel{
	
	private int etat;
	private String marque;
	private double distance_parcourue;
	
	
	/**
	 * Constructeur
	 * @param marque la marque du velo
	 */
	public Velo(String marque){
		this.marque = marque;
		etat = (int)(Math.random()%11);	
		distance_parcourue = 0.0;
	}
	
	
	/**
	 * permet de controler l'etat des velos et voitures de sport
	 * @return true si le velo ou la voiture de sport est en bon etat, false sinon
	 * @throws VehiculeEnBonEtatException declenche l'exception si le velo n'est en bon etat
	 */
	public boolean enEtat() throws VehiculeEnBonEtatException{
		if (etat<7){
			throw new VehiculeEnBonEtatException("Ce velo doit être remplace.");
		}
		return true;
	}
	
	
	/**
	 * permet de modifier distance_parcourue
	 * @param distance la nouvelle distance parcourue
	 */
	public void rouler(double distance){
		distance_parcourue +=  distance;
	}
	
	
	/**
	 * accesseeur de etat
	 * @return l'etat du velo
	 */
	public int getEtat(){
		return etat;
	}
	
	
	/**
	 * accesseur de marque
	 * @return la marque du velo
	 */
	public String getMarque(){
		return marque;
	}
	
	
	/**
	 * accesseur de distance_parcourue
	 * @return la distance parcourue par le velo
	 */
	public double getDistanceParcourue(){
		return distance_parcourue;
	}
	
	
	/**
	 * affichage du velo
	 * @return la marque du velo
	 */
	public String toString(){
		return "Velo de la marque " + marque +", etat:" + etat + ", distance parcourue:" + distance_parcourue;
	}
		
	
}