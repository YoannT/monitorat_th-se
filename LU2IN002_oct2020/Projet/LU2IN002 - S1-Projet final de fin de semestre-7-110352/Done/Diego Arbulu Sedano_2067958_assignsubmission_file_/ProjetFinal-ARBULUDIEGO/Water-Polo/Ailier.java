public class Ailier extends Joueur {
  public int vitesse;

  public Ailier(String n, int v){
    super(n,15,3);
    this.vitesse=v;
  }

  public Ailier(Ailier a){
    super("Blank",15,5);
  }

  public int getV(){
    return this.vitesse;
  }

  @Override
  public boolean tir(){
    if(super.endurance<=0){
      return false;
    }
    else if((Math.random()*((100-0)+1))>(70)){
      super.endurance-=3;
      return true;
    }
    else{
      return false;
    }
  }

  @Override
  public boolean faute(){
    if((Math.random()*((100-0)+1))<(10)){
      super.endurance-=1;
      Match.nbFautes++;
      return true;
    }
    else{
      return false;
    }
  }

}
