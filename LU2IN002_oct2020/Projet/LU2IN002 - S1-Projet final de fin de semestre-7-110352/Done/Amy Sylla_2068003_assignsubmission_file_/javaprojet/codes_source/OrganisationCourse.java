

public class OrganisationCourse{
	
	public static void main(String[] args){
		
		double distanceAparcourir = 1000.0;
		double distFstStep =0.0;  //distance parcourue à la premiere etape
		double tempsMis = 0.0;
		
		
		//l'utilisateur donne en ligne de commande le nombre de voitures en course et la marque unique 
		//on suppose que les entrees sont correctes
		VoitureDeSport[] tab = new VoitureDeSport[Integer.parseInt(args[0])];
		
		for (int i=0; i<tab.length; i++){
			tab[i]= new VoitureDeSport(args[1]);
		}
		
		//presentation des voitures
		System.out.println("Les voitures en course sont:");
		try{
			for (int i=0; i<tab.length; i++){
			System.out.println(tab[i]);
			Thread.sleep(3000);
			}
		}catch(InterruptedException i){
			System.out.println("Execution interrompue");
		}
		
		//lancement de la course
		//chaque voiture parcoure une certaine distance avec sa vitesse initiale puis le reste avec une autre vitesse
		
		System.out.println("Les voitures sont lancees.");
		for (int i=0; i<tab.length; i++){
			distFstStep = Math.random()*1000;
			tab[i].rouler(distFstStep);
			tempsMis = (tab[i].getDistanceParcourue()) * (tab[i].getVitesseMoyenne());
			tab[i].setVitesseMoyenne(Math.random()*50);
			tempsMis += (distanceAparcourir - distFstStep)* (tab[i].getVitesseMoyenne());
			tab[i].setDistanceParcourue(distanceAparcourir);
			System.out.println(tab[i] + " a mis "+ tempsMis + " secondes");
		}
		
		
	}
}