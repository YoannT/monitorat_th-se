public class Score{
  private static int Sc1;
  private static int Sc2;

  public static void increment1(){
    Sc1++;
  }

  public static void increment2(){
    Sc2++;
  }

  public static void set1(int i){
    Sc1=i;
  }

  public static void set2(int i){
    Sc2=i;
  }

  public static int get1(){
    return Sc1;
  }

  public  static int get2(){
    return Sc2;
  }
}
