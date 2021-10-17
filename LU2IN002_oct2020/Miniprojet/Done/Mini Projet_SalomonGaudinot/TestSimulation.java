public class TestSimulation{
  public static void main(String[]args){
    
    int nb_agent = 2;
    int nb_ressource = 20;
    
    Base b1 = new Base();
    Terrain t1 = new Terrain(20,20);
    Agent[] tab_agent = new Agent[nb_agent];
    
    Simulation s1 = new Simulation(t1, tab_agent, nb_ressource, nb_agent);
    s1.narration();
    s1.lancerSimulation(b1);
    
  }
}

