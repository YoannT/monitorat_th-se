import java.lang.Math;

public class TestTerrain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 
		final int TAILLEY = 10;
		final int TAILLEX = 10;
				
		Terrain t = new Terrain(TAILLEY,TAILLEX);
		boolean plusRien = false;
		String[] r = new String[]{"Bois","Pierre","Fer","Charbon"};
		
		for(String str : r) {
			for(int i=0; i<4; i++) { 
				// On crée une ressource
				Ressource e = new Ressource(str,(int)(Math.random()*6+5));
				// et on la place sur le terrain
				int x, y;
				do {
					x = (int)(Math.random()*(TAILLEX+1));
					y = (int)(Math.random()*(TAILLEY+1));
				}while(!t.caseEstVide(y, x));//ne fonctionne pas
				t.setCase(y, x, e);
				e.setPosition(x, y);
			}
		}
		
		//Création de la ville
		Ville ville = new Ville((int)(Math.random()*(TAILLEX+1)), (int)(Math.random()*(TAILLEY+1)));
		
		//On simule tant qu'il y a encore des habitants, qu'il y a moins de 10 habitants, et tant qu'il y a encore des ressources sur la carte
		do{
			// Affichage du terrain avec les ressources ajoutées
			t.affiche();
			// Informations sur le terrain
			System.out.println("Informations sur le terrain:\n"+t);
			
			//On prend la météo à chaque boucle de simulation
			int temperature = Meteo.getTemp();
			boolean intemperies = Meteo.faitMauvais();
			
			System.out.println("Meteo du jour : "+Meteo.getMeteo(temperature, intemperies));
			
			//On simule le comportement de chaque habitant
			for(Humain h : ville.getHabitants()) {
				
				//Se déplacer ou rester en ville pour accueillir un nouvel habitant ou construire si possible
				boolean seDeplacer = Math.random()>.3;

				//Si il fait trop chaud, trop froid ou il pleut/grêle/neige/...

				if(seDeplacer && (temperature<=Meteo.TEMPFROID||temperature>=Meteo.TEMPCHAUD||intemperies)) {
					//L'habitant a un certaine chance de se déplacer..
					if(Math.random()*100<50+(ville.getNbRessource("Eau")+ville.getNbRessource("Electricite"))) {
						seDeplacer = true;

						//...et de mourir
						if(Math.random()*100>85+(ville.getNbRessource("Eau")+ville.getNbRessource("Electricite"))) {
							//Mort de l'habitant
							System.out.println(ville.removeHabitant(h)+" a voulu se deplacer, mais la meteo a eu raison de lui");
							continue;
						}


					}else {
						//ou de rester
						seDeplacer = false;
					}
				}
				
				
				
				if(!seDeplacer){

					//Acouille d'un nouvel habitant selon la chance
					Maison maisonLibre = ville.getMaisonLibre();
					if(maisonLibre!=null && (Math.random()*100<50+(ville.getNbRessource("Eau")+ville.getNbRessource("Electricite")))) {
						ville.addHabitant(h.clone());
						continue;
					}

					//Sinon, construction d'une centrale à charbon ou pompe à eau ou maison si possible
					if(ville.getNbRessource("Fer")>=4) {
						if(ville.getNbCentrales()<ville.getNbHabitants()/5+1) {
							ville.construireCentrale();
							continue;
						}else if(ville.getNbPompes()<ville.getNbHabitants()/5+1) {
							ville.construirePompe();
							continue;
						}
					}
					ville.construireMaison();

					//L'habitant n'a plus le temps de faire autre chose, on passe au suivant
					continue;
				}

				//Si l'habitant est parti, il cherche la ressource la plus proche à ramasser, va la chercher et la dépose en ville
				Ressource ressourceAChercher = h.plusProcheRessource(t);
				if(ressourceAChercher!=null) {
					h.seDeplacer(ressourceAChercher.getX(), ressourceAChercher.getY());
					h.setRessource(ressourceAChercher);
					h.seDeplacer(ville.getX(), ville.getY());
					h.getVille().addRessource(h.removeRessource());
				}else {
					plusRien=true;
				}

			}

			//Verifier qu'il reste des ressources sur la carte
			if(!plusRien) {
				plusRien = true;
				for(int l=t.nbLignes; l>=0 && plusRien; l--) {
					for(int c=t.nbColonnes; c>=0 && plusRien; c--) {
						if(!t.caseEstVide(l, c)) {
							plusRien = false;
						}
					}
				}
			}
			

			//On produit les ressources grâce au batiments
			ville.productionAll();
		
		}while(0<ville.getNbHabitants() && ville.getNbHabitants()<10 && !plusRien);
		
		// Affichage du terrain avec les ressources ajoutées
		t.affiche();
		// Informations sur le terrain
		System.out.println("Informations sur le terrain:\n"+t);
		

		if(ville.getNbHabitants()<1)
			System.out.println("Il n'y a plus d'habitants dans la ville");
		else if(ville.getNbHabitants()>10)
			System.out.println("Il y a plus de 10 habitants dans la ville");
		if(plusRien)
			System.out.println("Il n'y a plus de ressources");

		//Affichage des particularités de la ville
		System.out.println("Cette ville abrite "+ville.getNbHabitants()+" habitants");
		System.out.println(ville);
		System.out.println(ville.getAllRessource());
	}

}
