/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
import java.util.Scanner;
public class Simulation{
	private static int nbFauteTotale;
	private static Terrain ter;
	/**
	*Score du joueur 1 et du joueur 2
	*/
	private int p1,p2;
	private Joueur j1,j2;
	private Balle b;
	private boolean duce;
/**
	*Effet du joueur 1
	*/
	private boolean coupe1,lift1,smash1;
	/**
	*Effet du joueur 2
	*/
	private boolean coupe2,lift2,smash2;

	public Simulation(Joueur j1, Joueur j2, Terrain ter){
		this.ter=ter;
		p1=0;p2=0;
		this.j1=j1;this.j2=j2;
		duce=false;
		b=new Balle(1,1);
		nbFauteTotale=0;
		coupe1=false;
		lift1=false;
		smash1=false;
		coupe2=false;
		lift2=false;
		smash2=false;
	}

	public static String getnbFauteTotale(){
		return "Nombre de faute total durant le match : " + nbFauteTotale;
	}

	public void afficheClassement(){
		if(this.j2 != null && this.j1 != null)
      System.out.println("|Joueurs=\n-"+j1.getNom()+" est "+j1.getClassement()+"eme sur 100 joueurs\n-"+j2.getNom()+" est "+j2.getClassement()+"eme sur 100 joueurs\n");
		else
			System.out.println("Erreur d'affichage");
    }

/**
*Methode qui place la balle sur le terrain du joueur 1
*/
	public void placementBalleJ1(){
		Balle clone = b.clone();
		clone.randomDrop(36, 69, 1, 39);
		ter.removeBalleOutTerrain();
		ter.placeBalleInTerrain(clone);
		ter.afficheTerrain();
	}
	/**
	*Methode qui place la balle sur le terrain du joueur 2
	*/
	public void placementBalleJ2(){
		Balle clone = b.clone();
		clone.randomDrop(1, 33, 1, 39);
		ter.removeBalleOutTerrain();
		ter.placeBalleInTerrain(clone);
		ter.afficheTerrain();
	}

/**
	*Methode qui gere le deroulement du match pour le joueur 1
	*/
	public void serviceJ1(){
		for(int i=0 ; i<5 ; i++){
			if(p1==21 || p2==21){
				break;
			}
			boolean t1=false;
			if(j1 instanceof Pro){
				t1=j1.renvoyerBienPro(j2,coupe1,lift1,coupe1);
			}
			else{
				t1=j1.renvoyerBien();
			}
			if(!t1){
				nbFauteTotale++;
				//System.out.println("Service rat\u00e9");
				System.out.println("Point pour "+j2.getNom());
				p2++;
				this.placementBalleJ2();
				this.afficheScore();
				System.out.println("");
				continue;
			}
			else{
				this.placementBalleJ1();
				boolean t2=true;
				while(t1 && t2){
					if(j2 instanceof Pro){
						t2=j2.renvoyerBienPro(j1,coupe2,lift2,smash2);
					}
					else{
						t2=j2.renvoyerBien();
					}
					if(!t2)
						break;
					this.placementBalleJ2();
					if(coupe2 || lift2){
						j2.setPbtaper(j2.getPbtaper()+0.2);
						coupe2=false;
						lift2=false;
					}
					if(smash2){
						j2.setPbtaper(j2.getPbtaper()+0.4);
						smash2=false;
					}
					if(j1 instanceof Pro){
						t1=j1.renvoyerBienPro(j2,coupe1,lift1,smash1);
					}
					else{
						t1=j1.renvoyerBien();
					}
					if(t1){
						this.placementBalleJ1();
					}
					if(coupe1 || lift1){
						j1.setPbtaper(j1.getPbtaper()+0.2);
						coupe1=false;
						lift1=false;
					}
					if(smash1){
						j1.setPbtaper(j1.getPbtaper()+0.4);
						smash1=true;
					}
				}
				if(!t1){
					System.out.println(j2.getNom()+" marque un point");
					p2++;
					this.placementBalleJ1();
					this.afficheScore();
					System.out.println("");
				}
				else if(!t2){
					System.out.println(j1.getNom()+" marque un point");
					p1++;
					this.placementBalleJ2();
					this.afficheScore();
					System.out.println("");
				}
			}
			if(p1==20 && p2==20){
				System.out.println("Duce!");
				duce=true;
				break;
			}
		}
		if(p1!=21 && p2!=21)
			System.out.println("\nChangement de Service!\n");
		else if(p1==21 || p2==21)
			System.out.println("Fin de match");
	}


