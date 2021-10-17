public class Spectateur extends Personne{ //Les Spectateur sont autour du ring pour suporter les Fighter

	
    private String nom;
	private int posx;
	private int posy;

	public Spectateur(int posx,int posy, String nom){
		super(posx,posy,nom);
		
	}
	
	// constructeur par copie
	public Spectateur(Spectateur s){
		super(s.posx,s.posy,s.nom);
		
		
	}
	
	public void action(){
		System.out.println("Le Spectateur applaudit");

	}

	public String toString(){
		return "Spectateur"; // cela permet de savoir qui est le personnage
	}

}
