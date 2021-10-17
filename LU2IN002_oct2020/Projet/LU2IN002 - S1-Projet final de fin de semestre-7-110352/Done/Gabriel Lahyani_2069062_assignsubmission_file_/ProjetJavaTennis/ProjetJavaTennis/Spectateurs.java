public class Spectateurs extends Personne{
    public String applaudissement;


    public Spectateurs(String prenom, String nom, String nationalite, int age){
        super(prenom,nom,nationalite,age);
        applaudissement="👏👏👏👏👏👏👏👏👏👏👏👏👏";

    }
    public  void getApplaudissement(){
        System.out.println(applaudissement);
    }
    public static void main(String[] args){
        Spectateurs s1=new Spectateurs("Jean","Eude","Francais",10);
        s1.getApplaudissement();
    }
}