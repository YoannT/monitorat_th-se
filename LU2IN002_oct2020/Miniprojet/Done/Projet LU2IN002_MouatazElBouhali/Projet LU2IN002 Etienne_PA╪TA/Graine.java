public class Graine extends Ressource{
	private String nom;
	private int quantite;
	private Terrain ter;
	public Graine(String nom, int quantite, Terrain t){
		super(nom, quantite);
		ter = t;
	}
	public Graine(){
		super("Graine",1);
	}
	//methode qui permet d'aleatoirement faire pousser une graine
	public void aleaPousse(int lig, int col, Fruit a){
		if (Math.random() > 0.4 && (ter.getCase(lig,col) instanceof Graine) /*&& ter.sontValides(lig,col)*/){
			ter.videCase(lig, col);
			ter.setCase(lig, col, a);
			System.out.println("La graine dans la case ("+col+","+lig+") a pouss\u00e9e !");
		}
	}

	//methode pour dupliquer des graines
	public Graine clone(){
		return new Graine(nom,quantite,ter);
 }
}
