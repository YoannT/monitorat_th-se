/**
 * @author Loona Macabre Groupe 7
 */
/** 
 * La classe Bourse sert a acceder aux rubis gagnes
 * au cours de la simulation.
 */
public abstract class Bourse {
    private static final int tailleMax = 50; //on ne peut pas recolter plus de tailleMax rubis !
    private static int nbRubis = 0;

    /**
     * ajout de rubis dans la bourse
     * @param rubisRecoltes
     */
    public static void ajouterRubis(int rubisRecoltes){
        nbRubis += rubisRecoltes;
        if (nbRubis >= tailleMax){
            nbRubis = tailleMax;
        }
    }

    /**
     * accesseur
     * @return le nombre de rubis
     */
    public static int getRubis(){
        return nbRubis;
    }
}