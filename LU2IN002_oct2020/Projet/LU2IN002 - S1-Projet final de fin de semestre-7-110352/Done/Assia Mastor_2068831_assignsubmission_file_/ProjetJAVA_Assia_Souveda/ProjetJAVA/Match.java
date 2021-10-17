
import java.util.*;
import java.lang.Math; 

public class Match implements analyse {
	
	private ArrayList<Joueur> equipe1=new ArrayList<Joueur>();
	private ArrayList< Joueur > equipe2=new ArrayList<Joueur>();
	public int LIMX=70;
	public int LIMY=100;
	public int cmpt1;
	public int cmpt2;
	
	public Match(int cmpt1, int cmpt2) {
		
		this.cmpt1=cmpt1;
		this.cmpt2=cmpt2;
		
	}

	

	public void ajouterJoueur(Joueur i){
		
		if (i instanceof Joueur){

			if (i.getEquipe()==1) {
				if (equipe1.size()<7){
					equipe1.add(i);
				}
			}
		

			else {
				if (equipe2.size()<7){
					equipe2.add(i);
				}
			}

			
		}
		}
	
	





	public double distance(Balle balle, Joueur j){
	return Math.sqrt(( Math.pow((double) ( (balle.getPosx())-(j.getPosx()) ),2.0 ) )   + (Math.pow((double) ( balle.getPosy()-j.getPosy() ),2.0))   ); //formule de la distance entre 2 points

	}



	
	public double distanceentrejoueurs(Joueur a, Joueur b){
		
		double diffx=Math.abs((double)(a.getPosx()-b.getPosx()));
		double diffy=Math.abs((double)(a.getPosy()-b.getPosy()));
		double tot= Math.sqrt(Math.pow(diffx,2.0)+Math.pow(diffy, 2.0));
		return tot;
	}




	public Joueur joueurleplusproche(Joueur tab[],Balle b){
		Joueur leplusproche=tab[0];
		int i;
		for(i=1;i<tab.length;i++){
			if (distance(b,tab[i])<distance(b,leplusproche)){
				
				leplusproche=tab[i];
			
		}
		}
		return leplusproche;
	
	}


	public void initialiserposition(Joueur i){
		i.setPosx((int)(Math.random()*LIMX));
		i.setPosy((int)(Math.random()*LIMY));

	}

	



	public Joueur yatilquelqun( Joueur jlpp,Joueur joueurt[],int distancemax){
	if (jlpp.getEquipe()==1){				// si le joueur le plus proche fait partie de l'équipe 1 alors:

		for (int i=0;i<joueurt.length;i++){			//on parcourt la liste des joueurs 
			if(joueurt[i].getEquipe()==1){				// si le joueur fait egalement parti de l'équipe 1
				if ((distanceentrejoueurs(jlpp,joueurt[i])<distancemax)&&(jlpp.getPosy()>joueurt[i].getPosy())){ // si la distance entre ces deux joueurs 															est inférieure à la distance maximum possible pour faire une passe et que le second joueur est plus avancé dans le terrain
		
					return joueurt[i];
				}
			}
		}
	
	return jlpp;
	}


	else{
		for (int i=0;i<joueurt.length;i++){			//on parcourt la liste des joueurs 
			if(joueurt[i].getEquipe()==2){				// si le joueur fait egalement parti de l'équipe 1
				if ((distanceentrejoueurs(jlpp,joueurt[i])<distancemax)&&(jlpp.getPosy()<joueurt[i].getPosy())){ // si la distance entre ces deux joueurs 															est inférieure à la distance maximum possible pour faire une passe et que le second joueur est plus avancé dans le terrain ( de l'autre coté)
		
					return joueurt[i];
				}
			}
		}
	
	return jlpp;
	} 


}

	public void sedeplacer(Joueur joueur){
	if (joueur.getEquipe()==1){
		joueur.setPosy(joueur.getPosy()-1);	
		}
	else {
		joueur.setPosy(joueur.getPosy()+1);	
		}	

	}



	public Joueur ennemienvue(Joueur jqdlb, Joueur joueurt[],int distancemax,Balle balle){
	if( jqdlb.getEquipe()==1){	//si jqdlb fais parti de l'equipe 1
	for (Joueur j:equipe2){
		if( distanceentrejoueurs(jqdlb, j)<=distancemax){ // et que un joueur de l'equipe adverse est près
			balle.faitunepasse(jqdlb,j);		// alors le joueur de l'équipe adverse lui prend la balle
			return j;				// et on retroune ce joueur
			}	
		}
		return jqdlb; }				//sinon on retourne le joueur de base

	else {
	for (Joueur j:equipe1){
		if( distanceentrejoueurs(jqdlb, j)<=distancemax){ 
			balle.faitunepasse(jqdlb,j);	
			return j;	
			}	
		}
		return jqdlb;
		}
	}
	


	
	
	public void nouveaubut(Joueur jqdlb,Joueur g2, Joueur g1, Balle b) {
		
		if (jqdlb.getEquipe()==1){
			b.setPosx((int)(Math.random()*(LIMX+40)));		//le plus 5 c'est pour permettre qu'il y ai faute de temps en temps, le tire est mal fait et la balle sort
			b.setPosy((int)(Math.random()*(30+40)));
			if (b.getPosx()!=g2.getPosx() && b.getPosy()!=g2.getPosy()&& b.getPosy()<g2.getPosy()) {
				this.cmpt1++;
				System.out.println ("but marqué par l'equipe 1");
				jqdlb.ajouterpoint();
				jqdlb.ajouterbut();
			}
			else {
				System.out.println ("but raté par equipe 1");
				jqdlb.enleverpoint();
				
			}
		
		}
		
		else {
			b.setPosx((int)(Math.random()*(LIMX)));
			b.setPosy((int)((LIMY-(30)+(Math.random()*((LIMY+40)-(LIMY-(30)))))));
			if (b.getPosx()!=g1.getPosx() && b.getPosy()>g1.getPosy()&& b.getPosy()!=g1.getPosy()) {
				this.cmpt2++;
				System.out.println ("but marqué par l'equipe 2");
				jqdlb.ajouterpoint();
				jqdlb.ajouterbut();
			}
			
			else {
				System.out.println ("but raté par l'equipe 2");
				jqdlb.enleverpoint();
			}
		}
	}
}







