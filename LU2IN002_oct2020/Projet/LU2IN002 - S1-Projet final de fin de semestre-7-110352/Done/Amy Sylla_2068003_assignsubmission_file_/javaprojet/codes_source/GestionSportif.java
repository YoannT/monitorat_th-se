

//cette classe va nous permettre de tester les differentes fonctionse©crites et de simuler l'organisation du club


public class GestionSportif{
	
	public static void main (String[] args){
		
		//Gestion des sportifs
		
		Automobiliste s1 = new Automobiliste("Bryant",36,78.6);  
		Cycliste s2 = new Cycliste("anna", 24, 50.0, 90.0);
		Sportif s3 = new Sportif(s2);
		Automobiliste s4 = new Automobiliste("julien",25, 58.0);
			
			
		try{
			
			//verification du sport pratique
			System.out.println("Verification du sport pratique:");
			System.out.println(s1.getSportPratique());
			System.out.println(s2.getSportPratique());
			System.out.println(s3.getSportPratique());
			System.out.println(s4.getSportPratique());
			
			//verification de l'etat de sante
			System.out.println("verification de l'etat de sante:");
			System.out.println(s1.getPoids());
			System.out.println(s2.getPoids());
			System.out.println(s3.getPoids());
			System.out.println(s4.getPoids());
			
		}catch(SportInconnuException e){
			System.out.println(e.toString());
			
		}catch(SportifMaladeException e){
			System.out.println(e.toString());
			
		}finally{
			for (int i = 0; i<10; i++){
				s1.sEntrainer();
				s2.sEntrainer();
				s3.sEntrainer();
				s4.sEntrainer();
			
				s1.fatiguer();
				s2.fatiguer();
				s3.fatiguer();
				s4.fatiguer();
			}
	
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s4);
		}
		
	}
}