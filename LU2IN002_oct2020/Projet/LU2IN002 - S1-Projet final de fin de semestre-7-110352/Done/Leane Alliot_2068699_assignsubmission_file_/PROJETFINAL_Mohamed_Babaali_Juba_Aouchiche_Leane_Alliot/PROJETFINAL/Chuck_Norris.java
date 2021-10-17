public class Chuck_Norris extends Moderne{//Combattant représentant l'art martial : Karaté (avant d'être acteur Chuck Norris était connu pour sa maîtrise de différents arts martiaux dont le karaté)

	
	private String nom_art;//Nom de l'art martial pratiqué par le combattant
	private String nom;
	private int etoile; // Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales plus une technique)
	private int posx;//position du combattant sur la ligne
	private int posy;//position du combattant sur la colonne
	private int degat_att1;// Degat de l'attaque numero 1 du combattant
	private int degat_att2;
	private int pv ;// Point de vie du combattant

	
		
	public Chuck_Norris(String nom, int etoile, int pv,int posx, int posy){
		super(nom,etoile,pv,posx,posy);
		degat_att1=25;
		degat_att2=30;
	}


	public String toString(){
		return super.toString()+"Chuck Norris";
	}

	public String getArt_martial(){ // Retourne le nom de l'art martial pratiqué par le combattant
		return this.nom_art;
	}

	public String Attaque_spe(Fighter f){ // f désigne son adversaire, cette méthode permet de simuler des attaques et d'enlever des pv à l'adversaire
    	int i = (int)(Math.random()*1);
        switch (i){
        	case 0:
        	f.setPv(f.getPv()-degat_att1);
                return super.Attaque_spe(f)+"Chuck Norris saute et utilise son attaque Chun Kuk Do"; //Mouvements d'attaque et de défense tiré du taekwondo, du judo et même du Jeet Kun Do qui consiste à utiliser le pied en air tout en sautant.
            case 1:
            f.setPv(f.getPv()-degat_att2);
                return super.Attaque_spe(f)+"Chuck Norris se concentre et met en place son Chuck Norris System"; //Style avec une base traditionnelle profondément enracinée qui lui permet une concentration extreme pour des coups plus puissants.
            
        }
		return super.Attaque_spe(f)+"l'attaque a échoué";
    }
	
}

