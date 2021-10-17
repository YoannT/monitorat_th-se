package football;
import java.util.ArrayList;

	public class Equipe implements Match {
			String NomEquipe;
			int matchperdus;
			int matchgagnes;
			int matchnuls;
			int NombrePoints;
			int [] resultat;
			Joueur []joueur;
			Entraineur entraineur;
			ArrayList<Joueur> joueurmatch;
			public Equipe(String n) {
				this.joueur= new Joueur[22];
				this.joueurmatch= new ArrayList<Joueur>();
				this.matchgagnes= 0;
				this.matchnuls= 0;
				this.matchperdus= 0;
				this.NombrePoints=0;
				this.resultat= new int [2];
				this.NomEquipe=n;
				this.entraineur=null;
				
			}
			public void SelectionnerEquipe() {


				this.joueur[0]= new GardienDeBut(1,100000,10000,"Gardien de but");
				
				this.joueur[1]= new GardienDeBut(2,120000,90000,"Gardien de but");
				
				ArrayList listeNum1= new ArrayList();
				ArrayList listeNum2= new ArrayList();

				for(int i=0;i<10;i++) {
					int pr= (int)(Math.random()*10000+3000);
					int s= (int)(Math.random()*150000+60000);
					int num= (int)(Math.random()*60+30);
					
					while(listeNum1.contains(num)){
						
						num= (int)(Math.random()*29+3);
					}
					this.joueur[i+2]= new Attaquant(num,s,pr,"Attanquant");
						listeNum1.add(num);
				}
				
				for(int i=0;i<10;i++) {
					
					int pr= (int)(Math.random()*10000+3000);
					int s= (int)(Math.random()*150000+60000);
					int num= (int)(Math.random()*29+3);
					
					while(listeNum2.contains(num)){
						
						num= (int)(Math.random()*29+3);
					}
					this.joueur[12+i]= new Attaquant(num,s,pr,"Defenseur");
					listeNum2.add(num);
				}
			}
			
			
			
			public void selection() {
				System.out.println("la formation de l'equipe est 4-3-3");
				for (int i=0;i<22;i++) {
					if(joueur[i] instanceof GardienDeBut) {
						joueurmatch.add(joueur[i]);
						break;
					}
					
				}
				int compteur=0;
				for (int i=0;i<22;i++) {
					if(joueur[i] instanceof Defenseur) {
						joueurmatch.add(joueur[i]);
						compteur++;
						if (compteur==4) break;
					}
					
				}
				compteur=0;
				for (int i=0;i<22;i++) {
					if(joueur[i] instanceof Attaquant) {
						joueurmatch.add(joueur[i]);
						compteur++;
						if (compteur==6) break;
					}
			}			
		}
			public void AfficherSelection() {
				System.out.println("la formation de l'equipe est: ");
				for(int i=0;i<joueurmatch.size();i++) {
					System.out.println(joueurmatch.get(i).toString());
				}
			}
			
			public void AfficherStats() {
				System.out.println("l'equipe "+ this.NomEquipe);
				System.out.println("a gagne: "+ this.matchgagnes+" matchs ");
				System.out.println("a perdu : "+ this.matchperdus +" matchs");
				System.out.println("et a : "+ this.matchnuls+" matchs nuls");
			}
			@Override

			public void jouer(Equipe p) {
				
				
				System.out.println("le match a commence");
				System.out.println("Match en cours");
				System.out.println("L'arbitre declare la fin du match");
				
				this.resultat[0]= (int)(Math.random()*5);
				this.resultat[1]= (int)(Math.random()*5);
				
				p.resultat[0]=this.resultat[1];
				p.resultat[1]=this.resultat[0];
				
				if (this.resultat[0]>this.resultat[1]) {
					this.matchgagnes++;
					p.matchperdus++;
				}
					else if (this.resultat[0]<this.resultat[1]) {
						p.matchgagnes++;
						this.matchperdus++;
					}
					else {
						this.matchnuls++;
						p.matchnuls++;
					}
				this.NombrePoints= 3*this.matchgagnes+this.matchnuls;
				p.NombrePoints= 3*p.matchgagnes+p.matchnuls;
				}
			
			
			public String toString() {
				String s= "";
				s+= "l'equipe "+this.NomEquipe+" d entraineur "+ this.entraineur.nom+" de joueurs :\n";
				for(int i=0;i<this.joueur.length;i++) {
					s+=joueur[i].toString()+"\n";
				}
				s+=" a gagne: "+ this.matchgagnes+" \n et a perdu: "+this.matchperdus+" \n et a "+this.matchnuls+ " matchs nuls \n";
				s+= "et a comme total de points : "+ this.NombrePoints;				
				return s;
			}

		}



