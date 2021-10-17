import static java.lang.Math.*;
import java.lang.Math; 
public class Testmatch {

	public static void main(String [] args){
	
	
		Club notreclub=new Club();				//On créer un club
		Club autreClub=new Club(notreclub);			//On le clone
		Match m1= new Match(0,0);				//on créer un match 

		Joueur j1=new Joueur("joueur 1",18,0,1,5);		//Puis des joueurs
		Joueur j2=new Joueur("joueur 2",15,0,1,9);
		Joueur j3=new Joueur("joueur 3",16,0,1,1);
		Joueur j4=new Joueur("joueur 4",17,0,1,3);
		Joueur j5=new Joueur("joueur 5",17,0,1,4);
		Joueur j6=new Joueur("joueur 6",18,0,2,7);
		Joueur j7=new Joueur("joueur 7",15,0,2,9);
		Joueur j8=new Joueur("joueur 8",16,0,2,1);
		Joueur j9=new Joueur("joueur 9",17,0,2,0);
		Joueur j10=new Joueur("joueur 10",17,0,2,1);
	
		Joueur g1=new Joueur ("gardien 1",19,0,1,8);
		Joueur g2=new Joueur("gardien 2",20,0,2,8);
		
		Arbitre a1=new Arbitre("Bernard",16,1);			//Et un arbitre

		Joueur joueurt[]={j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
		


		for( int i=0;i<joueurt.length;i++){			//ajoute des membres au club si ils ont plus de 15 ans
		try{	
		notreclub.ajouterMembreJoueur(joueurt[i]);
				}catch( Exceptions e){ 		// sinon leve une exception
		System.out.println(e.getMessage());		
		}
			}


		try{	
		notreclub.ajouterMembreArbitre(a1);		// on inscrit l'arbitre dans le club si il a plus de 15 ans
				}catch( Exceptions t){ 		// sinon leve une exception
		System.out.println(t.getMessage());		
		}



		Balle b = new Balle();				
		b.balleaucentre(m1); 			//on pose la balle au centre
		
		
		int tailledescages=20;
		int distancemax=30;			//distance maximum entre les joueurs pour pouvoir faire une passe
		int distancedescages=100;		
		int fautes=0;   			// nombres de fautes
		
		

		for (int j=0;j<joueurt.length;j++) {
			m1.ajouterJoueur(joueurt[j]);
			m1.initialiserposition(joueurt[j]);		//on initialise la position des joueurs
		
			
		}

		g1.setPosx((int)(Math.random()*m1.LIMX));				//puis celle des gardiens
		g1.setPosy(m1.LIMY-20);
		
		g2.setPosx((int)(Math.random()*m1.LIMX));
		g2.setPosy(20);
		


		while((m1.cmpt1<5)&&(m1.cmpt2<5) ){			//Tant que aucune équipe ne marque 5 buts
		
			Joueur jqdlb= m1.joueurleplusproche(joueurt,b);		//On identifie le joueur le plus proche de la balle
		
			b.setPosx(jqdlb.getPosx());				// et il récupere la balle ( la position du joueur devient aussi celle de la balle)
			b.setPosy(jqdlb.getPosy());	
	

		
			Joueur jqdlb2;

	
			if((jqdlb.getPosy()>distancedescages)||(Math.abs(m1.LIMY-jqdlb.getPosy())>distancedescages)){		//Si le joueur est trop loin des cages
		
				
				jqdlb2=m1.yatilquelqun(jqdlb, joueurt, distancemax);				//il regarde si il y a un joueur de son equipe autour de lui
		
	
				if (jqdlb2==jqdlb){			//si il n'y a personne
					jqdlb2=m1.ennemienvue(jqdlb2,joueurt,30,b); 	//on regarde si il y a un joueur de l'autre équipe pas loin qui pourrais lui prendre la balle
					jqdlb=jqdlb2;

					if(jqdlb2==jqdlb){			//si il n'y a toujours personne
						m1.sedeplacer(jqdlb2);			// alors il avance d'une case
						jqdlb=jqdlb2;
			
					}
				}
				else{	
					jqdlb=jqdlb2;			// sinon, le joueur fait la passe et le joueur qui détient la balle devient son cohéquipier.
				
						
					}			
			
			}	

			else {				//Si le joueur est assez près alors il tente un but
		
				m1.nouveaubut(jqdlb, g2, g1, b);
				if (b.getPosx()<0 || b.getPosx()>m1.LIMX ||  b.getPosy()<0 || b.getPosy()>m1.LIMY){		// si la balle sort du terrain , il y a alors faute.
					System.out.println(a1.toString());
					fautes++;
				}
			}
	
		}
	
	
	
		System.out.println("Il y a eu "+fautes+" fautes durant ce match.\n\n");
		if (m1.cmpt1>m1.cmpt2) {	
			for (int i=0; i<joueurt.length;i++) {
				if (joueurt[i].getEquipe()==1)
					System.out.println("Le joueur"+ i +" a marqué "+joueurt[i].getnbButs()+" et a maintenant " +joueurt[i].getCharisme()+" points de charisme");

		
			}
		System.out.println("\nL'équipe 1 a au total marqué "+m1.cmpt1+" buts");
		System.out.println("L'équipe 2 a au total marqué "+m1.cmpt2+" buts");
		System.out.println("le vainceur est donc l'équipe 1\n");
			}	
	
		else{
		for (int i=0; i<joueurt.length;i++) {
				if (joueurt[i].getEquipe()==2)
					System.out.println("Le joueur"+ i +" a marqué "+joueurt[i].getnbButs()+" et a maintenant " +joueurt[i].getCharisme()+" points de charisme");

		
			}
		System.out.println("\nL'équipe 1 a au total marqué "+m1.cmpt1+" buts");
		System.out.println("L'équipe 2 a au total marqué "+m1.cmpt2+" buts");
		System.out.println("le vainceur est donc l'équipe 2\n");
	

		}
	
	}	
				
}


