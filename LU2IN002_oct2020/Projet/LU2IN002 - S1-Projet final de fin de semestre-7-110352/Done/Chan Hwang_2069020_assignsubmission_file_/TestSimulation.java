/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public class TestSimulation{
  public static void main(String[] args){
    System.out.println("Veuillez mettre le terminal en plein \u00e9cran");
    try{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
    Terrain table = Terrain.singletonTerrain();
    Joueur[] tab = new Joueur[4];
    try{
		    Amateur j1 = new Amateur("Chan");
        ProFemme j2 = new ProFemme("Kimmy",11);
        ProHomme j3 = new ProHomme("Kevin",15);
        ProHomme j4 = new ProHomme("Tony",18);
        ProFemme j5 = new ProFemme("Jenny",25);
        Simulation match= new Simulation(j2,j3,table);
        match.entrainementAvantCompetition(7,j2);
        match.entrainementAvantCompetition(3,j3);
        tab[0]=j2;
        tab[1]=j3;
        tab[2]=j4;
        tab[3]=j5;
        match.matchClassique();
        System.out.println(match.getnbFauteTotale());
        System.out.println("La cote totale pour "+j2.getNom()+" est de "+Gestion.coteTotaleJ1()+ " euros");
        System.out.println("La cote totale pour "+j3.getNom()+" est de "+Gestion.coteTotaleJ2()+ " euros");
        //match.tournois(tab,table);
      }
    catch(ClassementException e){
      System.out.println(e.toString());
    }
  }
}
