public class Uber extends Agent{
	

	public Uber(int x,int y){
		super(x,y);
	}
	
	public void agumenterAgent(){
		System.out.println("Uber No." + getIdent() + " at (" + getX() + "," + getY() + "), is coming in the area!");
	}
	
	public void retirerRessource(Passager r){
		if (r.getQuantiteActuel()==1)
			System.out.println("Passenger of Order No." + r.getIdent() + " has been picked up!\n");
		else
			System.out.println( r.getQuantiteActuel() + " Passengers of Order No." + r.getIdent() + " have been picked up!\n");
	}
	
	public void bouger(int desX, int desY){
		int x = getX();
		int y = getY();
		if (desX == x && desY == y) System.out.println("Navigator of uber No." + getIdent() + ": Arrived!");
		else if (desX == x) {
			if(desY > y) System.out.println("Navigator of uber No." + getIdent() + ": Go right for " + (desY-y) + "km. Arrived!");
			if(desY < y) System.out.println("Navigator of uber No." + getIdent() + ": Go left for " + (y-desY) + "km. Arrived!");
		}
		else if (desY == y){
			if(desX > x) System.out.println("Navigator of uber No." + getIdent() + ": Go down for " + (desX-x) + "km. Arrived!");
			if(desX < x) System.out.println("Navigator of uber No." + getIdent() + ": Go up for " + (x-desX) + "km. Arrived!");
		}
		else if (desX > x){
			System.out.println("Navigator of uber No." + getIdent() + ": Go down for " + (desX-x) + "km.");
			if (desY > y) System.out.println("And turn right for " + (desY-y) + "km. Arrived!");
			if (desY < y) System.out.println("And turn left for " + (y-desY) + "km. Arrived!");
		}
		else if (desX < x){
			System.out.println("Navigator of uber No." + getIdent() + ": Go up for " + (x-desX) + "km.");
			if (desY > y) System.out.println("And turn right for " + (desY-y) + "km. Arrived!");
			if (desY < y) System.out.println("And turn left for " + (y-desY) + "km. Arrived!");
		}
		setPosition(desX, desY);
	}
	
	public void arrive(Passager r){
		System.out.println("Uber No." + getIdent() +  " has token " + r.getQuantiteActuel() + " passenger of Order No." + r.getIdent() + " arrived to the destination!");
	}
}