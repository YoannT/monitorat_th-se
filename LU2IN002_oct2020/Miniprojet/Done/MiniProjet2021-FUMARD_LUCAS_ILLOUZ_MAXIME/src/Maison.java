
public class Maison extends Batiment {
	private Mur[] murs;
	private Humain habitant;
	

	public Maison(Ville v, Ressource m) {
		super(v);
		habitant = null;
		murs = new Mur[4];
		for(int i=0; i<murs.length; i++) {
			murs[i] = new Mur(m.type);
		}
	}

	public void production() {
		if(super.ville.getNbRessource("Electricite")>0) {
			System.out.println("Une maison consomme 1 electricite pour produire 1 dechet");
			super.ville.removeRessource("Electricite", 1);
			super.ville.addRessource(new Ressource("Dechet",1));
		}else {
			System.out.println("Une maison n'a pas assez d'electricite");
		}
		if(super.ville.getNbRessource("Eau")>0) {
			System.out.println("Une maison consomme 1 eau pour produire 1 dechet");
			super.ville.removeRessource("Eau", 1);
			super.ville.addRessource(new Ressource("Dechet",1));
		}else {
			System.out.println("Une maison n'a pas assez d'eau");
		}
	}
	
	public void setHabitant(Humain h) {
		if(estHabite()) {
			System.out.println("Cette maison est deja habitee");
		}else {
			habitant = h;
		}
	}
	
	public Humain removeHabitant() {
		Humain h = habitant;
		habitant = null;
		return h;
	}
	
	public boolean estHabite() {
		return habitant!=null;
	}
	
	public String toString() {
		return "C'est une maison en "+murs[0].materiau+", elle "+(estHabite()?"est":"n'est pas")+" habitee";
	}
	
	public Humain getHabitant() {
		return habitant;
	}

}
