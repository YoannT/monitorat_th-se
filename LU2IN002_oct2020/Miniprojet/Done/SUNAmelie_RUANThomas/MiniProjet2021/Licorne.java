public class Licorne{
  private int NumeroLigne;
  private int NumeroColonne;
  private int PossedeEtoile;

  public Licorne(int l, int c){
    NumeroLigne = l;
    NumeroColonne = c;
    PossedeEtoile=0;
  }

  public Licorne(Licorne l){
    this(l.NumeroLigne,l.NumeroColonne);
  }

  public int distance(int x, int y){
    int a = (NumeroLigne-x)*(NumeroLigne-x);
    int b = (NumeroColonne-y)*(NumeroColonne-y);
    return (int)Math.sqrt(a-b);
  }

  public void seDeplacer(int xnew, int ynew){
    NumeroLigne = xnew;
    NumeroColonne = ynew;
  }

  public int getNumeroLigne(){
    return NumeroLigne;
  }

  public int getNumeroColonne(){
    return NumeroColonne;
  }

  public int getPossedeEtoile(){
    return PossedeEtoile;
  }

  public boolean PossedeEtoile(){
    if (PossedeEtoile!=0){
      return true;
    }
    return false;
  }

  public void setPossedeEtoile(int e){
    PossedeEtoile=e;
  }

}
