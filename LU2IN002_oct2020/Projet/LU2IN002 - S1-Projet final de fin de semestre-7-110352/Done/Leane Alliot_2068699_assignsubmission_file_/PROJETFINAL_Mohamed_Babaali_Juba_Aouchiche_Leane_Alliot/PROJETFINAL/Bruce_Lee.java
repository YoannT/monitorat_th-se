public class Bruce_Lee extends Moderne{ //Combattant représentant l'art martial : Kung-Fu

	private String nom_art;//Nom de l'art martial pratiqué par le combattant
	private String nom;
	private int etoile; // Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales plus une technique)
	private int posx;//position du combattant sur la ligne
	private int posy;//position du combattant sur la colonne
	private int degat_att1;// Degat de l'attaque numero 1 du combattant
	private int degat_att2;
	private int degat_att3;
	private int pv ;// Point de vie du combattant

	
	public Bruce_Lee(String nom, int etoile, int pv,int posx, int posy){
		super(nom,etoile,pv,posx,posy);
		this.degat_att1=30;
		this.degat_att2=30;
		this.degat_att3=35;
	}


	public String toString(){
		return super.toString()+"Bruce Lee";
	}


	public String getArt_martial(){ // Retourne le nom de l'art martial pratiqué par le combattant
		return this.nom_art;
	}


	public String Attaque_spe(Fighter f){ // f désigne son adversaire, cette méthode permet de simuler des attaques et d'enlever des pv à l'adversaire
    	int i = (int)(Math.random()*2);
        switch (i){
        	case 0:
        	f.setPv(f.getPv()-degat_att1);
                return super.Attaque_spe(f)+"Bruce Lee attaque avec son Stamp Kick"; //le Stamp Kick: Un stomp est une frappe vers le bas avec le talon du pied depuis la position debout, et est généralement dirigée vers la tête ou le corps d'un adversaire abattu.
            case 1:
            f.setPv(f.getPv()-degat_att2);
                return super.Attaque_spe(f)+"Bruce Lee saute et utlise SideKick"; //le SideKick: Semblable au coup de pied avant, la puissance du coup de pied latéral est générée par les hanches et le tronc
            case 2:
            f.setPv(f.getPv()-degat_att3);
                return super.Attaque_spe(f)+"Bruce Lee se concentre avant d'assener un One-Inch Punch"; //le One-Inch Punch: Le one inch punch est une technique de coup de poing des arts martiaux chinois réalisée à très courte distance
         
        }
		return "l'attaque a échoué";
	}
 
}


