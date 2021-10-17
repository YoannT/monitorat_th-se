
public class PompeEau extends Batiment {

	public PompeEau(Ville v) {
		super(v);
	}
	
	public void production() {
		if(super.ville.getNbRessource("Electricite")>=2) {
			System.out.println("Une pompe a eau consomme 2 electricite pour produire 5 eau");
			super.ville.removeRessource("Electricite", 2);
			super.ville.addRessource(new Ressource("Eau",5));
		}else {
			System.out.println("Une pompe a eau n'a pas assez d'electricite");
		}
	}
	
	public String toString() {
		return "C'est une pompe à eau";
	}

}
