public class Joueur extends Personne  {

	private int nbButs;
	private int charisme;
	private int equipe;
	private int posx, posy;

public Joueur (String nom, int age, int nbButs,int equipe,int charisme){
		super(nom,age);
		this.nbButs=nbButs;
		this.charisme=charisme;
		this.equipe=equipe;
	}

	



	public int getEquipe(){
		return equipe;
	}

	public int getnbButs(){
		return nbButs;
	}



	public int getCharisme(){
		return charisme;
	}
	
	public void setPosx(int pos){
		this.posx=pos;
	}
	
	public void setPosy(int pos){
		this.posy=pos;
	}

	public int  getPosx(){
			return posx;
	}

	
	public int  getPosy(){
		return posy;
	}





public String toString(){
	return nom+","+age+"ans. je fais partie de l'équipe numéro "+equipe+" et j'ai une position de x:"+posx+" y: "+posy;

	}




	
public void enleverpoint(){
this.charisme=charisme-1;

}


	
public void ajouterpoint(){
this.charisme=charisme+1;

}

public void ajouterbut(){
this.nbButs=nbButs+1;
}



}







	
		

	








