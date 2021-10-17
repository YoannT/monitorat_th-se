/**
 * @author Loona Macabre, Groupe 7
 */
public class Simulation {
    //creation des enfants
    private final Ressource colin = new Ressource("Enfant",1);
    private final Ressource iria = new Ressource("Enfant",1);
    private final Ressource balder = new Ressource("Enfant",1);
    private final Ressource fenir = new Ressource("Enfant",1);
    private final Ressource anais = new Ressource("Enfant",1);
    public Ressource[] enfantsKidnappes = {colin,iria,balder,fenir,anais};

    //creation des ennemis
    private final Ressource bokoblin = new Ressource("Ennemi", 4);
    private final Ressource aeralfos = new Ressource("Ennemi", 3);
    private final Ressource bulblin = new Ressource("Ennemi", 5);
    private final Ressource darknut = new Ressource("Ennemi", 3);
    private final Ressource lezalfos = new Ressource("Ennemi", 2);
    private final Ressource skulltula = new Ressource("Ennemi",3);
    private final Ressource stalfos = new Ressource("Ennemi",2);
    private final Ressource gibdo = new Ressource("Ennemi",5);
    public Ressource[] ennemis = {bokoblin,aeralfos,bulblin,darknut,lezalfos,skulltula,stalfos,gibdo};
    

    public Terrain foret;
    public Village toal = new Village();
    public Heros[] heros;
    public int monstresElim = 0;

    public Simulation(){
        foret = new Terrain(8,10);

        //genere 4 heros
        heros = new Heros[4];
        heros[0] = new Epeiste("Link");     heros[1] = new Epeiste("Zelda");
        heros[2] = new Mage("Midona");      heros[3] = new Mage("Machaon");

        //positionne les ennemis et les enfants
        for (int i=0;i<ennemis.length;i++){
            int x1 = (int)(Math.random()*foret.nbLignes);
            int y1 = (int)(Math.random()*foret.nbColonnes);
            foret.setCase(x1,y1,ennemis[i]);
        }
        for (int j=0;j<enfantsKidnappes.length;j++){
            int x2 = (int)(Math.random()*foret.nbLignes);
            int y2 = (int)(Math.random()*foret.nbColonnes);
            while (! foret.caseEstVide(x2,y2)){
                x2 = (int)(Math.random()*foret.nbLignes);
                y2 = (int)(Math.random()*foret.nbColonnes);
            }
            foret.setCase(x2,y2,enfantsKidnappes[j]);
        }
    }

    /**
     * Second constructeur de Simulation, ou l'utilisateur entre ses propres parametres dans TestSimulation
     * @param h
     */
    public Simulation(Heros[] h,int lignesTerrain, int colonnesTerrain){
        foret = new Terrain(lignesTerrain,colonnesTerrain);
        heros = h;
        for (int i=0;i<ennemis.length;i++){
            int x1 = (int)(Math.random()*foret.nbLignes);
            int y1 = (int)(Math.random()*foret.nbColonnes);
            foret.setCase(x1,y1,ennemis[i]);
        }
        for (int j=0;j<enfantsKidnappes.length;j++){
            int x2 = (int)(Math.random()*foret.nbLignes);
            int y2 = (int)(Math.random()*foret.nbColonnes);
            while (! foret.caseEstVide(x2,y2)){
                x2 = (int)(Math.random()*foret.nbLignes);
                y2 = (int)(Math.random()*foret.nbColonnes);
            }
            foret.setCase(x2,y2,enfantsKidnappes[j]);
        }
    }

    /**
     * 
     * @param h
     * @return une Ressource de type ennemi si il y en a un autour ou dans la
     * case du heros, null sinon.
     */
    public Ressource ennemiAutour(Heros h){
        for (int i=0;i<ennemis.length;i++){
            int xEnn = ennemis[i].getX();
            int yEnn = ennemis[i].getY();
            if (h.distance(xEnn,yEnn) <= Math.sqrt(2) && xEnn != -1 && yEnn != -1){
                return ennemis[i];
            }
        }
        return null;
    }

    /**
     * 
     * @param h
     * @return une Ressource de type enfant si il y en a un autour ou dans la 
     * case du heros, null sinon.
     */
    public Ressource enfantAutour(Heros h){
        for (int i=0;i<enfantsKidnappes.length;i++){
            int xEnf = enfantsKidnappes[i].getX();
            int yEnf = enfantsKidnappes[i].getY();
            if (h.distance(xEnf,yEnf) <= Math.sqrt(2) && xEnf != -1 && yEnf != -1){
                return enfantsKidnappes[i];
            }
        }
        return null;
    }

