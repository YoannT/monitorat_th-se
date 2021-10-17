public class Gardien extends Joueur{
  public int agilite;

  public Gardien(String n, int a){
    super(n,10,0);
    this.agilite=a;
  }

  public int getAgilité(){
    return this.agilite;
  }

  public boolean parer(){
    if(super.endurance<=0){
      return true; //sans energie, le but passe
    }
    else if ((Math.random()*((100-0)+1))>((this.agilite)*10)){ // si le nombre random est supérieur à agilité*10 le but passe
      super.endurance-=4;
      return true;
    }
    else{
      super.endurance-=2;
      return false;
    }
  }

}
