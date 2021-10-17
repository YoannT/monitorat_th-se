/**
 * 
 */
 
/**
* @author Louise Le Reun
* Cette classe permet de tester la simulation
*/
public class TestSimulation{
	public static void main(String[] args) {
		int nbLignes = 10;
        int nbColonnes = 10;
        int nbRessources = 40;
        int nbAgents = 5;

        //affichage des Regles
        Regles.afficher();

        //creation de la simulation
        Simulation s = new Simulation(nbLignes, nbColonnes, nbRessources, nbAgents);

        s.affiche();
        //informations du debut
        System.out.println("Il y a "+nbAgents+" mineurs sur le terrain et "+s.getNbRessource()+" ressources.");
        System.out.println("");
        int compteRessource=s.getNbRessource();
        int c=0;

        //boucle de simulation de recolte et de repos
        while((compteRessource>1)&&(c<10)){
            s.recolte();
            s.affiche();
            System.out.println("Il reste "+s.getNbRessource()+" ressources.");
            System.out.println("");
            System.out.println(s.toString());
            System.out.println("");
            s.poser();
            compteRessource=s.getNbRessource();
            c++;
        }

        //comptage des gains
        System.out.println("Vous avez recolte un total de "+s.valeur()+" €.");
        if(s.valeur()<1000){
            System.out.println("Il va falloir creuser un peu plus...");
        }else if (s.valeur()<3000){
            System.out.println("C'est un bon début");
        }else{
            System.out.println("Bientot millionnaire !");
        }
	}
}