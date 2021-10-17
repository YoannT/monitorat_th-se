/**
* Cette classe permet d'afficher les explications du projet
* @author Louise Le Reun
*/
public class Explications{
	private Explications(){}


	/**affiche les explications du projet
	*/
	public static void afficher(){
		System.out.println("=====Resume=====");
		System.out.println("");
		System.out.println("Gestion d'un club multi sport avec des sports d'interieur et d'exterieur");
		System.out.println("");
		System.out.println("=====Les adherents=====");
		System.out.println("");
		System.out.println("Les adherents sont des Personnes (adultes ou enfants) qui peuvent integrer n'importe quel sport.");
		System.out.println("Le tarif d'adhesion est degressif : 200 euros pour les enfants, puis 5 euros en moins chaque annee");
		System.out.println("Jusqu'a la limite de 100 euros.");
		System.out.println("");
		System.out.println("=====Les Sports=====");
		System.out.println("");
		System.out.println("Les sports sont definis par le nombre de joueur pour chaque equipe, son jour dedie, et le nom de son creneau");
		System.out.println("(junior,avance,etc.). On distingue deux types de sports : les sports d'interieur, et les sports d'exterieur.");
		System.out.println("Pour les sports d'interieur, on prend en compte si la salle est libre ou non. Pour les sports d'exterieur,");
		System.out.println("on prend en compte la meteo. Le club propose 6 sports :");
		System.out.println("");
		System.out.println("1) Sports d'interieur");
		System.out.println("\tTennis");
		System.out.println("\tBasketball");
		System.out.println("\tHandball");
		System.out.println("2) Sports d'exterieur");
		System.out.println("\tFootball");
		System.out.println("\tCourse relais");
		System.out.println("\tRugby");
		System.out.println("");
		System.out.println("=====La Gestion=====");
		System.out.println("");
		System.out.println("La gestion est unique et s'occupe de l'ensemble du club : chiffre d'affaire annuel, desabonnement, emploi du temps,");
		System.out.println("modification ou suppression de cours, etc.");
		System.out.println("");
		System.out.println("=====La Simulation=====");
		System.out.println("");
		System.out.println("Enfin, la simulation creer les differents sports, equipes, membres etc, simule des matchs, gere les abonnements,");
		System.out.println("etc.");
		System.out.println("");
	}

	/**affiche quelques remarques sur l'emploi du temps
	*/
	public static void remarqueEDT(){
		System.out.println("Pour simplifier les choses, il n'y a que trois creneaux horaires pour les sports : ");
		System.out.println("\t10H - 12H");
		System.out.println("\t14H - 16H");
		System.out.println("\t16H - 18H");
		System.out.println("");
	}

	/**affiche quelques precisions sur les sports
	*/
	public static void remarqueSport(){
		System.out.println("Les membres du club ont entre 5 et 70 ans. Si une personne n'a pas un age 'convenable', une exception est levee.");
		System.out.println("Les equipes ne contiennent que des joueurs. Les eventuels remplacants ne sont pas pris en compte.");
		System.out.println("");
	}
}