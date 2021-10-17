public class Agriculteur extends Agent{
  //Les agriculeurs sont les agents spécialisés dans la récolte de blé et la production de Pain
  
  public Agriculteur(int x, int y){
    super(x, y);
  }
  public Agriculteur(){
    super();
  }
  public Ressource chercherRessource(Terrain t){
    int i, j= 0;
    for(i=0; i<t.nbLignes; i++){
      for(j=0; j<t.nbColonnes; j++){
        if(t.getCase(i,j)== null){
          continue;
        }
        if(((t.getCase(i, j)).type == "Blé" )){
          return t.getCase(i,j);
        }
      }        
    }
    return null;
  }
  public String getClasse(){
    return "Agriculteur";
  }

}
