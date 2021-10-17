public class Teddy_Riner extends Moderne{ //Combattant représentant l'art martial : Judo


	private String nom_art;//Nom de l'art martial pratiqué par le combattant
	private String nom;
	private int etoile; // Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales plus une technique)
	private int posx;//position du combattant sur la ligne
	private int posy;//position du combattant sur la colonne
	private int degat_att;// Degat de l'attaque du combattant
	private int pv;// Point de vie du combattant

	public Teddy_Riner(String nom, int etoile, int pv,int posx, int posy){
		super(nom,etoile,pv,posx,posy);
		this.degat_att=30;

	}


	public String toString(){
		return super.toString()+"Teddy Riner";
	}

	public String getArt_martial(){ // Retourne le nom de l'art martial pratiqué par le combattant
		return this.nom_art;
	}
	
	public String Attaque_spe(Fighter f){ // f désigne son adversaire, cette méthode permet de simuler des attaques et d'enlever des pv à l'adversaire
		f.setPv(f.getPv()-degat_att);
		return super.Attaque_spe(f)+"Teddy Riner enclenche un Ippon à son adversaire à l'aide son corps massif";//Ippon:Retourne son adversaire et le fracasse contre le sol

	}
}
