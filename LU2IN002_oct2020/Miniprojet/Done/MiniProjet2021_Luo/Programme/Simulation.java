import java.util.ArrayList;

public class Simulation{
	private Terrain terrain;
	private ArrayList<Passager> ressource;
	private ArrayList<Uber> agents;
	public static int nbPassager;
	public static int nbUber;
	public static int odometer;
	public final int capaciteUber = 3;
	
	public Simulation(int nbOrder, int lig, int col){
		
		terrain = new Terrain(lig,col);
		
		ressource = new ArrayList<Passager>();
		
		for(int i=0; i < nbOrder; i++){
			
			int quantite = (int)(Math.random()*6)+1;
				
			Passager passager = new Passager("passenger", 1);
			
			passager.setPosition((int)(Math.random()*lig),(int)(Math.random()*col));
			passager.setDestination((int)(Math.random()*lig),(int)(Math.random()*col));
			passager.setQuantite(Math.min(quantite ,capaciteUber));
				
			passager.commander();
			passager.validerCommande();
			
			if (passager.estValide()){
				ressource.add(passager);
				registerRessource(passager);
				nbPassager += quantite;
			}	
			
			if (quantite > capaciteUber){
				Passager clone = new Passager(passager);
				clone.setQuantite(quantite - capaciteUber);
				
				clone.commander();
				clone.validerCommande();
				
				if (clone.estValide()){
					ressource.add(clone);
					registerRessource(clone);
					clone.setQuantiteActuel(clone.getQuantite());
					clone.setQuantite(quantite);	
				}				
			}
			passager.setQuantiteActuel(passager.getQuantite());
			passager.setQuantite(quantite);	
		}	
		terrain.affiche();
		
		agents = new ArrayList<Uber>();
	 
		for(int i=0; i < ressource.get(0).getCpt(); i++){
			
			int taux= (int)(Math.random()*4);
			Uber uber = new Uber((int)(Math.random()*lig),(int)(Math.random()*col));
			if (taux<1) uber.setPosition((int)(Math.random()*lig), 0);
			else if(taux<2 && taux>=1) uber.setPosition((int)(Math.random()*lig), col-1);
			else if(taux<3 && taux>=2) uber.setPosition((int)(Math.random()*col),0);
			else  uber.setPosition((int)(Math.random()*col),col-1);
			
			uber.agumenterAgent();
			agents.add(uber);
			nbUber++;
		}
	}
	
	public void registerRessource(Passager ress){
        int x = ress.getX();
        int y = ress.getY();
        Ressource ter = terrain.terrain[x][y];
        if(terrain.caseEstVide(x, y)){
            terrain.setCase(x, y, ress);
        }
        else if(ter.getType() == ress.getType()){
            ter.setQuantite(ter.getQuantite()+1);
        }
    }
		
	public void UberAction(){
		for (Uber uber: agents){
			Passager p = ressource.get((uber.getIdent())-1);
			System.out.println("\n");
			
			uber.bouger(p.getX(), p.getY());
			System.out.println();
			uber.retirerRessource(p);
			terrain.videCase(p.getX(), p.getY());
			
			uber.bouger(p.getDesX(), p.getDesY());
			System.out.println();
			uber.arrive(p);
			terrain.setCase(p.getDesX(), p.getDesY(),p);
			System.out.println("Odograph: " + (Math.abs(p.getDesX()-p.getX()) + Math.abs(p.getDesY()-p.getY())) + "km");
			odometer+=(Math.abs(p.getDesX()-p.getX()) + Math.abs(p.getDesY()-p.getY()));
			
			System.out.println("\n");
		}
		terrain.affiche();
	}
	
	public void review(){
		System.out.println(nbUber + " taxis has token " + nbPassager + " passengers. Total mileage: " + odometer + "km.");
	}	
	
	
}