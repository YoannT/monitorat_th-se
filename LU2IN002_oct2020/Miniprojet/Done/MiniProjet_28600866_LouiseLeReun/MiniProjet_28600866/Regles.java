public class Regles{
	private Regles(){}

	/**Affiche les regles de la simulation
    */
    public static void afficher(){
        System.out.println("======== Regles de la simulation ========");
        System.out.println("");
        System.out.println("En resume :");
        System.out.println("Des mineurs parcourent un terrain ou se trouvent de la roche, les recoltent et les deposent dans l'atelier. Chaque roche a une certaine chance d'etre transformee en pierre precieuse, d'une valeur comprise entre 100 et 2000€. Les mineurs reposent parfois de la roche sur le terrain.");
        System.out.println("");
        System.out.println("* Initialisation ========");
        System.out.println("Creation d un terrain, de n mineurs (places aleatoirement sur le terrain) et de m Roches (placees elles aussi aleatoirement). Un atelier est cree vide et place dans le coin en haut a gauche du terrain. Les informations de base sont donnees avant de commencer la recolte.");
        System.out.println("");
        System.out.println("* Execution ========");
        System.out.println("\t1) Recolte");
        System.out.println("Chaque mineur va sur la case d'une roche au hasard et la recupere (s'il reste des roches). La roche est enlevee du terrain.");
        System.out.println("Les mineurs vont immediatement deposer a l'atelier les roches qu'ils ont recuperes, et les compteurs de chaque pierres sont mis a jour et affiches.");
        System.out.println("\t2) Production");
        System.out.println("Au bout de plusieurs recoltes, les mineurs essayent de reposer une roche de facon aleatoire sur le terrain.");
        System.out.println("Si la case est vide, le mineur prend une roche du stock de l'atelier et l'y depose, et les compteurs sont remis a jours.");
        System.out.println("\t3) Comptage");
        System.out.println("A la fin de la simulation, on compte la valeur totale du stock et on evalue la richesse que cela represente.");
    	System.out.println("");
    }
}
