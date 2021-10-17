public class TestSimulation{
	public static int jours = 30;
	public static void main(String[] args){

		//Creation d'un nouveau terrain
		Terrain t = new Terrain(8,8);
		//t.affiche();
		//Creation des ressources
		Fruit[] tab= {new Fruit("Orange",1),new Fruit("Pasteque",1),new Fruit("Pomme",2), new Fruit("Fraise",1)};

		//Creation des Agriculteurs
		Agriculteur[] tab1 = {new Agriculteur(0,0,"Paul"),new Agriculteur(4,4,"Jack")};
		//Test de la distance
		System.out.println("La distance entre "+ tab1[1].getNom() +" et le point (4,8) est: "+deux.distance(4,8));

		//Test du deplacement
		un.seDeplacer(2,3);
		System.out.println("La nouvelle distance entre "+ tab1[1].getNom() +" et le point (4,8) apres deplacement de (2,3) est: "+un.distance(4,8));

		//Creation de la Simulation
		Simulation sim = new Simulation(5,2,tab,tab1,t);

		//Test de la Simulation
		t.affiche();
		System.out.println("Informations sur le terrain:\n"+t +"\n");
		try{
			Thread.sleep(2500);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
		for (int i = 0; i < jours; i++){
			sim.recolte();
			//Test de l'affichage des recoltes
			System.out.println(sim);
			//Affichage du tableau
			t.affiche();
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}

		//Test de l'affichage des recoltes et recettes
		System.out.println("A la fin des " + jours +" tours : "+ sim.toString());
		System.out.println(sim.end());
		System.out.println("Le compte en banque de la ferme est a "+Gestion.getBanqueEuro() +" euros");
		System.out.println(Gestion.Faillite());
	}

}
