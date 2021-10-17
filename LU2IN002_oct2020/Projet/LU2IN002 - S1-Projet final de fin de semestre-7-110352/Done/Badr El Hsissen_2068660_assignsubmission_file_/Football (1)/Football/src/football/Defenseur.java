package football;
public class Defenseur extends Joueur {

		int prime; 
		String role;
		
		public Defenseur(int num, int s, int pr, String r) {
			super(num, s);
			this.prime=pr;
			this.role=r;
		}
		public void Tacler() {
			System.out.println("le joueur prend le ballon");
		}
	}


