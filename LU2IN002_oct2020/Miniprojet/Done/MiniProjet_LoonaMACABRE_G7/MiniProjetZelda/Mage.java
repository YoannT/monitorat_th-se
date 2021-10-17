/**
 * @author Loona Macabre, Groupe 7
 */
/**
 * Les mages sont des heros qui se battent avec leurs pouvoirs.
 */
public class Mage extends Heros {
    private final int jaugeMagMax = 8;
    public int jaugeMagie;

    public Mage(String nom){
        super(nom);
        jaugeMagie = jaugeMagMax;
    }

    public Mage(String nom, int x, int y){
        super(nom, x, y);
    }

    public int getJaugeMag(){
        return jaugeMagie;
    }

    /**
     * un mage utilise ses pouvoirs pour se battre, sa
     * jauge de magie se reduit donc selon le nombre 
     * d'adversaires qu'il a devant lui. Il n'utilise
     * que 1 de magie pour un ennemi, donc si il y en a n
     * devant lui, sa jauge magique sera reduite de n.
     * Cette methode est valable, qu'il ait reussi son attaque
     * ou non.
     * @param qteEnnemis
     */
    public void degatsMag(int qteEnnemis){
        jaugeMagie -= qteEnnemis;
        if (jaugeMagie <= 0){
            jaugeMagie = 0;
        }
    }

    /**
     * si il n'a plus de magie dans sa jauge, les capacites du mage sont
     * grandement amoindries.
     * @param ennemi
     * @return la probalite de reussir son attaque
     */
    public double determinerProbaAttaqueReussie(Ressource ennemi){
        double probaAttaqueReussie;
        int qteEnnemis = ennemi.getQuantite();
        if (jaugeMagie > 0){
            if (qteEnnemis < 2){
                probaAttaqueReussie = 0.80;
            }
            else {
                if (qteEnnemis < 4){
                    probaAttaqueReussie = 0.70;
                }
                else {
                    probaAttaqueReussie = 0.60;
                }
            }
        }
        else {
            if (qteEnnemis < 2){
                probaAttaqueReussie = 0.50;
            }
            else {
                if (qteEnnemis < 4){
                    probaAttaqueReussie = 0.40;
                }
                else {
                    probaAttaqueReussie = 0.30;
                }
            }
        }
        return probaAttaqueReussie;
    }

    /**
     * si alea = 0, le mage gagne de la vie, si alea = 1, il gagne de la magie, et si alea = 2, il gagne des rubis.
     * Plus il y a d'ennemis sur la case, plus la recompense est grande.
     * @param m
     */
    public void recompense(Ressource ennemi){
        int alea = (int)(Math.random()*3);
        int qteEnnemis = ennemi.getQuantite();
        if (qteEnnemis < 2){
            if (alea == 0){
                jaugeVie += 1;
                if (jaugeVie >= jaugeVieMax){ jaugeVie = jaugeVieMax;}
                System.out.println(nom+" a gagne 1 coeur.");
            }
            else {
                if (alea == 1){
                    jaugeMagie += 2;
                    if (jaugeMagie >= jaugeMagMax){jaugeMagie = jaugeMagMax;}
                    System.out.println(nom+" a gagne 2 bouteilles de magie.");
                }
                else {
                    Bourse.ajouterRubis(5);
                    System.out.println(nom+" a gagne 5 rubis.");
                }
            }
        }
        else {
            if (qteEnnemis < 4){
                if (alea == 0){
                    jaugeVie += 3;
                    if (jaugeVie >= jaugeVieMax){ jaugeVie = jaugeVieMax;}
                    System.out.println(nom+" a gagne 3 coeurs.");
                }
                else {
                    if (alea == 1){
                        jaugeMagie += 4;
                        if (jaugeMagie >= jaugeMagMax){jaugeMagie = jaugeMagMax;}
                        System.out.println(nom+" a gagne 4 bouteilles de magie.");
                    }
                    else { 
                        Bourse.ajouterRubis(10);
                        System.out.println(nom+" a gagne 10 rubis.");
                    }
                }
            }
            else {
                if (alea == 0){
                    jaugeVie += 5;
                    if (jaugeVie >= jaugeVieMax){ jaugeVie = jaugeVieMax;}
                    System.out.println(nom+" a gagne 5 coeurs.");
                }
                else {
                    if (alea == 1){
                        jaugeMagie += 6; 
                        if (jaugeMagie >= jaugeMagMax){jaugeMagie = jaugeMagMax;}
                        System.out.println(nom+" a gagne 6 bouteilles de magie.");
                    }
                    else {
                        Bourse.ajouterRubis(15);
                        System.out.println(nom+" a gagne 15 rubis.");
                    }
                }
            }
        }
    }

    /**
     * Informations sur le Mage 
     */
    public String toString(){
        return nom+", place en ("+x+","+y+") a "+jaugeVie+" points sur "+jaugeVieMax+" dans sa jauge de vie et "+jaugeMagie+" points sur "+jaugeMagMax+" dans sa jauge de magie.";
    }
}