    /**
     * Pour chaque heros, on parcourt le terrain
     * en cherchant si il y un enfant en priorite, ou un
     * ennemi autour de sa case (ou dans la case-meme).
     * Si c'est le cas, il se deplace a la case de
     * l'enfant et le sauve (l'enfant est alors ramene
     * au Village), ou a la case de l'ennemi qu'il attaque.
     * Si l'attaque reussit du premier coup, il recoit une recompense. Sinon,
     * il s'en sort blesse. Il continue ensuite d'explorer la 
     * foret.
     * 
     * Si un heros n'est plus en etat de combattre, ses coordonnees 
     * sont fixees a (-1,-1).
     */
    public void combatUnHeros(Heros h){
        if (h.getJaugeVie() > 0){ // si le heros est toujours en etat de combattre
            Ressource monstre = ennemiAutour(h);
            Ressource enfant = enfantAutour(h);

            if (enfant != null){ // cas ou il y a un enfant autour de lui
                System.out.println("Il y a un enfant pres de "+h.getNom());
                int xEnf = enfant.getX();
                int yEnf = enfant.getY();
                h.seDeplacer(xEnf, yEnf);
                toal.ajouterEnfant();
                enfant.initialisePosition();
                Ressource enfantSauve = foret.videCase(xEnf, yEnf);
            }
            else {
                if (monstre != null){ // cas ou il y a un ennemi autour de lui
                    System.out.println("Il y a un ennemi pres de "+h.getNom());
                    int xEnn = monstre.getX();
                    int yEnn = monstre.getY();
                    h.seDeplacer(xEnn, yEnn);
                    if (h.attaqueReussie(monstre)){ // cas ou il elimine l'ennemi en un seul coup
                        System.out.println(h.getNom()+" a reussi son attaque du premier coup");
                        h.recompense(monstre);
                    }
                    else { // cas ou il est attaque en retour
                        h.attaqueRatee(monstre);
                        System.out.println(h.getNom()+" est blesse");
                    }
                    monstresElim++;
                    monstre.initialisePosition();
                    Ressource monstreSupp = foret.videCase(xEnn,yEnn);
                    h.degatsMag(monstre.getQuantite());
                }
                else { // cas ou il n'y a rien, il cherche dans une autre zone de la foret
                    int xnew = (int)(Math.random()*foret.nbLignes);
                    int ynew = (int)(Math.random()*foret.nbColonnes);
                    System.out.println(h.getNom()+" ne voit rien aux alentours");
                    h.seDeplacer(xnew,ynew);
                }
            }
            if (h.getJaugeVie() <= 0){ // si la jauge de vie est vide apres la bataille
                h.seDeplacer(-1,-1);
                System.out.println(h.getNom()+" n'a plus assez de coeurs");
            }
        }
        else { System.out.println(h.getNom()+" est hors combat");}
    }

    /**
     * Le schema de combatUnHeros est reproduit au plus 20 fois pour chaque heros : on entre dans
     * une boucle qui ne s'arrete que si tous les enfants ont ete
     * sauves, ou si un certain nombre d'iterations a ete atteint.
     * Si ce nombre d'iterations est depasse et que tous les enfants n'ont pas ete recuperes, ca signifie que les
     * monstres ont eu le temps de s'echapper avec les enfants et que la bataille est
     * perdue.
     */
    public void deroulementBataille(){
        int nbIteMax = 15; // on leur accorde 15 iterations (a defaut de savoir programmer un chonometre!)
        int nbIterations = 0;
        foret.affiche();
        System.out.println("Positions initiales des heros :");
        for (int i=0;i<heros.length;i++){
            System.out.println(heros[i].getNom()+" : ("+heros[i].getX()+","+heros[i].getY()+")");
        }

        System.out.println("------------------------------------------------");
        System.out.println("Debut de la bataille :\n");
        while (toal.getNbEnf() < enfantsKidnappes.length && nbIterations < nbIteMax){
            nbIterations++;
            System.out.println("Iteration no "+nbIterations);
            for (int i=0;i<heros.length;i++){ //on s'occupe de chaque heros
                combatUnHeros(heros[i]);  
                System.out.println(heros[i].toString()+"\n");;
            }
            foret.affiche();
        }
        System.out.println("------------------------------------------------");
    }
        
    /**
     * Resume de la bataille : informations sur le nombre d'enfants
     * sauves, d'ennemis elimines et de rubis recoltes, ainsi que sur la sante des heros.
     */
    public void compteRenduBataille(){
        System.out.println("Compte rendu de la bataille :\n");
        System.out.println(monstresElim+" ennemis sur "+ennemis.length+" ont ete vaincus.\n");
        System.out.println(toal.getNbEnf()+" enfants sur "+enfantsKidnappes.length+" sont rentres chez eux.");
        if (toal.getNbEnf() < enfantsKidnappes.length){
            if (monstresElim < ennemis.length){
                System.out.println("Tous les enfants n'ont pas pu etre secourus...\n");
            }
            else {
                System.out.println("Tous les ennemis ont ete vaincus, les enfants sont hors de danger. Bravo les heros !");
            }
        }
        else {
            System.out.println("Tous les enfants ont ete sauves par les heros !\n");
        }
        System.out.println("Contenu de la bourse des heros : "+Bourse.getRubis()+"\n");
        System.out.println("Etat des heros : ");
        for (int i=0;i<heros.length;i++){
            System.out.println(heros[i].toString());
        }
    }
}