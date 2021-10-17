public class Attaquant extends Milieu implements Actions{
  public int habilete;

  public Attaquant(String n, int h){
    super(n);
    this.habilete=h;
  }

  public int getH(){
    return this.habilete;
  }

  public boolean faute(){
    if((Math.random()*((100-0)+1))<(30)){
      super.endurance-=1;
      Match.nbFautes++;
      return true;
    }
    else{
      return false;
    }
  }

  @Override
  public boolean tir(){
    if(super.endurance<=0){
      return false;
    }
    else if((Math.random()*((100-0)+1))<(this.habilete)*10){
      super.endurance-=5;
      return true;
    }
    else{
      super.endurance-=2;
      return false;
    }
  }

}
