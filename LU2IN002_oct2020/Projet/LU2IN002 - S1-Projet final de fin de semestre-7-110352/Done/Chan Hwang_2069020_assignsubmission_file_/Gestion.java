/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
import java.util.Scanner;
public class Gestion{
  private static float coteJ1=0;
  private static float coteJ2=0;
  private Gestion(){}
  public static void parisportif(Joueur j1,Joueur j2){
    System.out.println("Voulez-vous parier ? oui / non");

    Scanner clavier2 = new Scanner(System.in);
    String rep = clavier2.nextLine();
    switch (rep){
      case "non" :
      break;
      case "oui" :
      System.out.println("choississez le montant a parier");
  		Scanner clavier = new Scanner(System.in);
  		int t = Integer.parseInt(clavier.nextLine());
      if (t<=0){
        System.out.println("Pas de paris sportif encaiss\u00e9e");
        System.exit(0);
      }
      System.out.println("Choisissez le joueur sur qui pari\u00e9e : 1-> "+j1.getNom() +" ou 2-> "+j2.getNom());
      Scanner clavier1 = new Scanner(System.in);
  		int joueur = Integer.parseInt(clavier1.nextLine());
      switch(joueur){
        case 1 :
        coteJ1+=t;
        System.out.println("Vous avez pari\u00e9e "+ t+" euros sur "+j1.getNom());
        break;
        case 2 :
        System.out.println("Vous avez pari\u00e9e "+ t+" euros sur "+j2.getNom());
        coteJ2+=t;
        break;
      }
      break;
    }
  }
  public static float coteTotaleJ1(){
    return coteJ1;
  }
  public static float coteTotaleJ2(){
    return coteJ2;
  }
  public static float setCoteJ1(float multiplicateur){
    return coteJ1*=multiplicateur;
  }
  public static float setCoteJ2(float multiplicateur){
    return coteJ2*=multiplicateur;
  }
}
