public class Arene{//Terrain où se dérouleront les combats
	
	private final Personne[][] arene; 
	

	private int nb_colonne;
	private int nb_ligne;

	public Arene(int nb_ligne,int nb_colonne){
		this.nb_ligne = nb_ligne;
		this.nb_colonne = nb_colonne;
		this.arene = new Personne[this.nb_ligne][this.nb_colonne];
		

	}
	
	public boolean sontValides(int i, int j) { // Méthode permettant de savoir si la case choisie est bien dans l'arene
        return i >= 0 && i < this.nb_ligne && j >= 0 && j < this.nb_colonne;
    }


	public Personne getcase(int ligne, int colonne){ //Méthode permettant d'obtenir le contenu d'une case choisi
		return arene[ligne][colonne];

	}


	public boolean case_est_vide(int ligne, int colonne){ //Méthode permettant de savoir si la case demandée est vide

		return arene[ligne][colonne]==null;

	}
	
	public boolean setCase(int i, int j, Personne p) { // Méthode permettant de placer une personne sur l'arene
        if (this.sontValides(i, j)) {
            if (this.arene[i][j] != null) {
                this.arene[i][j].Positioninit();
            }

            this.arene[i][j] = p;
            p.setPosition(i, j);
            return true;
        } else {
            return false;
        }
    }
    
    public Personne actualiser(int i, int j) { //Méthode qui permet d'actualiser la position des combattant dans l'arene
        if (this.sontValides(i,j) && this.arene[i][j] != null) {
            Personne p = this.arene[i][j];
            p.Positioninit();
            this.arene[i][j] = null;
            return p;
        } else {
            return null;
        }
    }



	
	
	public void affichage() { // construction du visuel du tableau pour l'afficher
        String s1 = "";
        String s2 = ":"; // caractères permettant de délimiter les cases
        String s3 = "";
		String s4= "";
        String s5 = "";
        String s6 = "";
        String s7 = ":";
        int i;
				
        for(i= 0; i < 20; i++) {
            s3 = s3 + "-";
        }

        for(i = 0; i < this.nb_colonne; i++) {
            s2 = s2 + s3 + ":";
        }
		
		for(i= 0; i < 20; i++) {
            s5 = s5 + " ";
        }

        for(i= 0; i < nb_colonne-2; i++) {
            s6 = s6 + s5;
        }

        for(i= 0; i < nb_colonne-3; i++) {
            s6 = s6 + " ";
        }

        s4 = s7 + s3 + s7 + s6 + s7 + s3 + s7;
        s4 = s4 + "\n";
       
        for(i= 0; i < 20; i++) {
            s3 = s3 + " ";
        }
        s2 = s2 + "\n";
        s1 = s2;
		
		for(int j = 0; j < this.nb_colonne; j++) {
                if (this.arene[0][j] == null) {
                    s1 = s1 + " " + String.format("%-20s", " "); // format des cases
                } else {
                    s1 = s1 + " " + this.nb_lettres(this.arene[0][j].nom); // affichage du nom de la personne présente sur la case
                }
            }
		
		s1 = s1 + " \n" + s2;

        for(i = 1; i < this.nb_ligne-2; i++) {
            for(int j = 0; j < this.nb_colonne; j++) {
                if (this.arene[i][j] == null) {
                    s1 = s1 + " " + String.format("%-20s", " "); // format des cases
                } else {
                    s1 = s1 + " " + this.nb_lettres(this.arene[i][j].nom); // affichage du nom de la personne présente sur la case
                }
            }

            s1 = s1 + " \n" + s4;
        }
		for(int k=0; k<2 ;k++) {
			 for(int j = 0; j < this.nb_colonne; j++) {
                if (this.arene[this.nb_ligne-2+k][j] == null) {
                    s1 = s1 + " " + String.format("%-20s", " "); // format des cases
                } else {
                    s1 = s1 + " " + this.nb_lettres(this.arene[this.nb_ligne-2+k][j].nom); // affichage du nom de la personne présente sur la case
                }
            }
		
		s1 = s1 + " \n" + s2;
		 }

        System.out.println(s1);
    }


 private String nb_lettres(String s1) { // méthode permettant l'affichage d'un nombre de lettres précis du nom de la personne
        String s2 = String.format("%-20s", s1);
        return s2.substring(0, 20);
    }

}
