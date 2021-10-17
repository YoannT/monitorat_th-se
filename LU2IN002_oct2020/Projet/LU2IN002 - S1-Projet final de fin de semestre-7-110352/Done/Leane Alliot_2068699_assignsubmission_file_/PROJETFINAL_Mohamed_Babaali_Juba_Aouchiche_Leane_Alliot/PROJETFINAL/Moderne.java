public class Moderne extends Fighter{ //Moderne désigne un combattant humain connu pour sa maitrise des arts martiaux
	protected String nom;
	protected int etoile; // Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales plus une technique)
	protected int pv; // Point de vie du combattant
	protected int posx;//position du combattant sur la ligne
	protected int posy;//position du combattant sur la colonne

	public Moderne(String nom, int etoile, int pv,int posx, int posy){
		super(nom,etoile,pv,posx,posy);

	}
	public String toString(){
		return super.toString()+""; 
	}

	@Override
	public String Attaque_spe(Fighter f){ // Méthode étant abstract dans Fighter
		return " ";
	}

}
