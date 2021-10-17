public class Simulation{
    private int nb_lignes = 5;
    private int nb_colonnes = 6;
    private Ressource[] tabRessources; // Ce tableau contient les ressources.
    private Prisonnier[] tabPrisonniers; // Ce tableau contient les prisonniers.
    private Terrain cellule = new Terrain(nb_lignes, nb_colonnes);

    public Simulation(int a, int b){ // Initialisation du terrain avec les ressources.
        int i;
        int ligne = 0;
        int colonne = 0;
        tabRessources= new Ressource[a];
        tabPrisonniers = new Prisonnier[b];
        for (i = 0 ; i < a ; i++){
            tabRessources[i] = new Ressource("Lettre", (int)(Math.random()*3+1) ); // Les lettres composant le code que les prisonniers doivent trouver pour pouvoir s'échapper.
            
            while (!(cellule.caseEstVide(ligne, colonne))){
                ligne = (int)(Math.random()*(nb_lignes));
                colonne = (int)(Math.random()*(nb_colonnes));
            }
            cellule.setCase(ligne, colonne, tabRessources[i]); 
        }
        for(i = 0 ; i < b ; i++){
            tabPrisonniers[i] = new Prisonnier(nb_lignes/2, nb_colonnes/2); // Les prisonniers apparaissent à l'endroit où se situe le cadenas.
        }
        cellule.affiche();
    }
    
    public boolean pris(){ 
        int quantite;
        int aleatoire;
        Ressource res;
        Sirene s = new Sirene();
        for (Prisonnier p : tabPrisonniers){
            p.seDeplacer(); // Le prisonnier se déplace de façon aléatoire dans la cellule.
            if (cellule.getCase(p.getX(), p.getY()) != null){ // À condition que la cellule ne soit pas vide.
                aleatoire = (int)(Math.random()*100+1);
                if (aleatoire < 20){ // Il y'a 10% de chance que la lettre trouvée soit incorrecte et, par conséquent, que la sirène se déclenche.
                    cellule.videCase(p.getX(), p.getY());
                    if (s.detecte()){
                        System.out.println("OuhouuuhOuhouuuh ! *La sirène retentit dans l'enceinte de la cellule.*\n");
                        return false;
                    }
                } else {
                    res = cellule.getCase(p.getX(), p.getY());
                    quantite = res.getQuantite();
                    System.out.println("Le prisonnier est parvenu à trouver " + quantite + "lettres du code.\n");

                    while ((!p.mot_forme()) && (quantite != 0)){ // Le prisonnier mémorise les lettres.
                        p.ajouterLettre(new Ressource("Lettre", 1));
                        quantite --;
                        res.setQuantite(quantite);
                
                     }
                    if (quantite == 0){
                        cellule.videCase(p.getX(), p.getY());
                    } else {
                        cellule.setCase(p.getX(), p.getY(), res);}
                }     
            }
        }
        return true;
    }
    public Prisonnier[] getTabPrisonniers(){
        return tabPrisonniers;
    }
    public int getNb_lignes(){
        return nb_lignes;
    }
    public int getNb_colonnes(){
        return nb_colonnes;
    }
}
