import java.util.concurrent.TimeUnit;
import java.util.Scanner;



public class Terrain{
    private static final int tailleL= 14 ;      //nbLignes

    private static final int tailleC= 12 ;     //nbColonnes



    Case [][] terrain=null;
    String matchType;

    //Creation d'un tableau boolean permettant par la suite de definir les gradins avec les spectacteurs
    // et egalement de definir les bornes ou la balle a le droit de tomber.
    //Terrain Match simple


    public Terrain() {
        Case c1 = new Case(false, false, 0, 0,"🔴");
        Case c2 = new Case(true, true, 0, 0,"🎾");
        Case c3 = new Case(false, true, 0, 0,"🔴");
        terrain = new Case[tailleL][tailleC];

        //initialisation du terrain dans le constructeur.
        //c1 ok
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < tailleC; j++) {
                terrain[i][j] =new Case(false, false, 0, 0,"🔴"); // on initialise d'abord les gradins a false (pour dire que si la balle tombe dans cette zone alors ca ne marche pas.
            }
        }

        //c2
        for (int i = 2; i < 12; i++) {
            for (int j = 9; j < tailleC; j++) {
                terrain[i][j] = new Case(false, false, 0, 0,"🔴"); // on initialise d'abord les gradins a false (pour dire que si la balle tombe dans cette zone alors ca ne marche pas.

            }
        }
        //c3
        for (int i = 2; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                terrain[i][j] = new Case(false, false, 0, 0,"🔴"); // on initialise d'abord les gradins a false (pour dire que si la balle tombe dans cette zone alors ca ne marche pas.

            }
        }
        //c4
        for (int i = 12; i < 14; i++) {
            for (int j = 0; j < tailleC; j++) {
                terrain[i][j] = new Case(false, false, 0, 0,"🔴"); // on initialise d'abord les gradins a false (pour dire que si la balle tombe dans cette zone alors ca ne marche pas.

            }
        }
        //V1
        for (int i = 2; i < 5; i++) {
            for (int j = 3; j < 9; j++) {
                terrain[i][j] =new Case(true, true, 0, 0,"🎾");; // on initialise d'abord les gradins a false (pour dire que si la balle tombe dans cette zone alors ca ne marche pas.

            }
        }
        //V2
        for (int i = 9; i < 12; i++) {
            for (int j = 3; j < 9; j++) {
                terrain[i][j] = new Case(true, true, 0, 0,"🎾");; // on initialise d'abord les gradins a false (pour dire que si la balle tombe dans cette zone alors ca ne marche pas.

            }
        }

        //V3
        for (int i = 5; i < 9; i++) {
            for (int j = 3; j < 9; j++) {
                terrain[i][j]=new Case(true, true, 0, 0,"🎾");;

            }
        }
    }




    public void afficherTerrain(){


        for(int i=0;i<tailleL;i++){
            System.out.println();
            for(int j=0;j<tailleC;j++){
                if(terrain[i][j].nonservice==true) {
                    System.out.print(terrain[i][j].getEmoji());
                }else{

                    System.out.print(terrain[i][j].getEmoji());

                }
            }
        }
        System.out.println("\n");

    }
    public void inside() {

            System.out.println("🟢\n");





 }
 public void outside(int resL,int resC) {
     Case c1 = terrain[resL][resC];

     c1.setEmoji("🔵");
     afficherTerrain();
     c1.setEmoji("🔴");


 }
 public boolean isInside(int l,int c){
        return(terrain[l][c].nonservice);
 }


    public String choixTournoi(){
            String choixTournoi="";
            int choix;
             Scanner sc=new Scanner(System.in);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
               System.out.println("Dans quel tournoi préferez vous jouer : (Ceci impact fortement sur la vitesse de la balle, la stabilité du joueur ainsi que son endurance ! Faites attention la surface change.)\n ");
            TimeUnit.MILLISECONDS.sleep(500);

            System.out.println("n°1 : Roland Garros : surface : Terre battue. Rafael Nadal a été sacré 13 fois champions ! Dotation :  42,6 millions d'€ \n");
            TimeUnit.MILLISECONDS.sleep(500);

            System.out.println("n°2 : Open d'Australie : surface : Gazon. Ca glisse un peu mais un joueur de votre niveau devrait savoir affronter cette surface! Dotation : 44,3 millions d'€ \n");
            TimeUnit.MILLISECONDS.sleep(500);

            System.out.println("n°3 : Wimblendon : surface : Gazon. Entre météo difficile et public pro-anglais le combat s'annonce rue mais nous croyons en vous ! Dotation : 34 millions d'£ \n ");
            TimeUnit.MILLISECONDS.sleep(500);

            System.out.println("n°4 : Open de New York : surface : Dur. Quoi de mieux que de jouer dans l'une des plus belles villes au monde ? Dotation : 45 millions $\n");
            TimeUnit.MILLISECONDS.sleep(500);

            System.out.println("Rentrez le numéro du tournoi que vous voulez on s'occupe du reste !\n");
            TimeUnit.MILLISECONDS.sleep(500);

        }catch(Exception e){}
        choix=sc.nextInt();
        while((choix<1)||(choix>4)){
            System.out.println("Erreur de choix merci de selectionner un terrain entre 1 et 4 !");
            choix=sc.nextInt();
        }
        if(choix==1){
            choixTournoi="Roland Garros";

        }
        if(choix==2){
            choixTournoi="l'Open d'Australie";

        }
        if(choix==3){
            choixTournoi="Wimbledon";
        }
        if(choix==4){
            choixTournoi="Open de New York";

        }
        System.out.println("vous avez choisi le tournoi : "+ choixTournoi+". Super choix !\n");
        System.out.println("Début du match : nous demandons au spectateur de prendre place \n");

        return choixTournoi;



    }
    public Case[][] getTerrain(){
        return terrain;
    }

    public static int getTailleL() {
        return tailleL;
    }

    public static int getTailleC() {
        return tailleC;
    }
    /*public void Service(Joueur j1,Joueur j2,balle b1){}


    public void echangePoints(Joueur j1,Joueur j2,Balle b1,tailleL,tailleC){
        Math.random();



    }*/

}




