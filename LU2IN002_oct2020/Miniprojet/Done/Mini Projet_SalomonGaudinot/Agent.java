public class Agent{
  
  //Les agents ne peuvent porter que 5 ressources en même temps 
  
  protected int id;                         //Identité de l'agent
  protected int lig, col;                   //Coordonnée de l'agent
  protected int nb_res = 0;                 //Nombre de Ressource que l'agent porte actuellement
  protected static int compt_ag = 0;        //Compteur statique d'agent
  
  public Agent(int x, int y){
    lig = x;
    col = y;
    id = compt_ag;
    compt_ag++;
  }
  
  public Agent(){
    this(0,0);
  }
  
  public double distance(int x, int y){
    return Math.sqrt( ((x-lig)*(x-lig)) + ((y-col)*(y*col)));
  }
  
  public void seDeplacer(int xnew, int ynew){
    lig = xnew;
    col = ynew;
  }
  
  public int getId(){
    return id;
  }
  
  public int getX(){
    return lig;
  }
  
  public int getY(){
    return col;
  }
  public Ressource chercherRessource(Terrain t){
    return null;
  }
  
  public void allerVersRessource(Ressource r){
    if(r == null){
      return;
    }
    if(lig<r.getX()){
      lig++;
    }
    else if(lig>r.getX()){
      lig--;
    }
    else if(col<r.getY()){
      col++;
    }
    else if(col>r.getY()){
      col--;
    }
  }
  public void allerVersBase(){
    if(lig>0){
      lig--;
    }
    else if(col > 0){
      col--;
    }
  }
  
  public void recupererRessource(Ressource r){
    if(r == null){
      return;
    }
    
    if((nb_res<5)&&(r.getQuantite()>0)){
      nb_res++;
      r.setQuantite(r.getQuantite()-1);
    }
  }
  
  public void setNbRessource(){
    nb_res = 0;
  }
  public String getClasse(){
    return "Agent";
  }
  public int getNbRessource(){
    return nb_res;
  }
  public Agent clone(){
    return new Agent(lig, col);
  }
}
