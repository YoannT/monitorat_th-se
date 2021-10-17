/**
 * @author Loona Macabre, Groupe 7
 */
public class Epeiste extends Heros {
    public Epeiste (String nom){
        super(nom);
    }

    public Epeiste (String nom, int x, int y){
        super(nom, x, y);
    }

    /**
     * Constructeur de copie
     */
    public Epeiste(Heros h){
        super(h);
    }

    /**
     * Les recompenses des epeistes sont des rubis si alea = 1, des coeurs si alea = 0. Le nombre
     * de recompenses gagnees depend du nombre d'ennemis battus.
     */
    public void recompense(Ressource ennemi){
        int alea = (int)(Math.random()*2);
        int qteEnnemis = ennemi.getQuantite();
        if (qteEnnemis < 2){
            if (alea == 0){
                jaugeVie += 1;
                if (jaugeVie >= jaugeVieMax){ jaugeVie = jaugeVieMax;}
                System.out.println(nom+" a gagne 1 coeur.");
            }
            else {
                Bourse.ajouterRubis(5);
                System.out.println(nom+" a gagne 5 rubis.");
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
                    Bourse.ajouterRubis(10);
                    System.out.println(nom+" a gagne 10 rubis.");

                }
            }
            else {
                if (alea == 0){
                    jaugeVie += 5;
                    if (jaugeVie >= jaugeVieMax){ jaugeVie = jaugeVieMax;}
                    System.out.println(nom+" a gagne 5 coeurs.");
                }
                else {
                    Bourse.ajouterRubis(15);
                    System.out.println(nom+" a gagne 15 rubis.");
                }
            }
        }
    }

    /**
     * Informations sur l'Epeiste
     */
    public String toString(){
        return nom+", place en ("+x+","+y+") a "+jaugeVie+" points sur "+jaugeVieMax+" dans sa jauge de vie.";
    }
}
