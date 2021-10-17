/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public class Balle{
	private int x,y;

	public Balle(int x, int y){
		this.x=x;
		this.y=y;
	}

	public Balle clone(){
		return new Balle(this.x,this.y);
	}

	public String toString(){
		return "Balle de coordonn\u00e9es ("+x+","+y+")";
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void moveBalle(int x, int y){
		this.x=x;
		this.y=y;
	}

	public void randomDrop(int maxX, int minX, int maxY, int minY){
    this.x = (int)(Math.random()*(maxX - minX) + minX);
    this.y = (int)(Math.random()*(maxY - minY) + minY);
  }

}
