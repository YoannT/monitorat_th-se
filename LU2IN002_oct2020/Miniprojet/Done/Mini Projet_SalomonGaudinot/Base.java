public class Base{
  //La base (ou plutôt base de fortune) est le lieu ou Chatori-san se réfugie le temps de réparer son avion et de regagner Londre. S'il ne meurt pas avant
  //La base est de coordonnée (0,0)
  
  private int nb_pain;    //Il faut 5 blé pour faire un pain et 5 métal pour faire une piece metallique
  private int nb_piece;
  
  public Base(){
    nb_pain = 1; //On suppose que Chatori-san avait déjà un peu de pain pour éviter qu'il ne meurt de faim dès le début
    nb_piece = 0;
  }
  
  public void upPain(){
    nb_pain++;
  }
  public void downPain(){
    nb_pain--;
  }
  public void upPiece(){
    nb_piece++;
  }
  public int getPain(){
    return nb_pain;
  }
  public int getPiece(){
    return nb_piece;
  }
}
