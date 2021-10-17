public class Metalo extends Agent{
  //Les Metalo (diminutif de "métalomancien") sont les agents spécialisés dans la récolte de métal et la production de pièce métallique
  
  public Metalo(int x, int y){
    super(x, y);
  }
  public Metalo(){
    super();
  }
  public Ressource chercherRessource(Terrain t){
    int i, j = 0;
    for(i=0; i<t.nbLignes; i++){
      for(j=0; j<t.nbColonnes; j++){
        if(t.getCase(i,j) == null ){
          continue;
        }
        if(((t.getCase(i,j)).type == "Métal")){
          return t.getCase(i,j);
        }
      }
    }
    return null;
  }
  public String getClasse(){
    return "Metalo";
  }
}
