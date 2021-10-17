public class Simulation {
	   
	   
	Recolteurs tabrecolteurs [] = new Recolteurs[n];
	   for(int i=0 ; i<n ; i++) {
		   tabrecolteurs[i]=new Recolteurs((int)(Math.random()*(Terrain.NBLIGNESMAX)),(int)(Math.random()*(Terrain.NBCOLONNESMAX)));
		   System.out.println(tabrecolteurs[i].getQuantite);
		   
	   }
	   
	   public int Recolte(int nbrecolte){
		      int nbtour = 0;
		      int argent = 0;
		      while(nbtour<nbrecolte) {
		    	  for(int j=0 ; j<tabrecolteurs.length;j++) {
		    		  if(Terrain.caseEstVide(tabrecolteurs[j].getPosx(),tabrecolteurs[j].getPosy())==false) {
		    			  argent += argent.getQuantite[];
		    			  
		    		  }
		    	  }
		         nbtour++;
		         
		      }   
	         return argent;

}
