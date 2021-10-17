public class Sirene extends Ressource{
	public Sirene(){ // Il s'agit du constructeur de la classe qui donne une case de la cellule contenant une sirène.
		super("Sirene", 1); // Chaque pièce continent 8 sirènes.
	}
	public boolean detecte(){ // Retourne "True" si la sirène détecte le prisonnier.
		int i = (int)(Math.random()*4+1);
		return i < 4;
	}
}
