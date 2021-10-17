public class Mike_Tyson extends Moderne{ //Combattant représentant l'art martial : Boxe

	private String nom_art;//Nom de l'art martial pratiqué par le combattant
	private String nom;
	private int etoile; // Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales plus une technique)
	private int posx;//position du combattant sur la ligne
	private int posy;//position du combattant sur la colonne
	private int degat_att1;// Degat de l'attaque numero 1 du combattant
	private int degat_att2;
	private int pv ;// Point de vie du combattant


	public Mike_Tyson(String nom, int etoile, int pv,int posx, int posy){
		super(nom,etoile,pv,posx,posy);
		degat_att1=20;
		degat_att2=40;
	}
		
	

	public String toString(){
		return super.toString()+"Mike Tyson";
	}	


	public String getArt_martial(){ // Retourne le nom de l'art martial pratiqué par le combattant
		return this.nom_art;
	}
	
	public String Attaque_spe(Fighter f){ // f désigne son adversaire, cette méthode permet de simuler des attaques et d'enlever des pv à l'adversaire
    	int i = (int)(Math.random()*1);
        switch (i){
        	case 0:
        	f.setPv(f.getPv()-degat_att1);
                return super.Attaque_spe(f)+"Mike Tyson se rapproche de son adversaire et lui arrache l'oreille avec sa célébre Morsure de l'oreille"; //Arrache un morceau d'oreille de son adversaire (Triche qu'il a réellement commis lors d'un combat)
            case 1:
            f.setPv(f.getPv()-degat_att2);
                return super.Attaque_spe(f)+"Mike Tyson arme son poing et déclenche un Iron Mike"; //frappe explosive de Tyson était en grande partie due au fait de s'accroupir juste avant de lancer un crochet ou un uppercut: cela permettait au «ressort» de ses jambes d'ajouter de la puissance au coup de poing.
            
        }
		return super.Attaque_spe(f)+"l'attaque a échoué";
    }
	
}
