public class Arbitre{

  private Arbitre(){
  }

  private static Arbitre A1 = new Arbitre();

  public static Arbitre getA(){
    return A1;
  }

  public static boolean juge(){
    if((Math.random()*((100-0)+1))<(50)){
      return true;
    }
    else{
      return false;
    }
  }


}
