public class Villageois{

	private String nom;
	private double poids;
	private boolean malade;

	public Villageois(String nomVillageois){
		nom = nomVillageois;
		poids = Math.random()*100 + 50;
		malade = Math.random() > 0.2;
	}

	public String getNom(){return nom;}
	public double getPoids(){return poids;}
	public boolean getMalade(){return malade;}

	public double poidsSouleve(){
		if (getMalade()) return (getPoids() / 4.0);
		else return (getPoids() / 3.0); 
	}

	public String toString(){
		String maladeOuiNon = null;
		if (getMalade())
			maladeOuiNon = "oui";
		else 
			maladeOuiNon = "non";

		String text = "Villageois " + nom + ", "
		+ "poids : " + getPoids() + "kg, " + "malade : " + maladeOuiNon
		+ ", poids souleve : " + poidsSouleve();

		return text;
	}
}	