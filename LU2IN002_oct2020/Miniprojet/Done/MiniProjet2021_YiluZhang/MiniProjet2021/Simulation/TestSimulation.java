public class TestSimulation {
    public static void main(String[] args) {
        Simulation simulation=new Simulation(10, 2, 10, 10);
        
        System.out.println("Il est temps de travailler pour les fourmis.");
        simulation.afficheTerrain();
        System.out.println("================================================");
        simulation.valideRessource();
        simulation.recolteRessource();
        
        simulation.afficheTerrain();
        
        simulation.statistique();  
    }
}