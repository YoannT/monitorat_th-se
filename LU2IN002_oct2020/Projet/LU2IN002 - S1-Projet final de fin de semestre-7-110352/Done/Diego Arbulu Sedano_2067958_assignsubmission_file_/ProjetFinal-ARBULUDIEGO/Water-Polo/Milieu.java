public abstract class Milieu extends Joueur implements Actions{

  public Milieu(String n){
    super(n,20,4);
  }
  public abstract boolean faute();

  @Override
  public boolean passe(Joueur j){
    if((super.endurance<=0)||(j.endurance<=0)){
      return false;
    }
    else{
      super.endurance-=2;
      return true;
    }
  }

  @Override
  public boolean tir(){
    if(super.endurance<=0){
      return false;
    }
    else if((Math.random()*((100-0)+1))<(30)){
      super.endurance-=5;
      return true;
    }
    else{
      super.endurance-=2;
      return false;
    }
  }

}
