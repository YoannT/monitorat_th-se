/**
 * @author Nawelle SINGH
 * Cette classe gere la simulation avec les deplacements, les combats et les transformations de materiaux, il affiche egalement les statistiques dans le terminale
 */

public class TestSimulation{
	public static void main(String[]args){
		Simulation s1 = new Simulation(250,10); //premiere valeur: nombre de ressource //deuxieme valeur: nombre d'aventuriers
		
		int tour = 100; //modifiable à souhait
		
		for(int i = 0; i < tour ; i++){
			System.out.println("------ TOUR " + (i+1) + " --------------------");
			System.out.println("~~~~~~ Deplacement des aventuriers ~~~~~~");
			s1.deplacement();
			System.out.println("~~~~~~ Combat ~~~~~~");
			s1.rencontre();
			System.out.println("~~~~~~ Ramassage ~~~~~~");
			s1.ramassage();
			System.out.println("~~~~~~ Camp ~~~~~~");
			s1.camp();
			s1.afficher();
			System.out.println("------ FIN DU TOUR " + (i+1) + " -------------");
		}
		
		s1.t.affiche();
		
		System.out.println(Statistique.resultats());
		
	}
}