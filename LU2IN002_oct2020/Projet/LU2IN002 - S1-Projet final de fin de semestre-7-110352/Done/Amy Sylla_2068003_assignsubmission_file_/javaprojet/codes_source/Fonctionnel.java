

/**
 * 
 * @author Amy Sylla
 *Cette interface est implémentée par les classes Velo et VoitureDeSport
 */

public interface Fonctionnel{
	
 
	/**
	 * permet de controler l'etat des velos et voitures de sport
	 * @return true si le velo ou la voiture de sport est en bon etat, false sinon
	 * @throws VehiculeEnBonEtatException
	 */
	public boolean enEtat() throws VehiculeEnBonEtatException;
	
	/**
	 * permet de modifier distance_parcourue
	 * @param distance la nouvelle distance parcourue
	 */
	public void rouler(double distance);
}
