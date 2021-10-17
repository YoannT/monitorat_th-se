public class Fourmiagricolt extends Fourmi{
	public Fourmiagricolt(int x,int y){
		super.x=x;
		super.y=y;
	}
	public Fourmiagricolt clone(){
		return new Fourmiagricolt(this.x,this.y);
	}
	public Ressource désherber(Terrain t){
		return t.videCase(x,y);
	}	
}
