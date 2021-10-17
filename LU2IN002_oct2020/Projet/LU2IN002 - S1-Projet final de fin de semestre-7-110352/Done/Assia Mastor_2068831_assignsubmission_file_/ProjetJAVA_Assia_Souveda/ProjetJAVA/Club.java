import java.util.*;
public class Club {
	private  ArrayList< Personne > membrejoueur=new ArrayList<Personne>();
	private ArrayList< Arbitre > membrearbitre=new ArrayList<Arbitre>();


	private static  int nbMaxJoueur=30;
	private static int nbMaxArbitre=6;
	private static String nomduclub="Queen club";


	public Club( Club c){

		this.nbMaxJoueur= c.nbMaxJoueur;
		this. nbMaxArbitre=c.nbMaxArbitre;
		this.nomduclub= c. nomduclub;

	}


	public Club(){

		this.nbMaxJoueur= 200;
		this. nbMaxArbitre=30;


	}


	public static String getnom(){
		return nomduclub;
}



	public void ajouterMembreJoueur(Joueur p) throws Exceptions{

		if(p.age<15) {
			throw new Exceptions("l'age doit etre supérieur à 15 ans, il ne peut donc pas etre inscrit ");
		}
	
		if (membrejoueur.size()<nbMaxJoueur) {
			membrejoueur.add(p);
		}

		else {
			System.out.println("Il n'y a plus de place !");
		}
	

	}



	public void ajouterMembreArbitre(Arbitre p) throws Exceptions{

		if(p.age<15) {
			throw new Exceptions("l'age doit etre supérieur à 15 ans, il ne peut donc pas etre inscrit");
		}
	
		if (membrearbitre.size()<nbMaxArbitre) {
			membrearbitre.add(p);	
		}

		else {
			System.out.println("Il n'y a plus de place !");
		}
	

	}



}



