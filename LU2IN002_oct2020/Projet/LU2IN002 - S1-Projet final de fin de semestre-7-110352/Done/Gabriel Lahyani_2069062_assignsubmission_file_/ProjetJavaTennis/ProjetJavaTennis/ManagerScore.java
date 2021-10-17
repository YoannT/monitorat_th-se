public class  ManagerScore {
    Personne j1;
    Personne j2;
    Personne winner=null;

    public ManagerScore(Personne j1, Personne j2) {

        this.j1 = j1;
        this.j2 = j2;



    }

    public void afficherScore(Joueur j1, Joueur j2) {


        System.out.println(" |Joueur | " +j1.getName() +" " +j1.getNom() +" |"+j2.getName() +  " " +j2.getNom() );
        System.out.println(" |Set "+"   |"+ j1.set + "               |"+j2.set);
        System.out.println(" |jeu "+"   |"+ j1.jeu + "               |"+j2.jeu);
        System.out.println(" |Points "+"|"+ j1.points + "              |"+j2.points);




       /* System.out.println(" |"+j1.getName() +" " +j1.getNom() + "  |" + j1.set + " |" + j1.jeu + " |" + j1.points + "|");
        System.out.println(" |"+j2.getName() +  "|" +j2.getNom() + "|" + j2.set + " |" + j2.jeu + " |" + j2.points + "|");*/
    }

   /* public void gestionScore(Joueur gagnant, Joueur perdant) {

        if ((gagnant.getPoints() == 0) || (gagnant.getPoints() == 15)) {
            gagnant.points+=15;
            afficherScore(gagnant, perdant);
        } else {
            gagnant.points+=10;
            afficherScore(gagnant, perdant);


        }

        if ((gagnant.points == 40) && (perdant.points == 40)) {
            gagnant.avantage = true;
            perdant.avantage = false;


        }
        if (((perdant.points == 40) && (perdant.avantage)) && (gagnant.points == 40)) {
            gagnant.avantage = false;
            perdant.avantage = false;
        }


            if (((gagnant.points == 40) && (gagnant.avantage)) && (perdant.points == 40)) {
            gagnant.jeu += 1;
            gagnant.points = 0;
            perdant.points = 0;
            gagnant.avantage = false;
            perdant.avantage = false;
            if (gagnant.getService() == true) {
                gagnant.setService(false);
                perdant.setService(true);
                System.out.println(perdant.getName() + "sert pour le jeu suivant");

            } else {
                gagnant.setService(true);
                perdant.setService(false);
                System.out.println(gagnant.getName() + "sert pour le jeu suivant");

            }

            //gagnant un jeu après égalité

        } else if ((gagnant.points == 40) && (perdant.points != 40)) {
            gagnant.jeu += 1;
            gagnant.points = 0;
            perdant.points = 0;
            afficherScore(gagnant, perdant);
            gagnant.avantage = false;
            perdant.avantage = false;

            if (gagnant.getService() == true) {
                gagnant.setService(false);
                perdant.setService(true);
                System.out.println(perdant.getName() + "sert pour le jeu suivant");

            } else {
                gagnant.setService(true);
                perdant.setService(false);
                System.out.println(gagnant.getName() + "sert pour le jeu suivant");

            }
        }
        //gagnant un set avec deux jeux d'ecarts
        if ((gagnant.jeu == 6) && (perdant.jeu < 5)) {
            gagnant.set += 1;
            gagnant.jeu = 0;
            perdant.jeu = 0;
            afficherScore(gagnant, perdant);


        }
        if ((gagnant.jeu == 7) && (perdant.jeu == 5)) {
            gagnant.set += 1;
            gagnant.jeu = 0;
            perdant.jeu = 0;
            afficherScore(gagnant, perdant);


        }
        if(gagnant.jeu==1){
            winner=gagnant;
            gagnant.presentation();
            manageStatEnd();
        }
        //tiebreak


    }*/
    public void gestionScore1(Joueur gagnant, Joueur perdant){
        if ((gagnant.getPoints() == 0) || (gagnant.getPoints() == 15)) {
            gagnant.points+=15;
            afficherScore(gagnant, perdant);
        } else if(gagnant.getPoints()==30) {
            gagnant.points+=10;
            afficherScore(gagnant, perdant);


        }else if(gagnant.getPoints()==40){
            gagnant.jeu+=1;
            afficherScore(gagnant, perdant);
            System.out.println("Le jeu a été remporté par "+gagnant.getNom()+"\n");

            if(gagnant.Haveball()==true){
                perdant.setHaveball(true);
                gagnant.setHaveball(false);

            }else{
                perdant.setHaveball(false);
                gagnant.setHaveball(true);
            }
            gagnant.points=0;
            perdant.points=0;
        }
        if(gagnant.jeu>=7){
            gagnant.set+=1;
            gagnant.jeu=0;
            perdant.jeu=0;
            gagnant.points=0;
            perdant.points=0;
            afficherScore(gagnant, perdant);


        }
        if(gagnant.set==1){
            winner=gagnant;
            afficherScore(gagnant, perdant);
            System.out.print("Le gagnant est : ");
            winner.presentation();
            manageStatEnd(gagnant,perdant);


        }



    }


        public static void tiebreak(Joueur gagnant, Joueur perdant) {
        int points = 0;
        while (points != 9) {
            gagnant.tiebreak += 1;
        }
        gagnant.set += 1;


    }
    public void manageStatEnd(Joueur j1,Joueur j2){
        int Vmoy1=(int)(Math.random()*(230-180))+180;
        int Vmoy2=(int)(Math.random()*(230-180))+180;
        int df=(int)(Math.random()*(5))+1;
        int df2=(int)(Math.random()*(5))+1;
        int pg1=(int)(Math.random()*(50))+30;
        int pg2=(int)(Math.random()*(50))+30;
        int bbreakg1=(int)(Math.random()*(12))+3;
        int bbreakg2=(int)(Math.random()*(12))+3;


        System.out.println("voici les statistiques de votre joueur. Bien joué !");
        System.out.println(" |Joueur            | " +j1.getName() +" " +j1.getNom() +" |"+j2.getName() +  " " +j2.getNom() );

        System.out.println(" |Vitesse Service   | " +Vmoy1 +"km/h      |" +Vmoy2 +" km/h");
        System.out.println(" |Double Fautes     | " +df +"            |" +df2 );
        System.out.println(" |Points gagnants   | " +pg1 +"           |" +pg2 );
        System.out.println(" |Balles de breaks :| " +bbreakg1 +"           |" +bbreakg2 );



    }


}
