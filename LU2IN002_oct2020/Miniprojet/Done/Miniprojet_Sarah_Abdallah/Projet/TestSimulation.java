public class TestSimulation{
    public static void main(String[] args){
		int i;
        Simulation evasion = new Simulation(12,2);
        int duree = 13; // La durée en minute avant que les sirènes ne se déclenchent automatiquement.
        int coord_x = evasion.getNb_lignes()/2; // Abscisse du cadenas situé au centre de la cellule.
        int coord_y = evasion.getNb_colonnes()/2; // Ordonnée du cadenas situé au centre de la cellule.
        Code code = new Code(coord_x, coord_y);
        int nb_mots_du_code = 5; // Le nombre de mots dont est composé le code. 
        boolean arret = false;
		
        for(i = 0 ; i < duree ; i++){
            while(!code.codeTrouve(nb_mots_du_code)){
                if(evasion.pris()){
                    for (Prisonnier p : evasion.getTabPrisonniers()){
                        if(p.mot_forme()){
                            code.ajouter_mot();
                            p.seDeplacer(coord_x, coord_y);
                            System.out.println("L'un des prisonniers a trouvé un mot du code !\n");
                        }
                    }
                } else {
                    arret = true;
                    break;
                }
            }
            if(arret == true){break;}
            if (code.codeTrouve(nb_mots_du_code)){
                System.out.println("BRAVO ! Les prisonniers sont parvenus à trouver le code du cadenas.");
                break;
            }
        }
    }
}
