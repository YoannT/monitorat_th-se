import java.util.ArrayList;

public class Simulation {
    Ruche ruche = new  Ruche();
    Terrain terrain = new Terrain(5, 5);
    ArrayList<Ressource> ressources = new ArrayList<Ressource>();
    Abeilles abeille = new Abeilles("Maya");
    ArrayList<Abeilles> abeilles = new ArrayList<Abeilles>();
    Frelons frelons = new Frelons("Mechant Frelon");
    ArrayList<Frelons> frelon = new ArrayList<Frelons>();

    //Pose des miels sur le terrain et creation des abeilles
    public Simulation() {
        for (int i = 0; (i < terrain.nbColonnes && i < terrain.nbColonnes); i++) {
            ressources.add(new Ressource("miel", 1));
            terrain.setCase(i, i, new Ressource("mielF", 1));
        }
        for (int j = 0; j < 7 ; j++) {
            abeilles.add(new Abeilles("Abeille n°" + (j + 1)));
            frelon.add(new Frelons("Frelon n°" + (j + 1)));
        }
    }

    //En recoltant du miel, il n'en existe plus
    int i = 0;
    public void recolter() {
        abeille.seDeplacer(i,i);
        System.out.println(abeille.toString() + " is recupering the miel.");
        terrain.videCase(i,i);
        i++;
        new Statistiques();
    }

    //Production de miel et on doit créer une ruche pour y deposer le miel ! L'abeille part du miel à la ruche
    public void productionMiel() {
        abeille.recoltePasMiel();
        ressources.add(new Ressource("mielL", 1));
        terrain.setCase(1,2,new Ressource("mielL",1));
        abeille.seDeplacer(1,2);
        Ruche ruche = new Ruche();
        terrain.setCase(0,4,ruche);
        abeille.seDeplacer(0,4);
        new Statistiques(0);
    }

    //Les frelons attaquent la ruche
    public void attaqueDeFrelons (){
        terrain.videCase(0,4);
    }

    //Affichage des statistiques
    public static void afficherStats(){
        System.out.println("STATISTIQUES COURANTES : ");
        System.out.println("Quantite produite: "+ Statistiques.getProduction());
        System.out.println("Quantite recoltee : " + Statistiques.getRecolte());
    }

}
