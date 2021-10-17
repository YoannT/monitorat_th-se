public class Jeu {

    public static void main(String[] args) {
        Terrain t1 = new Terrain();
        Arbitre a1 = new Arbitre();
        Joueur j1 = null;
        t1.afficherTerrain();


        j1 = Joueur.choixJoueur();
        Joueur j2 = null;
        j2 = Joueur.choixJoueurAlea();
        while(j1.getName()==j2.getName()){
            j2 = Joueur.choixJoueurAlea();
        }
        int rand=(int)(Math.random()%(2));
        if(rand==1){
            j1.setHaveball(true);
        }else{
            j2.setHaveball(true);

        }
        ManagerScore s1 = new ManagerScore(j1, j2);
        t1.choixTournoi();
        s1.afficherScore(j1,j2);
        while(s1.winner==null) {
            a1.lancer(j1, j2, t1, s1);
        }



    }
}