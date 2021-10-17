public class Hercule extends Legende{ //Héros de la mythologie greco-romaine représentant la force à l'état pur. Art martial : Lutte greco-romaine


	private String nom_art;//Nom de l'art martial pratiqué par le combattant
	private String nom;
	private int etoile; // Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales + 1 technique)
	private int posx;//position du combattant sur la ligne
	private int posy;//position du combattant sur la colonne
	private int pv;//Etant donné que Hercule posséde une Technique qui lui permet de se régenerer on lui fixe une limite de pv à ne pas dépasser pour ne pas avoir la possibilité d'avoir des pv à "l'infini" 
	private int degat_att1;// Degat de l'attaque numero 1 du combattant
	private int degat_att2;
	private int degat_att3;


	public Hercule(String nom, int etoile, int pv,int posx, int posy){
		super(nom,etoile,pv,posx,posy);
		degat_att1=30;
		degat_att2=40;
		degat_att3=40;
	}


	public String toString(){
		return super.toString()+"Hercule";
	}

	public String getArt_martial(){ // Retourne le nom de l'art martial pratiqué par le combattant
		return this.nom_art;
	}


	public String Attaque_spe(Fighter f){ // f désigne son adversaire, cette méthode permet de simuler des attaques et d'enlever des pv à l'adversaire
    	int i = (int)(Math.random()*2);
        switch (i){
        	case 0:
        	f.setPv(f.getPv()-degat_att1);
                return super.Attaque_spe(f)+"Hercule charge son poing avec sa Force du lion"; //coup de poing dévastateur
            case 1:
            f.setPv(f.getPv()-degat_att2);
                return super.Attaque_spe(f)+"Hercule fait appel à son père Zeus avec son Pouvoir des Dieux pour envoyer un éclair sur son adversaire"; //Zeus(son père) envoie un éclair sur l'adversaire
            case 2:
            f.setPv(f.getPv()-degat_att3);
                return super.Attaque_spe(f)+"Les coups de Hercule deviennent de plus en plus puissants grace aux 12 travaux"; //Durcicement du corps de Hercule grace à son dur entrainement
         
        }
		return super.Attaque_spe(f)+"l'attaque a échoué";
    }

	public void technique(){ // Hercule possède une technique car il hérite de Legende
		System.out.println("Hercule durcit son corps grace aux 12 travaux");//Les 12 travaux: -5 de dégat pour chaque attaque de l'adversaire (utilisable 1 fois). Les 12 travaux ont été tellement éprouvant que son corps s'est endurcis
	}				
	
}
