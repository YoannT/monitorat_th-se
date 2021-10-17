public class Equipe{
  public String nom;
  public Joueur[] composition = new Joueur[6];

  public Equipe(String n, Joueur[] l){
    this.nom=n;
    for(int i=0;i<l.length;i++){
      this.composition[i]=l[i];
    }
  }

  public void energie(){
    for(int i=0;i<6;i++){
      this.composition[i].endurance+=10;
    }
  }

}
