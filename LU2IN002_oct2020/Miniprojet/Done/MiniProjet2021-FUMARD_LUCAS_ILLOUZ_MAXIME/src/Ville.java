import java.util.ArrayList;

public class Ville {
	private ArrayList<Batiment> batiments;
	private int x, y;
	private Ressource[] ressources;
	
	public Ville(int x, int y) {
		this.x = x;
		this.y = y;
		batiments = new ArrayList<Batiment>();
		Maison m = new Maison(this,new Ressource("Bois",4));
		Humain h = new Humain(this);
		m.setHabitant(h);
		batiments.add(m);
		ressources = new Ressource[]{
				new Ressource("Bois",0),
				new Ressource("Pierre",0),
				new Ressource("Fer",0),
				new Ressource("Charbon",0),
				new Ressource("Eau",0),
				new Ressource("Electricite",0),
				new Ressource("Dechet",0)};
		System.out.println("Une ville a ete cree en ("+x+","+y+"), par un habitant qui vient de construire sa maison");
	}
	
	public void construireMaison() { 
		if(getNbRessource("Pierre")>=8) {
			batiments.add(new Maison(this,removeRessource("Pierre",8)));
			System.out.println("Une maison en pierre vient d'etre construite");
		}else if(getNbRessource("Bois")>=8) {
			batiments.add(new Maison(this,removeRessource("Bois",8)));
			System.out.println("Une maison en bois vient d'etre construite");
		}
	}
	
	public void construireCentrale() { 
		if(getNbRessource("Fer")>=5) {
			removeRessource("Fer", 5);
			batiments.add(new CentraleCharbon(this));
			System.out.println("Une centrale a charbon vient d'etre construite");
		}
	}

	public void construirePompe() { 
		if(getNbRessource("Fer")>=8) {
			removeRessource("Fer", 8);
			batiments.add(new PompeEau(this));
			System.out.println("Une pompe a eau vient d'etre construite");
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString() {
		return "Cette ville est en ("+getX()+","+getY()+"), elle a "+batiments.size()+" batiments : "+getNbMaisons()+" maisons, "+getNbCentrales()+" centrales a charbon, "+getNbPompes()+" pompes a eau";
	}
	
	public int addRessource(Ressource r) {
		if(r==null)
			return 0;
		
		for(Ressource ressource : ressources) {
			if(r.type.equals(ressource.type)){
				ressource.setQuantite(r.getQuantite()+ressource.getQuantite());
				return ressource.getQuantite();
			}
		}
		return 0;
	}
	
	public Ressource removeRessource(String r, int n) {
		for(Ressource ressource : ressources) {
			if(r.equals(ressource.type)){
				int nb = ressource.getQuantite();
				if(n<=nb) {
					ressource.setQuantite(nb-n);
					return new Ressource(r,n);
				}else {
					ressource.setQuantite(0);
					return new Ressource(r,nb);
				}
			}
		}
		return new Ressource(r,0);
	}
	
	public String getAllRessource() {
		String s = "";
		for(Ressource ressource : ressources) {
			s+=ressource+";";
		}
		return s;
	}

	public int getNbRessource(String r) {
		for(Ressource ressource : ressources) {
			if(r.equals(ressource.type)){
				return ressource.getQuantite();
			}
		}
		return 0;
	}
	
	public int getNbHabitants() {
		return getHabitants().size();
	}
	
	public ArrayList<Humain> getHabitants(){
		ArrayList<Humain> habitants = new ArrayList<Humain>();
		for(Batiment b : batiments) {
			if(b.getClass()==Maison.class && ((Maison)b).estHabite()) {
				habitants.add(((Maison)(b)).getHabitant());
			}
		}
		return habitants;
	}
	
	public void addHabitant(Humain h) {
		if(h==null)
			return;
		
		for(Batiment b : batiments) {
			if(b.getClass()==Maison.class && !((Maison)b).estHabite()) {
				((Maison)(b)).setHabitant(h);
				System.out.println("L'humain a ete ajoute a la ville");
				return;
			}
		}
		System.out.println("Il n'y a plus de place dans la ville");
		return;
	}
	
	public Humain removeHabitant(Humain h) {
		if(h==null)
			return null;
		
		for(Batiment b : batiments) {
			if(b.getClass()==Maison.class && ((Maison)b).estHabite() && ((Maison)b).getHabitant()==h) {
				return ((Maison)b).removeHabitant();
			}
		}
		return null;
	}
	
	public int getNbMaisons() {
		int nbMaisons = 0;
		for(Batiment b:batiments) {
			if(b.getClass()==Maison.class)
				nbMaisons++;
		}
		return nbMaisons;
	}
	
	public int getNbCentrales() {
		int nbCentrales = 0;
		for(Batiment b:batiments) {
			if(b.getClass()==CentraleCharbon.class)
				nbCentrales++;
		}
		return nbCentrales;
	}
	
	public int getNbPompes() {
		int nbPompes = 0;
		for(Batiment b:batiments) {
			if(b.getClass()==PompeEau.class)
				nbPompes++;
		}
		return nbPompes;
	}
	
	public Maison getMaisonLibre() {
		for(Batiment b : batiments) {
			if(b.getClass()==Maison.class && !((Maison)b).estHabite()) {
				return (Maison)b;
			}
		}
		return null;
	}
	
	public void productionAll() {
		for(Batiment b : batiments) {
			b.production();
		}
	}
}
