public class Madara_Uchiwa extends Legende{ //Combattant/ninja légendaire dans Naruto ( Art martial : Ninjutsu)


	private String nom_art;//Nom de l'art martial pratiqué par le combattant
	private String nom;
	private int etoile;// Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales plus une technique)
	private int posx;//position du combattant sur la ligne
	private int posy;//position du combattant sur la colonne
	private int degat_att1;// Degat de l'attaque numero 1 du combattant
	private int degat_att2;
	private int degat_att3;
	private int pv ;// Point de vie du combattant


	public Madara_Uchiwa(String nom, int etoile, int pv,int posx, int posy){
		super(nom,etoile,pv,posx,posy);
		degat_att1=40;
		degat_att2=35;
		degat_att3=30;
	}


	public String toString(){
		return super.toString()+"Madara Uchiwa";
	}

	public String getArt_martial(){ // Retourne le nom de l'art martial pratiqué par le combattant
		return this.nom_art;
	}

	public String Attaque_spe(Fighter f){ // f désigne son adversaire, cette méthode permet de simuler des attaques et d'enlever des pv à l'adversaire
    	int i = (int)(Math.random()*2);
        switch (i){
        	case 0:
        	f.setPv(f.getPv()-degat_att1);
                return super.Attaque_spe(f)+"Madara plonge son adversaire dans un Genjutsu : Izanagi et lui fais souffrir le martyre"; //Izanagi: Genjutsu(technique d'illusion) qui fait souffrir son adversaire
            case 1:
           	f.setPv(f.getPv()-degat_att2);
                return super.Attaque_spe(f)+"Madara lance un Katon Embrasement Suprême"; //Immense mur de flamme qui ne laisse aucune chance à son adversaire
            case 2:
            f.setPv(f.getPv()-degat_att3);
                return super.Attaque_spe(f)+"Madara développe son oeil et devient un Mangekyo Sharingan et asséne de coup son adversaire"; //Mangekyo Sharingan: Dévelopement de l'oeil du combattant qui lui permet d'assenir des coups précis qui touchent les points vitaux de l'adversaire
         
        }
		return super.Attaque_spe(f)+"l'attaque a échoué";
    }

	public void technique(){ // Madara possède une technique car il hérite de Legende
		System.out.println("Madara fais apparaitre Susano et tranche son adversaire"); //Susano: Fais apparaitre une gigantesque armure munit d'une énorme épée capable de tout trancher sur son passage
	}				 

}
