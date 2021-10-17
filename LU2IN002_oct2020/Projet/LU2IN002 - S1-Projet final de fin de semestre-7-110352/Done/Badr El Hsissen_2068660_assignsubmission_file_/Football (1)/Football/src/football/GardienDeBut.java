package football;

public class GardienDeBut extends Joueur {
	int prime;
	String role;
	public GardienDeBut(int num, int s, int pr, String r) {
		super(num, s);
		this.prime=pr;
		this.role=r;
	}
	public void Garder() {
		System.out.println("le joueur arrete le ballon");
	}
	
}
