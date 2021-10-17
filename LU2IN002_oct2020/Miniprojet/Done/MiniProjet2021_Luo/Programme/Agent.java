public class Agent{
	protected int x;
	protected int y;
	protected static int cpt=0;
	protected int ident;
	
	public Agent(int x,int y){
		cpt++;
		this.x=x;
		this.y=y;
		ident = cpt;
	}
	
	public int getIdent(){
		return ident;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
}