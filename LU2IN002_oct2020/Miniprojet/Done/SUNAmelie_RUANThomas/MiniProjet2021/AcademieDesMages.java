public class AcademieDesMages extends Academie{
  private static Ressource Baguette=new Ressource("Baguette Magique",0);

  public AcademieDesMages(int x, int y){
    super(x,y);
  }
  public static Ressource getBaguette(){
    return Baguette;
  }
  public static int getNbBaguette(){
    return Baguette.getQuantite();
  }
  public static void setNbBaguette(int n){
    Baguette.setQuantite(n);
  }

}
