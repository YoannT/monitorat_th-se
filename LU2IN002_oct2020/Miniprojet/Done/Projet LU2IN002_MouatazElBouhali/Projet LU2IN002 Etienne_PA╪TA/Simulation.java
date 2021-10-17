import java.util.Random;
public class Simulation{
	private Terrain t;
	private Fruit[] tabFruit;
	private Agriculteur[] tabAgr;
	private int n; // nombres d'agents dans le tableau qui vont travailler
	private static Graine grain;
	private static int comptRecoltes = 0;
	private static int nbrGraine = 0;
	private static int Graine_Plantee = 0;
	//m -> nbre de ressources pas la quantité d'une même ressource
	//n -> nbre d'agents effectuant la recolte
	public Simulation(int m, int n, Fruit[] tab1, Agriculteur[] tab2, Terrain ter){
		t = ter;
		tabFruit = tab1;
		tabAgr = tab2;
		this.n=n;
		if(m>tab1.length){
			System.out.println("Pas assez de ressources !");
			System.exit(0);
		}
		for(int i=0;i<m;i++){
			for (int j=0;j<tabFruit[i].getQuantite();j++){
				int ligne=(int)(Math.random()*t.nbLignes);
				int colonne=(int)(Math.random()*t.nbColonnes);

				if(t.caseEstVide(ligne,colonne)){
					if(t.setCase( ligne, colonne, tabFruit[i])){
						System.out.println("Ajout de "+tabFruit[i]);
						comptRecoltes++;
					}
					else
						System.out.println("Probleme de coordonn\u00e9e !");
				}
			}
		}
	}

	//Simule un ramassage de graines par les agriculteurs
	public void recolte(){
		Graine grain = new Graine("Graine",1,t);
		int k,l;
		if(n>tabAgr.length){
			System.out.println("Pas assez d'agents pour travailler !");
			System.exit(0);
		}
		for (int i = 0; i < n; i++){
			//On deplace l'agriculteur a un endroit aléatoirement
			k = (int)(Math.random()*(t.nbColonnes));
			l = (int)(Math.random()*(t.nbLignes));
			System.out.println(tabAgr[i].getNom()+" se deplace en "+tabAgr[i].seDeplacer(l,k));

			//on verifie s'il y a un fruit sur la case
			if (t.caseEstVide(k,l) == false && t.getCase(k,l) instanceof Fruit){
				comptRecoltes++;
				nbrGraine++;
				Ressource Case = t.videCase(k,l);
				t.videCase(k,l);
				System.out.println(tabAgr[i].getNom()+" recolte un fruit et extrait une graine");
				System.out.println("La case contenait : "+Case);
			}

			//sinon on verifie si on a encore des graines pour les planter
			else if ((t.caseEstVide(k,l) == true )&& (nbrGraine > 0) && t.sontValides(k,l)){
				//on clone la graine à plantée
				t.setCase(k,l,new Graine());
				nbrGraine--;
				grain.setQuantite(nbrGraine);
				System.out.println(tabAgr[i].getNom()+" plante une petite graine");
				Graine_Plantee++;
			}

			//On essaye de voir si des graines clonées ont poussées aléatoirement
			grain.clone().aleaPousse((int)(Math.random()*t.nbLignes),(int)(Math.random()*t.nbColonnes),tabFruit[(int)(Math.random()*tabFruit.length-1)]);

			// Vente de Fruit
			if ((Math.random()>0.8) && (comptRecoltes>0)){
				Gestion.VenteDeFruit();
				comptRecoltes--;
			}
			//Achat de nouvelles graines
			if(comptRecoltes==0 && Math.random()<0.2){
				if(Gestion.achatGrain())
					nbrGraine++;
			}
		}
	}
	public String toString(){
		return "Le panier de recolte contient : "+comptRecoltes+" fruit(s) et il reste encore " +nbrGraine+ " graine(s) disponible";
	}
	public String end(){
		String s = "";
		for (int i=0;i<n ;i++ ){
			s+=tabAgr[i].getNom()+", ";
			if (n==1){
				return s+"a plant\u00e9 "+Graine_Plantee+" nouvelle(s) graine(s)";
			}
		}
		return s+"ont plant\u00e9s "+Graine_Plantee+" nouvelle(s) graine(s)";
	}
}
