import java.util.concurrent.TimeUnit;

public class Arbitre {
    private String nom;
    private String prenom;
    private String nationalite;
    private int age;
    public static ManagerScore s1;

    public Arbitre(){
        nom="Dumusois";
        prenom="Damien";
        nationalite="Francaise";
        age=41;

    }
    /*public void lancer(Personne j1,Personne j2,Terrain t1,ManagerScore s1){
        //cela signifie que si le Joueur j1 possede la balle il devient true si il ne possede pas la balle il devient false avec une probabilité certaine.
        if((j1.getXp()>j2.getXp())&&(j1.Haveball()==true)){}

        int resL=(int)Math.random()*(t1.getTailleL());
        int resC= (int)Math.random()*(t1.getTailleC());
      System.out.println(resC);
        System.out.println(resL);
        boolean temp=t1.outside(resL,resC)
        if(inside())

        int xp=j1.getXp();
        if(j1.getService()==true){
            resL= (int)Math.random()*(t1.getTailleL());
        }else{


        }

    }*/
    public boolean random(){
        int []ins={0,1,2,3,4,5,7,8,9,10,11,12,13,14,15};
        int []out={16,17,18,19,20};
        boolean res1=false;
        int res=(int)(Math.random()*(20));
        for(int i=0;i<ins.length;i++){
            if(ins[i]==res){
                res1=true;
                break;
            }

        }
        return res1;


    }
    /*public boolean inside(boolean inside,Terrain t1,int resL,int resC){

        if (inside ==true){
            System.out.println("🟢");
            return true;
        }else{
            t1.inside(resL,resC);
            return false;
        }




    }*/

    public void lancer(Joueur j1,Joueur j2,Terrain t1,ManagerScore s1){
        int rebondL=0;
        int rebondC=0;

        if(j1.Haveball()){

            System.out.println(j1.getNom()+" à la balle ! 🎾");

            if(random()==true){
                rebondL=2+(int)(Math.random()*(11));
                rebondC=3+(int)(Math.random()*(8));
                try {


                t1.inside();
                System.out.println(j1.getNom()+" renvoit la balle à l'intérieur du terrain !\n");

                TimeUnit.MILLISECONDS.sleep(500);

                }catch (InterruptedException e){}


                j1.setHaveball(false);
                j2.setHaveball(true);
                lancer(j1,j2,t1,s1);

            }else{
                rebondL=(int)(Math.random()*(t1.getTailleL()));
                rebondC=(int)(Math.random()*(t1.getTailleC()));
                while(t1.isInside(rebondL,rebondC)==true){
                    rebondL=(int)(Math.random()*(t1.getTailleL()));
                    rebondC=(int)(Math.random()*(t1.getTailleC()));

                }
                try {
                    System.out.println("La balle a été mise dehors par " + j1.getNom() + " la case bleue 🔵 représente l'endroit ou elle est tombée en dehors du terrain\n");

                    t1.outside(rebondL, rebondC);
                    s1.gestionScore1(j2, j1);
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException e){}





                }

        }else{
            System.out.println(j2.getNom()+" à la balle ! 🎾\n");

            if(random()==true){
                rebondL=2+(int)(Math.random()*(11));
                rebondC=3+(int)(Math.random()*(8));
                try {
                    t1.inside();
                    j1.setHaveball(true);
                    j2.setHaveball(false);
                    System.out.println(j2.getNom() + " renvoit la balle à l'intérieur du terrain !\n");
                    lancer(j1, j2, t1, s1);
                    TimeUnit.MILLISECONDS.sleep(500);
                }catch (InterruptedException e){}



                }else{
                rebondL=(int)(Math.random()*(t1.getTailleL()));
                rebondC=(int)(Math.random()*(t1.getTailleC()));
                while(t1.isInside(rebondL,rebondC)==true){
                    rebondL=(int)(Math.random()*(t1.getTailleL()));
                    rebondC=(int)(Math.random()*(t1.getTailleC()));

                }
                try {
                    System.out.println("La balle a été mise dehors par " + j2.getNom() + " la case bleue 🔵 représente l'endroit ou elle est tombée en dehors du terrain\n");
                    t1.outside(rebondL, rebondC);
                    s1.gestionScore1(j1, j2);
                    TimeUnit.MILLISECONDS.sleep(500);

                } catch (InterruptedException e){}




            }

        }





    }




    public void echange(Terrain t1,Personne j1,Personne j2,ManagerScore s1){
        Case c1;
        int tailleL=t1.getTailleL();
        int tailleC=t1.getTailleC();

        t1.afficherTerrain();


    }
    public boolean faute(Terrain t1,Personne j1,Personne j2,ManagerScore s1){
            return true;
    }
    public String getName(){

        return nom;

    }

    public void presentation(){

        System.out.println("L'arbitre qui dirigera cette rencontre est Carlos Bernardes il s'agit d'un arbitre international brésilien.");

    }
    public void presentation(int i){


    }




}