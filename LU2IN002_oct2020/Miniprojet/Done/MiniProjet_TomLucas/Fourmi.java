
public class Fourmi{
	protected int x;
	protected int y;
	protected Fourmi (){}		
	public String get_endroit(){
		return "("+x+y+")";
	}
	public void  déplacer(int newx, int newy){
		x= newx;
		y= newy;
	}
	public double distance(int newx, int newy){
		return Math.sqrt((float)(newx-x)*(newx-x)+(float)(newy-y)*(newy-y));
	}
}
