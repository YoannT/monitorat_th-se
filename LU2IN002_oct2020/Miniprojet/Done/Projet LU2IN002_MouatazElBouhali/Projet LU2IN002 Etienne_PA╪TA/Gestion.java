public class Gestion{
  private static int BanqueEuro=0;
  private Gestion(){}
  public static void VenteDeFruit(){
    int aleatoire = (int)(Math.random()*(5-1)+1);
    if (aleatoire==1)
      System.out.println("Vente d'un fruit pour " + aleatoire +" euro !");
    else
      System.out.println("Vente d'un fruit pour " + aleatoire +" euros !");
    BanqueEuro+=aleatoire;
  }
  public static int getBanqueEuro(){
    return BanqueEuro;
  }
  public static boolean achatGrain(){
    int aleatoire =(int)(Math.random()*(5-1)+1);
    if (BanqueEuro>0){
      BanqueEuro-=aleatoire;
      if (aleatoire<=2) {
        System.out.println("Achat d'une graine \u00e0 "+aleatoire+ " euro(s)");
        return true;
      }
      else{
        System.out.println("Achat d'une graine sp\u00e9ciale \u00e0 "+aleatoire+" euros");
        return true;
      }
    }
    else{
      System.out.println("Pas assez de sous pour acheter des graines est-ce la fin des haricots ?");
      return false;
    }
  }
  public static String Faillite(){
    if (BanqueEuro<=0){
      return "C'est la fin des haricots. Les graines n'ont pas pouss\u00e9es !";
    }
    else if(BanqueEuro>0){
      return "Les affaires marchent bien, le compte en banque global est \u00e0 : "+BanqueEuro + " euros";
    }
    return "Le compte en banque est \u00e0 "+BanqueEuro+" euros";
  }
}
