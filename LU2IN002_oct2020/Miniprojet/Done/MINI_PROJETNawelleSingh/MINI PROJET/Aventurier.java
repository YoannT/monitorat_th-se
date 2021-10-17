/**
 * @author Nawelle SINGH
 * Cette classe permet de gerer un aventurier qui possede un identifiant id, des points de vie et un inventaire, modelise par un tableau fixe.
 */

public class Aventurier extends Agent{
	/**
	 * Attributs correspondants à son id, à ses PV et à son inventaire limité à 5.
	 */
	private int id;
	private static int cpt = 1;
	protected int energie;
	private Ressource[] inventaire = new Ressource[5];
	
	/**
	 * Constructeur standard ou la position de l'aventurier est [0,0] (correspondant au camp) où l'id est donne par un compteur statique et l'energie est initialisee a 100.
	 */
	public Aventurier(){
		super(0,0);
		id = cpt;
		cpt++;
		energie = 100;
	}
	/**
	 * Constructeur standard ou la position est donnee par le clien via les variables posX et posY et où l'id est donne par un compteur statique et l'energie est initialisee a 100.
	 * @param posX : coordonnee-ligne de l'aventurier
	 * @param posY : coordonnee-colonne de l'aventurier
	 */
	public Aventurier(int posX, int posY){
		super(posX,posY);
		id = cpt;
		cpt++;
		energie = 100;
	}
	/**
	 * Retourne l'id de l'aventurier
	 * @return rend l'id de l'aventurier
	 */
	public int getID(){
		return id;
	}
	/**
	 * Retourne l'energie de l'aventurier
	 * @return rend l'energie de l'aventurier
	 */
	public int getEnergie(){
		return energie;
	}
	/**
	 * Retourne le nombre de ressource que possede l'aventurier dans son inventaire
	 * @return rend le nombre de ressource que possede l'aventurier dans son inventaire
	 */
	public int getNbRessource(){
		int cpt = 0;
		for (int i = 0 ; i<inventaire.length ; i++){
			if (inventaire[i] != null){
				cpt +=1;
			}
		}
		return cpt;
	}
	/**
	 * Permet de rendre un element de l'inventaire via i qui est l'index du tableau
	 * @param i : index de la ressouce dans l'inventaire
	 * @return rend la ressource qui se trouve a la place i dans l'inventaire
	 */
	public Ressource getInventaire(int i){
		return inventaire[i];
	}
	/**
	 * Permet d'ajouter une ressource dans l'inventaire.
	 * @param ress : ressource que l'on souhaite ajouter dans l'inventaire
	 * @return rend le boolean true si l'ajout a ete fait, et false si l'ajout n'a pas pu se faire
	 */
	public boolean ajoutRessource(Ressource ress){
		for (int i = 0; i < inventaire.length ; i++){
			if (inventaire[i] == null){
				inventaire[i] = ress;
				return true;
			}
		}
		Statistique.nbInventaireRempli += 1;
		return false;
	}
	/**
	 * Permet de vider l'inventaire.
	 */
	public void videInventaire(){
		for (int i = 0; i< inventaire.length ; i++){
			if (inventaire[i]!=null){
				inventaire[i] = null;
			}
		}
	}

	/**
	 * @return rend un String de la forme **Aventurier [id] -- PV: [energie] - position [x,y] - inventaire: [tableau des ressources]
	 */
	public String toString(){
		String s = "** Aventurier" + id + " -- PV: "+ energie + " - position:"+ super.toString() + " - inventaire: ";
		if (inventaire[0]==null){
			return s + "rien";
		}
		
		s = s + "\n";
		for (int i = 0; i<inventaire.length; i++){
			s = s + "* ---" + inventaire[i] + "\n";
		}
		
		return s;
	}
	/**
	 * Permet de retourner un String sur la position de l'aventurier
	 * @return un String de la forme [x,y]
	 */
	public String getPosition(){
		return super.toString();
	}
	
	
	//Methodes pour les combats
	/**
	 * Permet de savoir si le heros est en danger de mort
	 * @return rend un boolean true si l'aventurier a moins de 30 PV sinon false
	 */
	public boolean alerte(){
		if (energie <= 30){
			Statistique.nbUrgence += 1;
			return true;
		} 
		return false;
	}
	/**
	 * Permet de savoir si le heros engage le combat
	 * @param mob : monstre contre lequel l'aventurier va devoir se battre
	 * @return rend le boolean true si l'aventurier engange le combat, false sinon.
	 */
	public boolean engageCombat(Mob mob){ 
		if (this.alerte()) return false;
		System.out.println("-> Aventurier" + this.getID() + " VS " + "Mob" + mob.getID() + " " + mob.getPosition());
		Statistique.nbCombat += 1;
		return true;
	}
	/**
	 * Permet de voir si l'aventurier a gagne le combat contre le monstre
	 * L'aventurier perd 10 PV s'il gagne, et 30 PV s'il perd.
	 * @param mob : monstre contre lequel l'aventurier va devoir se battre
	 * @return rend le boolean true si l'aventurier a gagne, false sinon.
	 */
	public boolean aGagne(Mob mob){
		/*s'il gagne, il perd 10 PV et retourne true, sinon il perd 30 PV et retourne false*/
		if((Math.random()*50)+50.0 > mob.getNiveau()){
			Statistique.nbCombatGagne += 1;
			this.energie -= 10;
			mob.seDeplacer(-1,-1);
			System.out.println("VS: Mob" + mob.getID() + " a perdu le combat. PV-10.");
			return true;
		}
		else{
			Statistique.nbCombatPerdu += 1;
			this.energie -= 30;
			System.out.println("VS: Aventurier"+ this.getID() + " a perdu le combat. PV-30");
			return false;
		}
	}
}