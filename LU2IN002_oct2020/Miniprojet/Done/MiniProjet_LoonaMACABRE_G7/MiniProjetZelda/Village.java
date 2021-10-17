/**
 * @author Loona Macabre, groupe 7
 */

/**
 * La classe Village ne sert qu'a determiner le
 * nombre d'enfants qui ont pu rentrer au village
 * sains et saufs.
 */
public class Village {
    private int nbEnf;

    public Village(){
        nbEnf = 0;
    }

    public void ajouterEnfant(){
        nbEnf++;
    }

    /**
     * accesseur au nombre d'enfants sauves
     * @return le nombre d'enfants trouves par les heros
     */
    public int getNbEnf(){
        return nbEnf;
    }
}
