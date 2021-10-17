
public abstract class Batiment {
	protected Ville ville;
	
	protected Batiment(Ville v) {
		ville = v;
	}
	
	public String toString() {
		return "C'est un batîment";
	}
	
	public abstract void production();
}
