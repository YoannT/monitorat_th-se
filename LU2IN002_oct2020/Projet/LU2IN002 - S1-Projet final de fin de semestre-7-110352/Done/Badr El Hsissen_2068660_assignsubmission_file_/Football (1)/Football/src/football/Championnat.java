package football;

public class Championnat {
		int NombreEquipes;
		Equipe [] equipes;
		
		public Championnat(int n) {
			this.NombreEquipes=n;
			equipes= new Equipe[n];
		}
		
		public void ChargerEquipe(int nj) {
			int i;
			Equipe equi;
			String [] clubs= {"Dijon","PSG","OM","OL","Nantes","Rouen","Rennes","Montpellier","Monaco","Lille"};
			Entraineur [] entraineur;
			
			String [] nom= {"Linares","Pochettino","Villas-Boas","Garcia","Domenech","Giguel","Stephan","Der Zakarian","Kovac","Galtier"};
			entraineur= new Entraineur [nom.length];
			for (int o=0;o<clubs.length;o++) {
				entraineur[o]= new Entraineur(nom[o]);			
			}
			for(i=0;i<this.NombreEquipes;i++) {
				equi= new Equipe(clubs[i]);
				equi.SelectionnerEquipe();
				equipes[i]= equi;
				equipes[i].entraineur=entraineur[i];
			}
	}
		
		public void Tirage() {
			
		
			
			for(int i=0;i<this.NombreEquipes-1;i++) {
				
				for (int j=i+1;j<this.NombreEquipes;j++) {
					equipes[i].jouer(equipes[j]);
				}
			}
			
		}
		
		public void Classement() {
			int i,j;
			Equipe e1;
			for(i=0;i<equipes.length-1;i++) {
				for(j=i+1;j<equipes.length;j++) {
					if(equipes[i].NombrePoints<equipes[j].NombrePoints) {
						e1=equipes[i];
						equipes[i]=equipes[j];
						equipes[j]=e1;
					}
				}
			}
		}
		public Equipe ChampionLigue() {
			Equipe e1;
			int max=equipes[0].NombrePoints;
			e1=equipes[0];
			for(int i=1;i<equipes.length;i++) {
				if (max<equipes[i].NombrePoints) {
					max=equipes[i].NombrePoints;
					e1=equipes[i];
				}	
			}

			return e1;		
		}
	}


