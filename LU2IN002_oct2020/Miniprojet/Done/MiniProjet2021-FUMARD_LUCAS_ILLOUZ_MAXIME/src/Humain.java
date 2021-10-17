import java.lang.Math;

public class Humain {
	private int x,y;
	private Ville ville;
	private Ressource ressource;
	
	public Humain(Ville v) {
		this.ville = v;
		this.x = ville.getX();
		this.y = ville.getY();
	}

	public String toString() {
		return "C'est un humain qui transporte "+(ressource==null?"rien":ressource);
	}
	
	public Ville getVille() {
		return ville;
	}
	
	public void seDeplacer(int x, int y) {
		System.out.println("Quelqu'un se deplace en ("+x+","+y+"). "+this);
		this.x = x;
		this.y = y;	
	}
	
	public double distance(int x, int y) {
		return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
	}
	
	public void setRessource(Ressource r) {
		this.ressource = r;
	}
	
	public Ressource removeRessource() {
		Ressource r = ressource;
		setRessource(null);
		return r;
	}
	
	public Humain clone() {
		Humain h = new Humain(this.ville);
		h.x = this.x;
		h.y = this.y;
		return h;
	}
	
	public Ressource plusProcheRessource(Terrain t) {
		double distance = 0;
		Ressource ressource = null;
		for(int l=t.nbLignes; l>=0; l--) {
			for(int c=t.nbColonnes; c>=0; c--) {
				if(t.getCase(l, c)!=null && (ressource==null || distance>this.distance(t.getCase(l, c).getX(), t.getCase(l, c).getY()))) {
					ressource=t.getCase(l, c);
					distance=this.distance(ressource.getX(), ressource.getY());
				}
			}
		}
		
		if(ressource==null)
			return null;
		
		int x = ressource.getX();
		int y = ressource.getY();
		ressource = t.videCase(y, x);
		ressource.setPosition(x, y);
		return ressource;
	}

}
