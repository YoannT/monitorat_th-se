import java.util.ArrayList;
import java.util.*; 

public class TestSimulation{
	public static void main(String[] args) {

		Bruce_Lee Bruce_Lee = new Bruce_Lee("Bruce Lee",4,100,4,3);
		Teddy_Riner Teddy_Riner = new Teddy_Riner("Teddy Riner",2,100,3,2);
		Hercule Hercule = new Hercule("Hercule",5,120,4,3);
		Chuck_Norris Chuck_Norris  = new Chuck_Norris("Chuck Norris",3,100,3,2);
		Conor_McGregor Conor_McGregor = new Conor_McGregor("Conor McGregor",2,100,4,3);
		Madara_Uchiwa Madara_Uchiwa = new Madara_Uchiwa("Madara Uchiwa",5,120,3,2);
		Hakuho_Sho Hakuho_Sho = new Hakuho_Sho("Hakuho Sho",3,100,4,3);
		Mike_Tyson Mike_Tyson = new Mike_Tyson("Mike Tyson",3,100,3,2);
		
		ArrayList<Fighter> arraylist = new ArrayList<Fighter>(); // création d'une Arrayliste comportant tous les Fighter
    arraylist.add(Bruce_Lee);
    arraylist.add(Teddy_Riner);
    arraylist.add(Hercule);
    arraylist.add(Chuck_Norris);
		arraylist.add(Conor_McGregor);
    arraylist.add(Madara_Uchiwa);
    arraylist.add(Hakuho_Sho);
    arraylist.add(Mike_Tyson);


    Collections.shuffle(arraylist); //On mélange la liste de facon aléatoire pour que les combats soient déterminés aléatoires  

				
			System.out.println("------------------------------------------------------------");
			System.out.println("-                                                          -");
			System.out.println("-                TIRAGE AU SORT DES COMBAT                 -");
			System.out.println("-                                                          -");
			System.out.println("------------------------------------------------------------");
        
        for (int i =0; i<4; i++){ //boucle permettant de determiner les affrontements
					int j = i+1;
        	System.out.println("Ring "+j);
        	System.out.println(arraylist.get(i*2));//Les Fighter cote a cote dans la liste vont s'affronter (1VS2 , 3VS4 ...)
		      System.out.println("VS");
		      System.out.println(arraylist.get(i*2+1)); // arraylist.get(i) permet d'afficher les Fighter du tableau
        	System.out.println("");
        	
        }
     
			System.out.println("------------------------------------------------------------");
			System.out.println("-                                                          -");
			System.out.println("-               DEBUT DES COMBAT : PREMIER TOUR            -");
			System.out.println("-                                                          -");
			System.out.println("------------------------------------------------------------");

	
		Arbitre A = new Arbitre(2,0,"arbitre");
		
		Simulation s0 = new Simulation(arraylist.get(0),arraylist.get(1),A); // nouvelle simulation pour chaque combat
		Simulation s1 = new Simulation(arraylist.get(2),arraylist.get(3),A);
		Simulation s2 = new Simulation(arraylist.get(4),arraylist.get(5),A);
		Simulation s3 = new Simulation(arraylist.get(6),arraylist.get(7),A);
		
		Simulation[] tab ={s0,s1,s2,s3};
		ArrayList<Fighter> arraylist2 = new ArrayList<Fighter>(); //on créer une nouvelle Arrayliste pour les vainqueurs de chaque combat
		
		for (int i =0; i<4; i++){
		int j = i+1;
		
		System.out.println("");
		System.out.println("");
   	System.out.println("------------------------------------------------------------");
		System.out.println("-                                                          -");
		System.out.println("-                       RING "+j+"                         -");
		System.out.println("-                                                          -");
		System.out.println("------------------------------------------------------------");
   	System.out.println("");
   	System.out.println("");
		arraylist2.add(tab[i].Combat(arraylist.get(2*i),arraylist.get(2*i+1))); //les vainqueurs sont ajouté à la liste et on lance la simulation du combat pour chaque duo 
		System.out.println("");																									// de combattants
		System.out.println("");
		
		}
		
		
		
		Collections.shuffle(arraylist2); //on mélange la liste de vainqueur pour tirer au sort
		
			System.out.println("------------------------------------------------------------");
			System.out.println("-                                                          -");
			System.out.println("-                     DEMI FINALE                          -");
			System.out.println("-                                                          -");
			System.out.println("------------------------------------------------------------");
			
			Simulation s4 = new Simulation(arraylist2.get(0),arraylist2.get(1),A);
			Simulation s5 = new Simulation(arraylist2.get(2),arraylist2.get(3),A);
			Simulation[] tab2 ={s4,s5};
			ArrayList<Fighter> arraylist3 = new ArrayList<Fighter>(); //on créer une nouvelle Arrayliste pour les vainqueurs de chaque combat
			
		for (int i =0; i<2; i++){
			int j = i+1;
		
			System.out.println("");
			System.out.println("");
   		System.out.println("------------------------------------------------------------");
			System.out.println("-                                                          -");
			System.out.println("-                       RING "+j+"                         -");
			System.out.println("-                                                          -");
			System.out.println("------------------------------------------------------------");
   		System.out.println("");
   		System.out.println("");
			arraylist3.add(tab2[i].Combat(arraylist2.get(2*i),arraylist2.get(2*i+1)));//les vainqueurs sont ajouté à la liste
			System.out.println("");
			System.out.println("");
		
		}
		
			System.out.println("------------------------------------------------------------");
			System.out.println("-                                                          -");
			System.out.println("-                      FINALE                              -");
			System.out.println("-                                                          -");
			System.out.println("------------------------------------------------------------");
			
			System.out.println("Ring final");
      System.out.println(arraylist3.get(0));
		  System.out.println("VS");
		  System.out.println(arraylist3.get(1));
      System.out.println("");
      
      Simulation s6 = new Simulation(arraylist3.get(0),arraylist2.get(1),A);
      ArrayList<Fighter> arraylist4 = new ArrayList<Fighter>(); // on créer une nouvelle Arrayliste pour le vainqueur du dernier combat
      
      System.out.println("");
			System.out.println("");
   		System.out.println("------------------------------------------------------------");
			System.out.println("-                                                          -");
			System.out.println("-                       RING FINAL                         -");
			System.out.println("-                                                          -");
			System.out.println("------------------------------------------------------------");
   		System.out.println("");
   		System.out.println("");
			arraylist4.add(s6.Combat(arraylist3.get(0),arraylist3.get(1))); // La liste comporte le vainqueur final
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("-                                                                             -");
			System.out.println("-             LE GRAND VAINQUEUR EST "+arraylist4.get(0)+"                     -");//le seul élément de la liste étant le vainqueur, il est 
			System.out.println("-                                                                             -"); //affiché ici
			System.out.println("-------------------------------------------------------------------------------");
			
			
	}
	
}
