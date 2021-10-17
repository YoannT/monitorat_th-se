public class TestSimulation{
  public static void main(String [] args){
    Terrain Nulexia=new Terrain(10,10);
    AcademieDesMages AcademieDesMages=new AcademieDesMages(0,0);
    Simulation simu=new Simulation(Nulexia,AcademieDesMages,50,10);
    System.out.println("Informations sur Nulexia:\n"+Nulexia);
    System.out.println("L'Academie des mages se situe a la position "+
    AcademieDesMages+".\n");
    Nulexia.affiche();
    simu.affiche(2);
  }
}
