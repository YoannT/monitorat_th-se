public class Balle{

	private int posx;
	private int posy;

	public int getPosx(){

		return posx;

	}

	public int getPosy(){
		return posy;

	}

	public void setPosx(int newposx){

		this.posx=newposx;

	}

	public void setPosy(int newposy){
		this.posy=newposy;

	}

	public void faitunepasse(Joueur a, Joueur b){
		this.posx=b.getPosx();
		this.posy=b.getPosy();

	}

	public String toString(){
	return "position x:"+posx+" position y:"+posy;

	}

	public void balleaucentre(Match m1){
		this.posx=((int)(m1.LIMX/2));		//on pose la balle au centre du terrain 
		this.posy=((int)(m1.LIMY/2));
	
	}

}
