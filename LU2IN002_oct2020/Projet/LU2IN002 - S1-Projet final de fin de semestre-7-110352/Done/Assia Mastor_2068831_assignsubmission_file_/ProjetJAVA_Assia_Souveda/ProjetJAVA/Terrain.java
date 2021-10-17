
public class Terrain{
	private int x;
	private int y;
	public static final int LIMX=10;
	public static final int LIMY=10;

	public Terrain(){
		this.x=LIMX;
		this.y=LIMY;
	}


	public Terrain(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX(){
		return this.x;	
	}

	public int getY(){
		return this.y;
	}
}

