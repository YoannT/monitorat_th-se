

/**
 * 
 * @author Amy Sylla
 *Cette classe permet de gerer l'ensemble des velos et voituresdu club sportif
 */


public class Parking{
	
	private static Parking INSTANCE = null;
	private static Velo[] tabVelos = new Velo[50];
	private static VoitureDeSport[] tabVoitures = new VoitureDeSport[50];
	
	
	/**
	 * Constructeur
	 */
	private Parking(){
		for (int i=0; i< tabVelos.length; i++){
			tabVelos[i] = null;
		}
		
		for (int i=0; i< tabVoitures.length; i++){
			tabVoitures[i] = null;
		}
	}
	
	/**
	 * permet de creer une instance unique de Parking 
	 */
	private synchronized static void creerInstance(){
		if (INSTANCE == null){
			INSTANCE = new Parking();
		}
	}
	
	
	/**
	 * permet d'acceder à l'unique instance de Parking
	 * @return l'unique instance de Parking
	 */
	public static Parking getInstance(){
		if (INSTANCE == null){
			creerInstance();
		}
		return INSTANCE;
	}
	
	
	/**
	 * permet d'ajouter si possible un velo dans le parking
	 * @param v le velo à ajouter
	 */
	public void ajouterVelo(Velo v){
		int i=0;
		while ( i < tabVelos.length && tabVelos[i]!= null){
			i++;
		}
		if (i == tabVelos.length - 1){
			System.out.println("L'espace velo est complet. Ajout impossible.");
		}else{
			tabVelos[i] = v;
		}
	}
	
	
	/**
	 * permet d'ajouter si possible une voiture dans le parking
	 * @param v la voiture à ajouter
	 */
	public void ajouterVoiture(VoitureDeSport v){
		int i=0;
		while ( i < tabVoitures.length && tabVoitures[i]!= null){
			i++;
		}
		if (i == tabVoitures.length - 1){
			System.out.println("L'espace voiture est complet. Ajout impossible.");
		}else{
			tabVoitures[i] = v;
		}
	} 
			
}