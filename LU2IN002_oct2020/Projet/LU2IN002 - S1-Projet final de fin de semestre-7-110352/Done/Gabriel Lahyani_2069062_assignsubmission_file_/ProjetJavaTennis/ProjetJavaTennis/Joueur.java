import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Joueur extends Personne{
    private String nom;
    private String prenom;
    private String nationalite;
    private int age;
    private int classementAtp;
    private int xp;
    private int taille;
    private int poids;
    private boolean service;
    //Score
    int points;
    int jeu;
    int set;
    boolean avantage;
    int tiebreak;
    private boolean haveball;





    public Joueur(String prenom,String nom,String nationalite,int age,int classementAtp,int xp,int taille,int poids,boolean service){
        this.prenom=prenom;
        this.nom=nom;
        this.nationalite=nationalite;
        this.age=age;
        this.taille=taille;
        this.classementAtp=classementAtp;
        this.xp=xp;
        this.taille=taille;
        this.poids=poids;
        avantage=false;
        this.service=service;
        haveball=false;
        points=0;
        jeu=0;
        set=0;

    }
    //Constructeur permettant à l'utilisateur de créer son propre joueur
    public Joueur(String prenom,String nom,String nationalite,int age,int taille,boolean service){
        this.prenom=prenom;
        this.nom=nom;
        this.nationalite=nationalite;
        this.age=age;
        this.taille=taille;
       /*Min +  (int)(Math.random() * (Max - Min))*/
        xp= 890+ (int)(Math.random()*(5200-890));
        this.service=service;
        haveball=false;
        points=0;
        jeu=0;
        set=0;



    }


    public void presentation(){

        System.out.println("Joueur n°"+classementAtp+","+ nom +","+ prenom +","+ age +" ans" +", classementAtp= n°" + classementAtp  + ", xp=" + xp + ", taille=" + taille +" cm" + ", poids=" + poids +" kg\n");

    }
    public void presentation(int i){

        System.out.println("Votre joueur : "+ nom +","+ prenom +","+ age +" ans"  + ", taille=" + taille +"cm"+"xp" + xp+"\n");

    }



    public int getAge() {
        return age;
    }




        public  static Joueur choixJoueur(){
        Joueur j1= new Joueur("Novak","Djokovic","Serbe",33,1,12030,188,80,true);
        Joueur j2= new Joueur("Rafael","Nadal","Espagnole",34,2,9850,185,85,true);

        Joueur j3= new Joueur("Dominic","Thiem","Autrichienne",27,3,9125,185,79,true);


        Joueur j4= new Joueur("Roger","Federer","Suisse",39,4,6630,185,85,true);


        Joueur j5= new Joueur("Danil","Medvedev","Russe",24,5,8470,198,83,true);

        Joueur j6= new Joueur("Stefanos","Tsitsipas","Grecque",22,6,5925,193,85,true);

        Joueur j7= new Joueur("Gael", "MONFILS","Française",34,7,2860,193,80,true);

        Joueur j8= new Joueur("Stan","Wawrinka","Suisse",35,8,2320,183,81,true);

        Joueur j9= new Joueur("Kei","Nishikori","Japonaise",41,9,1345,178,74,true);

        Joueur j10= new Joueur("Hugo","Gaston","Française",20,10,890,173,68,true);

        Joueur []tab= { j1,j2, j3, j4, j5, j6, j7, j8, j9, j10};
        Joueur res=null;
        System.out.println("Voici la liste des joueurs présents au tournoi !");
        for (int i = 0; i < tab.length; i++) {
                try {


                    tab[i].presentation();

                    TimeUnit.MILLISECONDS.sleep(500);

                }catch (InterruptedException e){}

            }

            try {

                System.out.println("Souhaitez-vous creer votre propre joueur ou en choisir un de la liste précedente ?");
                TimeUnit.MILLISECONDS.sleep(500);

                System.out.println("Tapez 0 si vous souhaitez creer votre propre joueur ");
                TimeUnit.MILLISECONDS.sleep(500);

                System.out.println("Tapez le numéro du joueur souhaité si vous voulez choisir un joueur de la liste");
                TimeUnit.MILLISECONDS.sleep(500);


            }catch (InterruptedException e){}


        Scanner sc =new Scanner(System.in);

        int j=0;

        int i=sc.nextInt();


        if((i<0)||(i>10)){
            System.out.println("Vous n'avez pas fait un choix correct veuillez reefectuer un choix");
            while((i<0)||(i>10)){

                i=sc.nextInt();
            }

        }
        else{
            if(i==0){
                System.out.println("Nous allons créer votre joueur qui, j'en suis sur sera le meilleur !\n");
                System.out.println("L'intégralité des données seront supprimer \n");
                String nom;
                String prenom;
                String nationalite;
                int age;
                int taille;

                Scanner sc1 =new Scanner(System.in);
                System.out.println("Veuillez rentrer votre nom\n");
                nom=sc1.nextLine();
                System.out.println("Veuillez rentrer votre prenom\n");
                prenom=sc1.nextLine();
                System.out.println("Veuillez rentrer votre nationalité\n");
                nationalite=sc1.nextLine();
                System.out.println("Veuillez rentrer votre age\n");
                age=sc1.nextInt();
                System.out.println("Veuillez rentrer votre taille\n");
                taille=sc1.nextInt();
                Joueur jp = new Joueur(prenom,nom,nationalite,age,taille,true);

                jp.presentation(i);
                res= jp;


            }else{

                System.out.println("Le joueur choisi est : ");
                (tab[i-1]).presentation();
                        res=tab[i-1];
            }
        }



        return  res;



    }
    public  static Joueur choixJoueurAlea() {
        Joueur j1 = new Joueur("Novak", "Djokovic", "Serbe", 33, 1, 12030, 188, 80,false);

        Joueur j2 = new Joueur("Rafael", "Nadal", "Espagnole", 34, 2, 9850, 185, 85,false);

        Joueur j3 = new Joueur("Dominic", "Thiem", "Autrichienne", 27, 3, 9125, 185, 79,false);


        Joueur j4 = new Joueur("Roger", "Federer", "Suisse", 39, 4, 6630, 185, 85,false);


        Joueur j5 = new Joueur("Danil", "Medvedev", "Russe", 24, 5, 8470, 198, 83,false);

        Joueur j6 = new Joueur("Stefanos", "Tsitsipas", "Grecque", 22, 6, 5925, 193, 85,false);

        Joueur j7 = new Joueur("Gael", "MONFILS", "Française", 34, 7, 2860, 193, 80,false);

        Joueur j8 = new Joueur("Stan", "Wawrinka", "Suisse", 35, 8, 2320, 183, 81,false);

        Joueur j9 = new Joueur("Kei", "Nishikori", "Japonaise", 41, 9, 1345, 178, 74,false);

        Joueur j10 = new Joueur("Hugo", "Gaston", "Française", 20, 10, 890, 173, 68,false);
        Joueur[] tab = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10};
        int res;
        res = (int)(Math.random() * (tab.length)-1);
        System.out.println("L'adversaire choisi aléatoirement par l'ordinateur est:\n" );
        tab[res].presentation();
        return tab[res];


    }

    public int  getXp() {
        return xp;
    }

    public String getName() {
        return  prenom;
    }
    public String getNom(){ return nom;}
    public boolean getService(){
        return service;
    }

    public void setService(boolean service) {
        this.service = service;
    }
    @Override
    public boolean Haveball() {
        return haveball;
    }

    public void setHaveball(boolean haveball) {
        this.haveball = haveball;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public void setJeu(int jeu) {
        this.jeu = jeu;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getJeu() {
        return jeu;
    }

    public int getPoints() {
        return points;
    }

    public int getSet() {
        return set;
    }
}