public class Passager extends Ressource{
	private int desX;
	private int desY;
	private int quantiteActuel;
	
	
	public Passager(String type,int quantite){
		super(type,quantite);
	}
	
	public Passager(Passager p){
		super(p.type,p.quantite);
		desX = p.desX;
		desY = p.desY;
		x = p.x;
		y = p.y;
	}
		
	
	public void setDestination(int x, int y){
		desX = x;
		desY = y;
	}
	
	public void setQuantiteActuel(int q){
		quantiteActuel = q;
	}
	
	public int getDesX(){
		return desX;
	}
	
	public int getDesY(){
		return desY;
	}
	
	public int getQuantiteActuel(){
		return quantiteActuel;
	}
	
	public double distance(){
		int dx = getX() - getDesX();
		int dy = getY() - getDesY();
		return (Math.sqrt(dx*dx + dy*dy));
	}
	
	public void commander(){
		if (getQuantiteActuel()==1) 
			System.out.println("A new passenger is calling a Uber at (" + getX() + "," + getY() + ") ,wants to go to (" + getDesX() + "," + getDesY() + ")" );
		else 
			System.out.println( getQuantite() + " passengers are calling a Uber at (" + getX() + "," + getY() + ") ,want to go to (" + getDesX() + "," + getDesY() + ")" );
	}
	
	public void validerCommande(){
		System.out.println("Order confirmation...");
		if (distance() < 1.0) {
			System.out.println("Passenger is already in destination, Order cancelled!");
			cpt--;
		}else System.out.println("Order No." + getIdent() + " confirmed!\n");
	}
	
	public boolean estValide(){
		return distance()>= 1.0;
	}
}
	