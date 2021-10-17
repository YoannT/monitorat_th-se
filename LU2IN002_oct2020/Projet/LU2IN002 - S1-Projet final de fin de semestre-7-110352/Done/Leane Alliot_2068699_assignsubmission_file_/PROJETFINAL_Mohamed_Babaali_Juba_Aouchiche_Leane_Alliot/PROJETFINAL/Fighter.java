public abstract class Fighter extends Personne {// classe dont héritent tous les combattants

	

	protected int posx;//position du combattant sur la ligne
	protected int posy;//position du combattant sur la colonne

	protected String nom;
	protected int etoile; // Puisance du combattant allant de 1 à 5 étoiles (1 etoile = 0 attaque spéciale, 2 etoiles = 1 attaques spéciales, 3 etoiles = 2 attaques spéciales, 4 etoiles = 3 attaques spéciales, 5 etoiles = 3 attaques spéciales plus une technique)
	protected int pv; // Point de vie du combattant


	public Fighter(String nom, int etoile, int pv,int posx, int posy){
		super(posx,posy,nom);
		this.etoile=etoile;
		this.pv=pv;
		
		
	}



	public String toString(){
		return "";
	}


	public void action(){
		System.out.println("Je suis sur le ring");
	}



	public String SeDeplacer(){ //Méthode qui permet le déplacement du fighter dans l'aréne seulement dans la zone de combat
        
           this.posx=(int)(Math.random()*3)+1; //les Fighter peuvent seulement se deplacer sur le ring et non dans toute l'arene
           this.posy=(int)(Math.random()*2)+1;
            return "Il se déplace sur la case ("+posx+","+posy+") ";
        
    }

    public int get_posx(){ //Méthode permettant d'obtenir la position du fighter dans l'aréne coté ligne
    	return posx;
    }

    public int get_posy(){ //Méthode permettant d'obtenir la position du fighter dans l'aréne coté colonne
    	return posy;
    }

    public int getPv(){ //Méthode permettant d'obtenir les pv du fighter
		return pv;
	}

	public boolean estKO() {//Méthode qui return true si un combattant est mis K.O c'est à dire que ses pv sont égales à 0
        return pv <= 0;
    }


	public void setPv(int newpv){// Méthode permettant une mise à jour des PV de chaque Fighter
		this.pv = newpv;

	}

    public void Attaque(int degat_attaque){ //Méthode qui reduit les pv du fighter après avoir pris un coup de la part de son adversaire
    	pv=(this.pv)-degat_attaque;
    	double i=Math.random(); // ici on lance un Math.random pour, selon les probabilités, avoir certains commentaire sur la puissance d'une attaque lorsque celle-ci est lancé
    	if(i<0.3){
    		System.out.println("OUUUIIIIE! -"+degat_attaque+" pv ça doit faire mal");
    	}
		else {
    		if(0.4<= i && i<=0.6){
    			System.out.println("Ca c'était un coup bien placé");
			}
    	}

    }
   
    public abstract String Attaque_spe(Fighter f);

    public static boolean Esquive(){ //Méthode permettant de savoir si le fighter à réussi à esquiver l'attaque de son adversaire
    	double i=Math.random();
    	if(i>0.5){
    		return true;
    	}
    	return false;
    }

	public static void pv_negatif(Fighter f1) throws PV_negatif{
		if (f1.getPv()<0){
			f1.setPv(0);
			throw new PV_negatif("les pv ne peuvent pas etre inférieur à 0 !");
			
		}
		else {
			System.out.println();
		}
	}
	
}