	/**
		*Methode qui gere le deroulement du match pour le joueur 2
		*/

	public void serviceJ2(){
		for(int i=0 ; i<5 ; i++){
			if(p1==21 || p2==21){
				break;
			}
			boolean t2=false;
			if(j2 instanceof Pro){
				t2=j2.renvoyerBienPro(j1,coupe2,lift2,coupe2);
			}
			else{
				t2=j2.renvoyerBien();
			}
			if(!t2){
				nbFauteTotale++;
				//System.out.println("Service rat\u00e9");
				System.out.println("Point pour "+j1.getNom());
				p1++;
				this.afficheScore();
				this.placementBalleJ1();
				System.out.println("");
				continue;
			}
			else{
				this.placementBalleJ2();
				boolean t1=true;
				while(t1 && t2){
					if(j1 instanceof Pro){
						t1=j1.renvoyerBienPro(j2,coupe1,lift1,smash1);
					}
					else{
						t1=j1.renvoyerBien();
					}
					if(!t1)
						break;
					this.placementBalleJ1();
					if(coupe1 || lift1){
						j1.setPbtaper(j1.getPbtaper()+0.2);
						coupe1=false;
						lift1=false;
					}
					if(smash1){
						j1.setPbtaper(j1.getPbtaper()+0.4);
						smash1=true;
					}
					if(j2 instanceof Pro){
						t2=j2.renvoyerBienPro(j1,coupe2,lift2,smash2);
					}
					else{
						t2=j2.renvoyerBien();
					}
					if(t2){
						this.placementBalleJ2();
					}
					if(coupe2 || lift2){
						j2.setPbtaper(j2.getPbtaper()+0.2);
						coupe2=false;
						lift2=false;
					}
					if(smash2){
						j2.setPbtaper(j2.getPbtaper()+0.4);
						smash2=false;
					}
				}
				if(!t1){
					System.out.println(j2.getNom()+" marque un point");
					p2++;
					this.afficheScore();
					System.out.println("");
				}
				else if(!t2){
					System.out.println(j1.getNom()+" marque un point");
					p1++;
					this.afficheScore();
					System.out.println("");
				}
			}
			if(p1==20 && p2==20){
				System.out.println("Duce!");
				duce=true;
				break;
			}
		}
		if(p1!=21 && p2!=21)
			System.out.println("\nChangement de Service!\n");
	}


