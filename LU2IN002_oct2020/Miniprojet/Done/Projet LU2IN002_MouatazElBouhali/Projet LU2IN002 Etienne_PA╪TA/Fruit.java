public class Fruit extends Ressource{
	private String nom;
	private int quantite;
	public Fruit(String nom, int quantite){
		super(nom, quantite);
	}
	public String getNom(){
		return nom;
	}
	public int getQuantite(){
		return super.getQuantite();
	}
}
