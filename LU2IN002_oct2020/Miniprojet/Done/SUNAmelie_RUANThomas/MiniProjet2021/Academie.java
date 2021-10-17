public class Academie{
  private final int PositionX;
  private final int PositionY;

  public Academie(int x, int y){
    PositionX=x;
    PositionY=y;
  }

  public int getPositionX(){
    return PositionX;
  }

  public int getPositionY(){
    return PositionY;
  }

  public String toString(){
    return "("+PositionX+","+PositionY+")";
  }
}
