import java.util.ArrayList;

/**
 * 
 */
 
/**
* @author Louise Le Reun
* Cette classe permet de creer une simulation
*/

public class Simulation{
	private Terrain terrain;
	private Mineur[] mineur;
	private Ressource[] ress;
	private Atelier atelier;
	private final int MAX_Q = 12;
	private int nbLignes, nbColonnes, nbRessource;


    /**Constructeur de Simulation
    *@param nbLignes nombre de lignes du terrain
    *@param nbColonnes nombre de colonnes du terrain
    *@param nbRessource nombre de Ressource de type Roche sur le terrain
    *@param nbAgent nombre de mineurs sur le terrain
    */
	public Simulation(int nbLignes, int nbColonnes, int nbRessource, int nbAgent){
		//creation du terrain
		this.terrain=new Terrain(nbLignes,nbColonnes);
		this.nbLignes=nbLignes;
		this.nbColonnes=nbColonnes;
		this.nbRessource= nbRessource;
        int n= nbAgent;
		ArrayList<Pierre> stock = new ArrayList<Pierre>();
		atelier= new Atelier(0,0,stock);

		this.ress= new Ressource[nbRessource];
		this.mineur= new Mineur[n];

        // creation ressources
        for(int i=0 ; i < nbRessource ; i++){
            ress[i] = new Roche("Roche", (int)(Math.random()*MAX_Q));

            // choix de l'emplacement
            int current_ligne = (int) (Math.random() * nbLignes);
            int current_colonne = (int) (Math.random() * nbColonnes);

            // tant qu'on ne trouve pas de case vide
            while(!terrain.caseEstVide(current_ligne, current_colonne)){
                current_ligne = (int) (Math.random() * nbLignes);
                current_colonne = (int) (Math.random() * nbColonnes);
            }

            // initialisation de la ressource sur le terrain
            terrain.setCase(current_ligne, current_colonne, ress[i]);
        }

        // creation agents
        for(int i=0 ; i < n ; i++){
            mineur[i] = new Mineur(atelier.getX(),atelier.getY());
        }
    }

    /**Accesseur de nbRessource
    *@return le nombre de ressource
    */
    public int getNbRessource(){
        return nbRessource;
    }

    /**Transforme la roche passee en parametre en une pierre speciale selon sa chance
    *@param p Roche recoltee par un mineur
    *@return retourne la pierre transformee par le mineur
    */
    public Pierre miner(Roche p){
    	if(p.getChance()<0.40){
    		if(p.getChance()<0.10){
    			return new Pierre("Diamant",1);
    		}else if(p.getChance()<0.20){
    			return new Pierre("Rubis",2);
    		}else if(p.getChance()<0.30){
    			return new Pierre("Emeraude",3);
    		}else{
    			return new Pierre("Amethyste",4);
    		}
    	}else{
    		return new Pierre("Roche",1);
    	}
    }

    /**Calcule la valeur (en €) des pierres recoltees
    *@return la valeur totale des pierres recoltees
    */
    public int valeur(){
        int valeurTotale=0;
        for(Pierre i:atelier.getStock()){
            valeurTotale=valeurTotale+i.getValeur();
        }
        return valeurTotale;
    }

    /**Informations sur le stock de l'atelier
    *@return les statistiques des pierres deposees dans l'atelier
    */
    public String toString(){
    	int nbDiamant =0;
    	int nbRoche=0;
    	int nbRubis=0;
    	int nbAmethyste=0;
    	int nbEmeraude=0;
    	ArrayList<Pierre> at= atelier.getStock();
    	for(Pierre i:at){
    		if((i.getType())=="Diamant"){
    			nbDiamant=nbDiamant+i.getQuantite();
    		}else if(i.getType()=="Rubis"){
    			nbRubis=nbRubis+i.getQuantite();
    		}else if(i.getType()=="Emeraude"){
    			nbEmeraude=nbEmeraude+i.getQuantite();
    		}else if(i.getType()=="Amethyste"){
    			nbAmethyste=nbAmethyste+i.getQuantite();
    		}else{
    			nbRoche=nbRoche+i.getQuantite();
    		}
    	}
    	return "Dans l'atelier il y a :\n"+nbDiamant+" Diamants,\t"+nbRubis+" Rubis,\t"+nbEmeraude+" Emeraudes,\t"+nbAmethyste+" Amethystes,\t"+nbRoche+" Roches.";
    }
    
    /**Affichage du terrain
    */
    public void affiche(){
    	terrain.affiche();
    }

    /**Methode de recolte des ressources par les mineurs
    */
    public void recolte(){
    	for(Mineur min:mineur){
            int xRoche=(int) ((Math.random() * (nbColonnes-1)));
            int yRoche=(int) ((Math.random() * (nbLignes-1)));
            if(terrain.caseEstVide(xRoche,yRoche)){
                System.out.println("La case est vide!");
            }else{
                System.out.println("le mineur est a une distance de "+min.distance(xRoche,yRoche)+ " de la roche qu'il veut miner.");
        		min.seDeplacer(xRoche,yRoche);
    			Ressource roche=terrain.videCase(min.getX(), min.getY());
    			Pierre p=miner((Roche)roche);
    			atelier.ajouterPierre(p);
    			System.out.println("La roche ("+xRoche+", "+yRoche+") a ete tranformee en pierre et deposee a l'atelier.");
                nbRessource=nbRessource-1;
    		}
    	}
    }
    
    /**Methode pour reposer des ressources sur le terrain
    */
    public void poser(){
        for(Mineur min:mineur){
            int xTerrain=(int) ((Math.random() * (nbColonnes-1)));
            int yTerrain=(int) ((Math.random() * (nbLignes-1)));
            if(terrain.caseEstVide(xTerrain,yTerrain)){
                min.seDeplacer(xTerrain,yTerrain);
                Ressource roche= new Roche("Roche",1);
                boolean rocheReposee=terrain.setCase(xTerrain,yTerrain,roche); //on repose une roche dans la case vide
                if (rocheReposee){
                    ArrayList<Pierre> at= atelier.getStock();
                    for(Pierre p:at){
                        if(p.getType()=="Roche"){
                            atelier.enleverPierre(p); //on supprime une roche du stock
                            nbRessource=nbRessource+1;
                            System.out.println("Le mineur a repose une roche sur le terrain en position ("+xTerrain+", "+yTerrain+").");
                            break;
                        }
                    }
                }
            }else{
                System.out.println("le mineur n'a rien repose cette fois.");
            }
        }
    }
}