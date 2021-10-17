package football;

public abstract class Joueur {
	
	int numero;
	int salaire;
 
 public Joueur( int num,int s) {

	 this.numero=num;
	 this.salaire=s;	

 }
public void Courir() {
	 System.out.println("le joueur court");
 }
 
public String toString() {
	return "le joueur  numero: "+this.numero + " de salaire: "+ this.salaire;			
}
}
