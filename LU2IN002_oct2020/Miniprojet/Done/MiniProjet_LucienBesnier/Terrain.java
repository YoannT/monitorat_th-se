public class Terrain{
	private Case[][] terrain;
	private final static int cst1=20;
	private final static int cst2=20;
	
	public Terrain(){
		terrain=new Case[cst1][cst2];
		
		//ajout de l'herbe
		for(int i = 0; i<20; i++){
			for (int j = 0; j<20; j++){
				terrain[i][j]=new Case();
				if(i==j || i+j==19){
					terrain[i][j].ajouterHerbes(new Herbes(i,j));
					}
				}
			}
			
		//ajout des chasseurs et des sangliers
		for(int i = 0; i<17; i++){
			Chasseur c = new Chasseur();
			terrain[c.getX()][c.getY()].ajouterChasseur(c);
			Sanglier s = new Sanglier();
			terrain[0][i+3].ajouterSanglier(s);
			Sanglier s1 = new Sanglier();
			terrain[i+3][0].ajouterSanglier(s);
			Sanglier s2 = new Sanglier();
			terrain[19][i+3].ajouterSanglier(s);
			Sanglier s3 = new Sanglier();
			terrain[i+3][19].ajouterSanglier(s);
			}
		
		//ajout des Paysans et des graines
		for(int i = 0; i<5; i++){
			Graine g = new Graine();
			terrain[g.getX()][g.getY()].ajouterGraine(g);
			Paysan p = new Paysan();
			terrain[p.getX()][p.getY()].ajouterPaysan(p);
			}

	}
	
	public void Vider(int i, int j){
		terrain[i][j]=new Case();
	}
		
	public void evolve(){
		int n = 0;
		for(int i = 0; i<20; i++){
			for (int j = 0; j<20; j++){
				/*//Evolution de l'herbe qui pousse
				if(terrain[i][j].getType()=="H"){
					int a = (int)(Math.random()*10);
					if (a>6){
						int x = (i+((int)(Math.random()*2)-1)+21)%20;
						int y = (j+((int)(Math.random()*2)-1)+21)%20;
						if (terrain[x][y].getType()==" "){
			 				terrain[x][y].ajouterHerbes(new Herbes(x,y));
							}
						}
					}*/
				//Les Sangliers Mangent les graines
				if(terrain[i][j].getType()=="S"){
					for(int x=-1;x<2;x++){
						for(int y=-1;y<2;y++){
							if(terrain[(i+x+20)%20][(j+y+20)%20].getType()=="G"){
								Vider((i+x+20)%20,(j+y+20)%20);
								System.out.println("Une graine a été mangé");
								break;
								}
							}
						}
					}
				//Les Chasseurs chassent les sangliers
				if(terrain[i][j].getType()=="C"){
					for(int x=-1;x<2;x++){
						for(int y=-1;y<2;y++){
							if(terrain[(i+x+20)%20][(j+y+20)%20].getType()=="S"){
								Vider((i+x+20)%20,(j+y+20)%20);
								System.out.println("Un sanglier a été chassé");
								}
							}
						}
					}
				//les Paysans sèment les graines
				if(terrain[i][j].getType()=="P"){
					int a = (int)(Math.random()*10);
					int b = (int)(Math.random()*2)-1;
					int c = (int)(Math.random()*2)-1;
							if(a>5){
								terrain[(i+b+20)%20][(j+c+20)%20].ajouterGraine(new Graine());
								}
					}
				//la population se déplace
				//Sanglier 
				if(terrain[i][j].getType()=="S"){			
					int a = (int)(Math.random()*2)-1;
					int b = (int)(Math.random()*2)-1;
					if(terrain[(i+a+20)%20][(j+b+20)%20].getType()==" "){
						terrain[(i+a+20)%20][(j+b+20)%20].ajouterSanglier(terrain[i][j].estSanglier());
						Vider(i,j);	
						}					
				}
				//Chasseur
				if(terrain[i][j].getType()=="C"){			
					int a = (int)(Math.random()*2)-1;
					int b = (int)(Math.random()*2)-1;
					if(terrain[(i+a+20)%20][(j+b+20)%20].getType()==" "){
						terrain[(i+a+20)%20][(j+b+20)%20].ajouterChasseur(terrain[i][j].estChasseur());
						Vider(i,j);	
						}					
				}
				//Paysan
				if(terrain[i][j].getType()=="P"){			
					int a = (int)(Math.random()*2)-1;
					int b = (int)(Math.random()*2)-1;
					if(terrain[(i+a+20)%20][(j+b+20)%20].getType()==" "){
						terrain[(i+a+20)%20][(j+b+20)%20].ajouterPaysan(terrain[i][j].estPaysan());
						Vider(i,j);	
						}					
				}
			}
		}
	}
	public boolean fin(){
		int nbG=0;
		int nbS=0;
		for(int i = 0; i<20; i++){
			for (int j = 0; j<20; j++){
				if(terrain[i][j].getType()=="S"){
					nbS++;
					}
				if(terrain[i][j].getType()=="G"){			
					nbG++;
					}
			}
		}
		
		if(nbS==0){
			System.out.println("Les chasseurs et les paysans ont gagnés");
			return false;
			}
		if(nbG==0){
			System.out.println("Les sangliers ont tous mangés");
			return false;
			}
		return true;
		}
						

							 	
	public String toString(){
		String s="-----------------------------------------\n";
		for(int i=0; i<terrain.length;i++){
			s+="|";
			for(int j=0;j<terrain[i].length;j++){
				//ajout graphique des personnages et des ressources
				s+=terrain[i][j].getType();		
				s+="|";
				}
			s+="\n";
			}
		return s+="-----------------------------------------\n";
		}	
}
