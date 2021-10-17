public class Pointe extends Milieu{

  public Pointe(String n){
    super(n);
  }

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
