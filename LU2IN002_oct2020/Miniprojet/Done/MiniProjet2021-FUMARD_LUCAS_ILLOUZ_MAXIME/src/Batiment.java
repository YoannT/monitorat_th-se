
public abstract class Batiment {
	protected Ville ville;
	
	protected Batiment(Ville v) {
		ville = v;
	}
	
	public String toString() {
		return "C'est un bat�ment";
	}
	
	public abstract void production();
}
