public class Prisonnier{
	private int x;
	private int y;
	private Ressource[] tabLettres; // Ce tableau contient les lettres du code déjà trouvés par le prisonnier.
	
	public Prisonnier(int x, int y){
		this.x = x;
		this.y = y;
		tabLettres = new Ressource[10];
	}
	public int distance(int x, int y){
		double m = (double) this.x-x;
		int n = this.y-y;
		return (int)Math.sqrt((m*m)+(n*n));
	}
	public void seDeplacer(int x, int y){
		this.x=x;
		this.y=y;
	}
	public void seDeplacer(){
		x = (int)(Math.random()*3) - 1 + x;
		y = (int)(Math.random()*3) - 1 + y;
	}
	public void ajouterLettre(Ressource lettre){ // Ajoute une lettre dans le tableau.
		int i = 0;
		if (this.tabLettres[0] == null){
			this.tabLettres[i] = lettre;
		} else {
			while ((this.tabLettres[i] != null) && (i < tabLettres.length)){
				i++;
			}
			this.tabLettres[i] = lettre;
		}
	}
	public boolean mot_forme(){ // Retourne "True" si le prisonnier parvient à trouver 5 lettres et, par conséquent, à former un mot du code.
		return tabLettres[4] != null;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
