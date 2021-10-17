public class Ressource{
	protected final int ident;
	protected final String type;
	protected int x;
	protected int y;
	protected int quantite;
	protected static int cpt=0;
	
	public Ressource(String type,int quantite){
		cpt++;
		ident = cpt;
		this.type = type;
		this.quantite = quantite;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getQuantite(){
		return quantite;
	}
	
	public int getIdent(){
		return ident;
	}
	
	public String getType(){
		return type;
	}
	
	public int getCpt(){
		return cpt;
	}
	
	public void setPosition(int lig,int col){
		x=lig;
		y=col;
	}
	
	public void setQuantite(int quantite){
		this.quantite=quantite;
	}
	
	public void setCpt(int c){
		cpt = c;
	}
	
	public void initialisePosition(){
		x=-1;
		y=-1;
	}
	
	public String toString(){
		return "L'indentité:" + getIdent() + "\n"+ "Nom:" + getType() + "\n" + "Position: (" + getX() + "," + getY() + ")";
	}
}
	
	
	