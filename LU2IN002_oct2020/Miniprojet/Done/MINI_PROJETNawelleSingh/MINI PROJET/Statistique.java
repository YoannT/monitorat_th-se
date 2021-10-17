/**
 * @author Nawelle SINGH
 * Cette classe gere les statistiques liees aux ramassages et aux combats 
 */

public class Statistique{
	/**
	 * Quantite totale de ressources
	 */
	protected static int nbRessourceTotal = 0;
	/**
	 * Nombre de fois ou l'inventaire a ete rempli 
	 */
	protected static int nbInventaireRempli = 0;
	/**
	 * Nombre de quantite de ressources qui ont ete ramasses
	 */
	protected static int nbRessourcesRamassees = 0;
	/**
	 * Nombre de quantite de ressources qui ont ete transformees en lingot
	 */
	protected static int nbRessourcesProduites = 0;
	/**
	 * Nombre de cases sur le terrain qui ont ete videes
	 */
	protected static int nbCasesVidees = 0;
	/**
	 * Nombre de monstres et de ressources au debut de la simulation
	 */
	protected static int nbRessourceEtMob_Debut;
	/**
	 * Nombre de monstres a la fin de la simulation
	 */
	protected static int nbMob_Fin;
	/**
	 * Nombre de cas d'urgence detecte pendant la simulation
	 */
	protected static int nbUrgence = 0;
	/**
	 * Nombre de combat
	 */
	protected static int nbCombat = 0;
	/**
	 * Nombre de combat gagne
	 */
	protected static int nbCombatGagne = 0;
	/**
	 * Nombre de combat perdus
	 */
	protected static int nbCombatPerdu = 0;
	
	private Statistique(){}
	/** 
	 * Renvoie toutes les informations sur la simulation : ramassage, population de monstres et combats.
	 * @return un String avec toutes les informations des variables statiques
	 */
	public static String resultats(){
		String s = "";
		s = "########## STATISTIQUE ##########\n\n";
		s += "~~~~~~ Ramassage ~~~~~~\n";
		s += "== Quantite de minerais totale : " + nbRessourceTotal + "\n";
		s += "== Nombre de cases qui ont ete videes : " + nbCasesVidees + "\n";
		s += "== Nombre de minerais ramasses : "+ nbRessourcesRamassees + "\n";
		s += "== Nombre de lingots produits : "+ nbRessourcesProduites + "\n";
		s += "== Nombre de fois où l'inventaire a ete rempli : " + nbInventaireRempli + "\n";
		s += "==> Au total, il y a eu "+ String.format("%.2f",(((float)nbRessourcesRamassees)/nbRessourceTotal)*100.0) + "% de minerais qui ont ete ramasses, dont " + String.format("%.2f",((float)nbRessourcesProduites)/nbRessourcesRamassees*100.0) + "% qui ont ete transformes en lingot.\n";
		s += "~~~~~~ Population de monstres ~~~~~~\n";
		s += "== Nombre de monstres au debut : " + nbRessourceEtMob_Debut + "\n";
		s += "== Nombre de monstres a la fin : " + nbMob_Fin + "\n";
		s += "==> " + String.format("%.2f",((float)(nbRessourceEtMob_Debut - nbMob_Fin))/nbRessourceEtMob_Debut*100.0) + "% de monstres qui ont ete extermines.\n";
		s += "~~~~~~ Combats ~~~~~~\n";
		s += "== Nombre d'urgence : " + nbUrgence + "\n";
		s += "== Nombre de combats : " + nbCombat + "\n";
		s += "== Nombre de combats gagnes : " + nbCombatGagne + " / perdus : " + nbCombatPerdu + "\n";
		s += "==> " + String.format("%.2f",((float)nbCombatGagne)/nbCombat*100.0) + "% ont ete gagnes.\n";
		s += "################################\n";
		return s;
	}
}