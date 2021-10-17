public class Arbitre extends Personne{ 
// il n'y a qu'un arbitre, il est là pour marquer le début et la fin du tournoi

	private String nom;
	private int posx;
	private int posy;


	public Arbitre(int posx,int posy,String nom){
		super(posx,posy,nom);
	}
	
	
	public String toString(){
		return "Je suis un arbitre";
	}

	public void action(){
		System.out.println("L'arbitre siffle le début du combat");

	}
}
