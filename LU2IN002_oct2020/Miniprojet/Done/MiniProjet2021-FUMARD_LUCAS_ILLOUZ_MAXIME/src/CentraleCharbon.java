
public class CentraleCharbon extends Batiment {

	public CentraleCharbon(Ville v) {
		super(v);
	}
	
	public void production() {
		if(super.ville.getNbRessource("Charbon")>=2) {
			System.out.println("Une centrale a charbon consomme 2 charbon pour produire 5 electricite");
			super.ville.removeRessource("Charbon", 2);
			super.ville.addRessource(new Ressource("Electricite",5));
		}else if(super.ville.getNbRessource("Bois")>=5) {
			System.out.println("Une centrale a charbon consomme 5 bois pour produire 3 electricite");
			super.ville.removeRessource("Bois", 5);
			super.ville.addRessource(new Ressource("Electricite",3));
		}else {
			System.out.println("Une centrale a charbon n'a pas assez de charbon ou bois");
		}
	}
	
	public String toString() {
		return "C'est une centrale à charbon";
	}

}
