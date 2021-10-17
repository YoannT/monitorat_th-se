import java.util.Random;
/**
 * @author Nawelle SINGH
 * Cette classe gere la simulation avec les deplacements, les combats et les transformations de materiaux en manipulant les listes d'aventuriers, de ressources et de monstres.
 */
public class Simulation{
	public Terrain t;
	private Ressource[] ress;
	private Aventurier[] adv;
	private Mob[] mob;
	private Random rd = new Random();
	
	/**
	 * Constructeur qui initialise un terrain de la taille maximale, un tableau de ressources, un tableau de monstre et un tableau d'aventurier
	 * @param m : nombre de ressources / monstres sur le terrain
	 * @param n : nombre d'aventuriers sur le terrain
	 */
	public Simulation(int m, int n){
		
		t = new Terrain();
		ress = new Ressource[m];
		mob = new Mob[m];
		adv = new Aventurier[n];
		
		Statistique.nbRessourceEtMob_Debut = m;
		Statistique.nbMob_Fin = m;
		
		System.out.println("... Initialisation des ressources et des mobs sur le terrain, les mobs sont associés à chaque ressource ...");
		for(int i = 0 ; i < ress.length ; i++){
			//Association d'une ressource a une case vide du tableau
			int x = rd.nextInt(t.NBLIGNESMAX);
			int y = rd.nextInt(t.NBCOLONNESMAX);
			while(!t.caseEstVide(x,y) || ((x==0)&&(y==0))){
				x = rd.nextInt(t.NBLIGNESMAX);
				y = rd.nextInt(t.NBCOLONNESMAX);
			}
			//Ajout dans le tableau d'une ressource avec une quantite aleatoire
			ress[i] = new Ressource("Minerai",rd.nextInt(3)+1);
			Statistique.nbRessourceTotal += ress[i].getQuantite();
			t.setCase(x,y,ress[i]);

			//Association d'un monstre avec une ressource
			mob[i] = new Mob();
			mob[i].seDeplacer(x,y);
		}
		//Affichage des ressources et des monstres
		for(int i = 0 ; i < ress.length ; i++){
			System.out.println(ress[i]);
		}
		for(int i = 0 ; i < mob.length ; i++){
			System.out.println(mob[i]);
		}
		
		System.out.println("... Initialisation des aventuriers au camp de position:[0,0] ...");
		for(int i =0 ; i < adv.length ; i++){
			adv[i] = new Aventurier();
			System.out.println(adv[i]);
		}
		
		t.affiche();
	}
	/**
	 * Permet de deplacer le tableau d'aventurier de facon aleatoire, sauf si l'aventurier est dans un cas d'urgence ou si son inventaire est rempli : dans ce cas il va se diriger vers le camp [0,0]
	 */
	public void deplacement(){
		/*Aventurier se deplace de facon aleatoire, sauf s'il est en etat d'urgence : il part alors vers le camp en position [0,0] ou alors lorsque son inventaire est plein*/
		for(int i = 0 ; i < adv.length ; i++){
			
			System.out.print(">>> Aventurier" + adv[i].getID() + " " + adv[i].getPosition() + " -> ");
			
			if(adv[i].alerte() || adv[i].getNbRessource()==5){ //Si alerte ou inventaire plein
				if (adv[i].getPosX() == 0){ //se deplace vers le haut
					adv[i].seDeplacer(adv[i].getPosX(), adv[i].getPosY()-1);
					System.out.print(adv[i].getPosition() + "\n");
				}
				else{ //se deplace vers la gauche
					adv[i].seDeplacer(adv[i].getPosX()-1, adv[i].getPosY());
					System.out.print(adv[i].getPosition() + "\n");
				}
			}
			else{
				int x = adv[i].getPosX();
				int y = adv[i].getPosY();
				
				if ((x == 0)&&(y == 0)){ //extremite superieure gauche -> deplacement vers droite et/ou gauche
					adv[i].seDeplacer(x+(rd.nextInt(2)),y+(rd.nextInt(2)));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				if((x == t.NBLIGNESMAX-1)&&(y==t.NBCOLONNESMAX-1)){ //extremite inferieure droite -> deplacement vers gauche et/ou haut
					adv[i].seDeplacer(x-rd.nextInt(2),y-rd.nextInt(2));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				if((x == 0)&&(y == t.NBCOLONNESMAX-1)){ //extremite superieure droite -> deplacement vers gauche et/ou bas
					adv[i].seDeplacer(x+rd.nextInt(2),y-rd.nextInt(2));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				if((x == t.NBLIGNESMAX-1)&&(y == 0)){ //extremite inferieur gauche -> deplacement vers gauche et/ou haut
					adv[i].seDeplacer(x-rd.nextInt(2),y+rd.nextInt(2));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				if (x == 0){ //deplacement vers bas 
					adv[i].seDeplacer(x+(rd.nextInt(2)),y+(rd.nextInt(3)-1));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				if (y == 0){ //deplacement vers droite
					adv[i].seDeplacer(x+(rd.nextInt(3)-1),y+(rd.nextInt(2)));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				if (x == t.NBLIGNESMAX-1){ //deplacement vers haut
					adv[i].seDeplacer(x-rd.nextInt(2),y+(rd.nextInt(3)-1));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				if (y == t.NBCOLONNESMAX-1){ //deplacement vers gauche
					adv[i].seDeplacer(x+(rd.nextInt(3)-1),y-rd.nextInt(2));
					System.out.print(adv[i].getPosition() + "\n");
					continue;
				}
				adv[i].seDeplacer(x+(rd.nextInt(3)-1),y+(rd.nextInt(3)-1)); //deplacement aleatoire
				System.out.print(adv[i].getPosition() + "\n");
			}
			
		}
	}
	/**
	 * Permet de gerer les rencontres entre une liste d'aventuriers et une liste de monstres. Si l'aventurier gagne le combat, il perd peu de PV et il remporte la ressource associee et la met dans son inventaire. S'il perd, il perd des PV.
	 */
	public void rencontre(){
		/*Aventurier rencontre un Mob et ils se battent. Si l'aventurier gagne, alors il recupere les mineraux que le mob gardait. Si son inventaire est plein, il laisse le minerai la ou il l'a trouve.*/
		for(int j = 0 ; j < adv.length ; j++){
			
			for (int i = 0 ; i < mob.length ; i++){
				
				if((mob[i].getPosX()==adv[j].getPosX()) && (mob[i].getPosY()==adv[j].getPosY())){
					
					if(adv[j].engageCombat(mob[i])){
						if(adv[j].aGagne(mob[i])){
							Statistique.nbMob_Fin -= 1;
							if(adv[j].ajoutRessource(ress[i])){
								System.out.println("++ " + ress[i].type + ress[i].ident + " a ete ramasse par Aventurier" + adv[j].getID() + "\n" + adv[j].toString());
								Statistique.nbRessourcesRamassees += ress[i].getQuantite();
								Ressource poubelle = t.videCase(ress[i].getX(),ress[i].getY());
								ress[i].initialisePosition();
								Statistique.nbCasesVidees += 1;
								break;
							}
							else{
								System.out.println("Il n'y a plus de place dans l'inventaire !");
							}
						}
						break;
					}
					break;
				}
			}
		}
	}
	/**
	 * Methode utilisee dans le cas ou un aventurier a vaincu un monstre mais que son inventaire etait plein. Permet a d'autres aventuriers de ramasser le butin egare.
	 */
	public void ramassage(){
		/*S'il n'y a pas de Mob, alors l'aventurier ramasse le minerai, sauf si son inventaire est plein*/
		for(int i = 0 ; i < adv.length ; i++){
			for(int j = 0 ; j < ress.length ; j++){
				if(((adv[i].getPosX() == ress[j].getX()) && (adv[i].getPosY() == ress[j].getY())) && ((adv[i].getPosX() != mob[j].getPosX())||(adv[i].getPosY() != mob[j].getPosY()))){
					if(adv[i].ajoutRessource(ress[j])){
						System.out.println("++ " + ress[j].type + ress[j].ident + " a ete ramasse par Aventurier" + adv[i].getID() + "\n" + adv[i].toString());
						Statistique.nbRessourcesRamassees += ress[j].getQuantite();
						Ressource poubelle = t.videCase(ress[j].getX(),ress[j].getY());
						ress[j].initialisePosition();
						Statistique.nbCasesVidees += 1;
						break;
					}
					else{
						System.out.println("Il n'y a plus de place dans l'inventaire !");
					}
				}
			}
		}
	}
	/**
	 * Permet de gerer le camp. Des qu'un aventurier arrive a cette position, alors il retrouve ses PV et depose toutes ses ressources pour vider son inventaire. Il y a egalement transformation des ressources en lingot.
	 */
	public void camp(){
		/*l'aventurier voit ses PV remontes a 100 et depose les mineraux en vidant son inventaire. Le camp s'occupe de transformer les mineraux en lingot de fer.*/
		int cpt = 0;
		for(int i = 0 ; i < adv.length ; i++){
			if((adv[i].getPosX()==0)&&(adv[i].getPosY()==0)){
				System.out.println("&& Guerison de Aventurier" + adv[i].getID());
				adv[i].energie = 100;
				cpt += adv[i].getNbRessource();
				adv[i].videInventaire();
			}
		}
		
		while (cpt > 0){
			System.out.println("@@ Creation d'un lingot de fer.");
			Statistique.nbRessourcesProduites += 1;
			cpt--;
		}
	}
	/**
	 * Permet d'afficher l'etat des aventuriers avec leur id, leur PV et leur inventaire.
	 */
	public void afficher(){
		System.out.println("~~~~~~ Affichage graphique de la situation ~~~~~~");
		for(int i = 0 ; i < adv.length ; i++){
			System.out.println(adv[i]);
		}
	}
	
}