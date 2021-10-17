public class Statistiques {
    private static int cptRecolte = 0;
    private static int cptProduite = 0;
    private int recolte;
    private int production;


    public Statistiques(){
        recolte = cptRecolte++;
    }
    public Statistiques(int prod){
        production = cptProduite ++;
    }

    public static int getProduction() {
        return cptProduite;
    }

    public static int getRecolte() {
        return cptRecolte;
    }
}
