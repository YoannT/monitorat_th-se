public class Simulation{
	private static Fighter f1; //les deux combattants
	private static Fighter f2;
	private static Arene arene; // arene sur laquelle on travaille
	private static Arbitre arbitre; //l'arbitre
	

	public Simulation(Fighter f1, Fighter f2, Arbitre arbitre){
		this.f1 = f1;
		this.f2 = f2;
		this.arbitre = arbitre;
		this.arene = new Arene(5,4);
		Spectateur s1 = new Spectateur(0,0,"spectateur");
		Spectateur s2 = new Spectateur(s1);
		
		this.arene.setCase(0,0, s1); //placement des spectateurs et de l'arbitre sur l'arene (les spectateur sont tous les memes)
		this.arene.setCase(0,1, s1);
		this.arene.setCase(0,2, s1);
		this.arene.setCase(0,3, s1);
		this.arene.setCase(1,0, s1);
		this.arene.setCase(0,0, s1);
		this.arene.setCase(3,0, s1);
		this.arene.setCase(4,0, s1);
		this.arene.setCase(4,1, s1);
		this.arene.setCase(4,2, s1);
		this.arene.setCase(4,3, s1);
		this.arene.setCase(1,3, s1);
		this.arene.setCase(2,3, s1);
		this.arene.setCase(3,3, s1);
		this.arene.setCase(2,0,new Arbitre(3,1,"arbitre"));
		
	}

	
	
	public static Fighter Combat(Fighter f1, Fighter f2){ // simulation d'un combat
		
		arbitre.action();
		for(int i=1;i<4;i++){
			for (int j =1;j<3;j++){
				arene.actualiser(i,j); // on vide les cases du ring
			}
		}
		
		
		arene.setCase(1,1, f1); // positions de depart des combattants
		arene.setCase(3,2, f2);
		arene.affichage();
		
		arene.actualiser(1,1);
		arene.actualiser(3,2);
		
		
		
		while(f1.getPv()>0 && f2.getPv()>0){ // tant que les deux Fighter ont des Pv, ils continuent à combattre
		
		
			arene.actualiser(f1.posx,f1.posy);//on vide la case ou le Fighter était avant sont déplacement
			f1.SeDeplacer();// les Fighter se déplace chacun leur tour
			arene.setCase(f1.posx,f1.posy,f1);
			
			System.out.println();
			System.out.println();
			
			arene.affichage();// affichage de l'arene avec la nouvelle position des Fighter
			
			System.out.println();
			System.out.println();
			
			if (f1.posx==f2.posx && f1.posy==f2.posy){ // l'attaque a lieu seulement si les Fighter sont sur la meme case , dans ce cas la c'est seulement le nom du Fighter qui lance sont attaque qui apparait sur l'affichage de l'arene
				
				if (f2.Esquive()==true){ //l attaque peut etre esquivé par le Fighter adverse
					System.out.println(f1.get_nom()+" execute son coup mais "+f2.get_nom()+ " l'esquive de justesse !");
				}
				else{
					if (f1 instanceof Legende && f1.getPv()<=40){ // si le Fighter est une légende et que ses pv sont bas alors il peut utiliser sa technique, seulement celle ci n'a qu'une chance sur deux d'etre lancé
						double i=Math.random(); 
    					if(i<0.5){
    						f2.setPv(f2.getPv()-45); // une technique enleve 45 pv à son adversaire
							
    						((Legende) f1).technique();
    						System.out.println("les pv de "+f2.get_nom()+" descendent à "+f2.getPv());
    					}
    					else{
    						System.out.println("Il n'a pas pu utiliser sa technique légendaire");
    					}
    					
					}
					else{ // si l'adversaire n'a pas esquivé alors il subit une attaque
					System.out.println(f1.Attaque_spe(f2));
					
					try{
						Fighter.pv_negatif(f2);
							}catch(PV_negatif e){
							System.out.println(e.getMessage());
						}
	


					System.out.println("les pv de "+f2.get_nom()+" descendent à "+f2.getPv());
				}
			}	
				
				
				
			}
			else{ // si les deux Fighter n'étaient pas sur la meme case c'est alors au deuxième de se déplacer, son tour se passe comme celui du premier
				arene.actualiser(f2.posx,f2.posy);
				f2.SeDeplacer();
				
				arene.setCase(f2.posx,f2.posy,f2);
				
				System.out.println();
				System.out.println();
				arene.affichage();
				System.out.println();
				System.out.println();
				
				if (f2.posx==f1.posx && f1.posy==f2.posy){
				if (f1.Esquive()==true){
					System.out.println(f2.get_nom()+" execute son coup mais "+f1.get_nom()+ " l'esquive de justesse !");
				}
				else{
					if (f2 instanceof Legende && f2.getPv()<=40){
						double i=Math.random(); 
    					if(i<0.5){
    						f1.setPv(f1.getPv()-45);
    						((Legende) f2).technique();
    						System.out.println("les pv de "+f1.get_nom()+" descendent à "+f1.getPv());
    					}
    					else{
    						System.out.println("Il n'a pas pu utiliser sa technique légendaire");
    					}
    					
					}
					else{
					System.out.println(f2.Attaque_spe(f1));
					try{
						Fighter.pv_negatif(f1);
							}catch(PV_negatif e){
							System.out.println(e.getMessage());
						}
					System.out.println("les pv de "+f1.get_nom()+" descendent à "+f1.getPv());
					}
				}		
				
				
				
				}

				
				else{
					System.out.println("les combattants ne sont pas face à face et ne peuvent donc pas se mettre de coups");
				}
			}
			
		}
		
		//lorsque les Pv de l'un des Fighter sont à zero alors le vainqueur est affiché
		if(f1.estKO()){ 
			System.out.println("L'arbitre siffle l'arret du combat! "+f2.get_nom()+" l'emporte par K.O");
		  f2.setPv(100);//les pv de chaque fighter vainqueur se remettent à 100, meme ceux des légendaires 
			return f2;// retourne le vainqueur du combat
		}
		else{
			System.out.println("L'arbitre siffle l'arret du combat! "+f1.get_nom()+" l'emporte par K.O");
			f1.setPv(100);
			return f1; // retourne le vainqueur du combat
		}
		
	
	}
	
}