	public void afficheScore(){
		System.out.println(j1.getNom()+" : "+ p1 + " | " + p2 + " : " + j2.getNom());
	}

/**
	* Methode qui permet de jouer s'il y a egalite entre les joueurs
	*@return Le vainqueur
	*/
	public Joueur duce(Joueur j){
		Joueur c=j;
		while(Math.abs(p1-p2)<2){
			if(c==j1){
				boolean t1=false;
				if(j1 instanceof Pro){
					t1=j1.renvoyerBienPro(j2,coupe1,lift1,coupe1);
				}
				else{
					t1=j1.renvoyerBien();
				}
				if(!t1){
					c=j2;
					System.out.println(j2.getNom()+" marque un point");
					p2++;
					continue;}
				else{
					this.placementBalleJ1();
					System.out.println("Match point!");
					this.afficheScore();
					boolean t2=true;
					while(t1 && t2){
						if(j2 instanceof Pro){
							t2=j2.renvoyerBienPro(j1,coupe2,lift2,smash2);
						}
						else{
							t2=j2.renvoyerBien();
						}
						if(!t2)
							break;
						this.placementBalleJ2();
						if(coupe2 || lift2){
							j2.setPbtaper(j2.getPbtaper()+0.2);
							coupe2=false;
							lift2=false;
						}
						if(smash2){
							j2.setPbtaper(j2.getPbtaper()+0.4);
							smash2=false;
						}
						if(j1 instanceof Pro){
							t1=j1.renvoyerBienPro(j2,coupe1,lift1,smash1);
						}
						else{
							t1=j1.renvoyerBien();
						}
						if(t1){
							this.placementBalleJ1();
						}
						if(coupe1 || lift1){
							j1.setPbtaper(j1.getPbtaper()+0.2);
							coupe1=false;
							lift1=false;
						}
						if(smash1){
							j1.setPbtaper(j1.getPbtaper()+0.4);
							smash1=true;
						}
					}
					if(!t1){
						System.out.println(j2.getNom()+" marque un point");
						p2++;
						this.afficheScore();
					}
					else if(!t2){
						System.out.println(j1.getNom()+" marque un point");
						p1++;
						this.afficheScore();
					}
					c=j2;
				}
			}
			if(c==j2){
				boolean t2=false;
				if(j2 instanceof Pro){
					t2=j2.renvoyerBienPro(j1,coupe2,lift2,smash2);
				}
				else{
					t2=j2.renvoyerBien();
				}
				if(!t2){
					c=j1;
					System.out.println(j1.getNom()+" marque un point");
					p1++;
					continue;
				}
				else{
					this.placementBalleJ2();
					System.out.println("Match point!");
					this.afficheScore();
					boolean t1=true;
					while(t1 && t2){
						if(j1 instanceof Pro){
							t1=j1.renvoyerBienPro(j2,coupe1,lift1,smash1);
						}
						else{
							t1=j1.renvoyerBien();
						}
						if(!t1)
							break;
						this.placementBalleJ1();
						if(coupe1 || lift1){
							j1.setPbtaper(j1.getPbtaper()+0.2);
							coupe1=false;
							lift1=false;
						}
						if(smash1){
							j1.setPbtaper(j1.getPbtaper()+0.4);
							smash1=true;
						}
						if(j2 instanceof Pro){
							t2=j2.renvoyerBienPro(j1,coupe2,lift2,smash2);
						}
						else{
							t2=j2.renvoyerBien();
						}
						if(t2){
							this.placementBalleJ2();
						}
						if(coupe2 || lift2){
							j2.setPbtaper(j2.getPbtaper()+0.2);
							coupe2=false;
							lift2=false;
						}
						if(smash2){
							j2.setPbtaper(j2.getPbtaper()+0.4);
							smash2=false;
						}
					}
					if(!t1){
						System.out.println(j2.getNom()+" marque un point");
						p2++;
						this.afficheScore();
					}
					else if(!t2){
						System.out.println(j1.getNom()+" marque un point");
						p1++;
						this.afficheScore();
					}
					c=j1;
				}
			}
		}
		if(p1<p2){return j2;}
		return j1;
	}

/**
*Methode qui execute un match classique
*@return Le vainqueur
*/
	public Joueur matchClassique(){
		Joueur res = null;
		this.afficheClassement();
		Gestion.parisportif(j1,j2);
		System.out.println("\n\n-----------------\n\n");
		System.out.println("Choix du service : \n-nombre pair -> Joueur1\n-nombre impair -> Joueur2\n");
		Scanner clavier = new Scanner(System.in);
		int t = Integer.parseInt(clavier.nextLine());
		System.out.println("\n\n Debut du Match ! \n\n");
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
		while(p1<21 && p2<21){
			if(t%2==0){
				try{
					Thread.sleep(800);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
				this.serviceJ2();
				if(duce){
					res=this.duce(j1);
					break;
				}
				t++;
			}
			if(t%2==1){
				try{
					Thread.sleep(800);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
				this.serviceJ1();
				if(duce){
					res=this.duce(j2);
					break;
				}
				t++;
			}
		}
		if(p2<p1){
			System.out.println("La vainqueur de ce match est "+j1.getNom());
			j1.setClassement(j1.getClassement()-1);
			j2.setClassement(j2.getClassement()+1);
			res=j1;
			Gestion.setCoteJ1(2);
		}
		if(p2>p1){
			System.out.println("La vainqueur de ce match est "+j2.getNom());
			j2.setClassement(j2.getClassement()-1);
			j1.setClassement(j1.getClassement()+1);
			res=j2;
		 	Gestion.setCoteJ2(2);
		}
		this.afficheClassement();
		return res;
	}

/**
*Methode qui permet d'ordonne les joueurs selon leur classement
*/
	public static Joueur[] ordonneList(Joueur[] tab){
		Joueur[] res=tab;
		for(int i=0;i<res.length;i++){
			for(int j=i;j<res.length;j++){
				if(res[i].getPointTournois()>res[j].getPointTournois()){
					Joueur temp=res[i];
					res[i]=res[j];
					res[j]=temp;
				}
			}
		}
		return res;
	}


/**
*Methode qui execute un tournoi
*/
	public void tournois(Joueur[] tabl, Terrain t){
        System.out.println("\n\n-----------------\n\n");
				Joueur[] tab=tabl;
				for(int test=0;test<tab.length;test++){
					if(tab[test] instanceof Amateur){
						System.out.println("Il y a un amateur dans les participants. Impossible de debuter le tournoi");
						System.exit(0);
					}
				}
        System.out.println("\n\n Debut du Tournois ! \n\n");
        for(int i=0;i<tab.length;i++){
            for(int j=i;j<tab.length;j++){
                if(j==i)
                    continue;
                Simulation temp= new Simulation(tab[i],tab[j],t);
								for(int k=0;k<tab.length;k++){
                    if(k==i || k==j){
                        continue;
                    }
									if(tab[k] instanceof ProHomme){
                    ((ProHomme)tab[k]).pause();
										System.out.println(((ProHomme)tab[k]).getNom()+ " ne joue pas et prend une pause, augmentation de la probabilit\u00e9 de smash de 0.01");
                	}
									else if(tab[k] instanceof ProFemme){
										((ProFemme)tab[k]).pause();
										System.out.println(((ProFemme)tab[k]).getNom()+ " ne joue pas et prend une pause, augmentation de la probabilit\u00e9 de r\u00e9ussir le lift et le coup\u00e9 de 0.01");
									}
            	}
                Joueur q=temp.matchClassique();
                if(q==tab[i])
                    tab[i].setPointTournois(tab[i].getPointTournois()+1);
                if(q==tab[j])
                    tab[j].setPointTournois(tab[j].getPointTournois()+1);
						}
        }
        Joueur[] result=Simulation.ordonneList(tab);
        for(int k=1 ; k< result.length+1; k++){
            if(k==1){
                System.out.println("Le "+k+"er est "+result[k-1].getNom()+", il a gagne "+result[k-1].getPointTournois()+" points et son classement final est "+result[k-1].getClassement());
            }
            else{
                System.out.println("Le "+k+"eme est "+result[k-1].getNom()+", il a gagne "+result[k-1].getPointTournois()+" points et son classement final est "+result[k-1].getClassement());
            }
        }
    }
/**
*Methode qui permet de s'entrainer avant le jour J
*/
	public void entrainementAvantCompetition(int jours, Pro joueur){
		System.out.println(jours + " jours avant le match de "+joueur.getNom());
		for(int i=1; i<jours ; i++){
			System.out.println("Jour "+i);
			try{
				Thread.sleep(200);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			if (joueur instanceof ProHomme){
				if (Math.random()*1< 0.5){
					((ProHomme)joueur).entrainementTaper();
					System.out.println(joueur.getNom()+" entraine sa probabilite de taper correctement la balle de 0.05");
				}
				else{
					((ProHomme)joueur).secherEntrainement();
					System.out.println(joueur.getNom()+" seche l'entrainement, sa probabilit\u00e9 de taper correctement balle diminue de 0.03 !");
				}
			}
			else if(joueur instanceof ProFemme){
				if (Math.random()*1< 0.5){
					((ProFemme)joueur).entrainementPrecision();
					System.out.println(joueur.getNom()+" augmentation de la pr\u00e9cision de 0.1");
				}
				else{
					((ProFemme)joueur).secherEntrainement();
					System.out.println(joueur.getNom()+" seche l'entrainement et perds 0.05 de pr\u00e9cision !");
				}
			}
		}
		System.out.println("\n\n");
	}
}
