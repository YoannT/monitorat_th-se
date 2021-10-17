public class Joueur implements Actions {
  public String nom;
  public int endurance;
  public int force;

  public Joueur(String n, int e, int f){
    this.nom=n;
    this.endurance=e;
    this.force=f;
  }

  public boolean intercepter(){ //Fonction de défense car chaque joueur peut défendre lorsque l'équipe adverse a la balle
    if(this.endurance<=0){
      return true; // sans energie, la balle passe
    }
    else if((Math.random()*((100-0)+1))<((this.force)*5)){
      this.endurance-=1;
      return false;
    }
    else{
      this.endurance-=1;
      return true;
    }
  }

  public boolean passe(Joueur j){
    if((this.endurance<=0)||(j.endurance<=0)){
      return false;
    }
    else{
      this.endurance-=1;
      return true;
    }
  }

  public boolean tir(){
    if(this.endurance<=0){
      return false;
    }
    else if((Math.random()*((100-0)+1))>(20)){
      this.endurance-=1;
      return true;
    }
    else{
      return false;
    }
  }

  public boolean faute(){
    if((Math.random()*((100-0)+1))<(10)){
      this.endurance-=1;
      Match.nbFautes++;
      return true;
    }
    else{
      return false;
    }
  }

}
