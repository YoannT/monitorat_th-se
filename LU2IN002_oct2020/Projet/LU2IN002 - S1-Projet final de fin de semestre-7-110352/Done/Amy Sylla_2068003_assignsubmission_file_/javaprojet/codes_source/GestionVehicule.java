

import java.util.ArrayList;

public class GestionVehicule{

	public static void main (String[] args){
		
		Parking p;
		int capaciteVelos;
		int capaciteVoitures;
		ArrayList<Object> tabVelos = new ArrayList<Object>();
		ArrayList<Object> tabVoitures = new ArrayList<Object>();
		
			// on va supposera que les entrees en ligne de commande sont correctes
			
			p = Parking.getInstance();
			capaciteVelos = Integer.parseInt(args[0]);
			capaciteVoitures = Integer.parseInt(args[1]);
			
			
			//initialisation du tableau de velos
			for (int i=2;i<capaciteVelos+2; i++){
				tabVelos.add(new Velo(args[i]));
			}
			
			//initialisation du tableau de voitures
			for (int j=2; j<capaciteVoitures+2; j++){
				tabVoitures.add(new VoitureDeSport(args[j]));
			}
			
			//entretien technique des velos
			try{
				for (Object o: tabVelos){
				System.out.println(((Velo)o).enEtat());
				}
				
				for (Object o: tabVoitures){
				System.out.println(((VoitureDeSport)o).enEtat());
				}
			
			}catch(VehiculeEnBonEtatException v){
				System.out.println(v.toString());
			
			}finally{
				for (Object o: tabVelos){
				System.out.println((Velo)o);
				}
				
				for (Object o: tabVoitures){
				System.out.println((VoitureDeSport)o);
				}
			}
	}
}	
