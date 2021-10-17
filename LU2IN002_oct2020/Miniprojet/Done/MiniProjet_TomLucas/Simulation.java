public class Simulation{

	Ressource e1 = new Ressource("1Plantes à graines",10);
	Ressource e2 = new Ressource("2Plantes à fruit",15);
	Ressource e3 = new Ressource("3Plantes à graines infestées de chenilles",10);
	Ressource e4 = new Ressource("4Plantes à fruit infestées de chenilles",10);
	public Simulation(int x,int y){
		Terrain t= new Terrain(x,y);
		int i;
		int j;
		for(i=0;i<t.nbColonnes;i++){
			for(j=0;j<t.nbLignes;j++){
				if(Math.random()<0.25){
					if(Math.random()<0.25){
						if(Math.random()<0.25){
							t.setCase(j,i,e1);
						}
						else{
							t.setCase(j,i,e2);
						}
					}
					else{
						if(Math.random()<0.25){
							t.setCase(j,i,e3);
						}
						else{
							t.setCase(j,i,e4);
						}
					}
				}
			}
		}
	}
	public Simulation(){
	Fourmi[] F= new Fourmi[10];
	Terrain t= new Terrain(10,10);
	t.setCase(3,2,new Ressource("2Plantes à fruit",15));
	t.setCase(5,2,new Ressource("1Plantes à graines",10));
	t.setCase(7,2,new Ressource("1Plantes à graines",10));
	t.setCase(3,3,new Ressource("2Plantes à fruit",15));
	t.setCase(5,3,new Ressource("2Plantes à fruit",15));
	t.setCase(7,3,new Ressource("3Plantes à graines infestées de chenilles",10));
	t.setCase(7,4,new Ressource("4Plantes à fruit infestées de chenilles",10));
	t.setCase(9,9,new Ressource("4Plantes à fruit infestées de chenilles",10));
	t.setCase(1,1,new Ressource("2Plantes à fruit",15));
	Fourmillière ruche= new Fourmillière(5,6);
	F[0]= new Fourmiagricolt(7,7);
	F[1]= new Fourmiagricolt(7,7);
	F[2]= new Fourmiagricolt(7,7);
	F[3]= new Fourmiagricolt(7,7);
	F[4]= new Fourmirécolteuse(7,7);
	F[5]= new Fourmirécolteuse(7,7);
	F[6]= new Fourmirécolteuse(7,7);
	F[7]= new Fourmirécolteuse(7,7);
	Fourmiagricolt ag1= new Fourmiagricolt(7,7);
	Fourmirécolteuse réc1= new Fourmirécolteuse(7,7);
	réc1.déplacer(3,2);
	réc1.récolter(t);
	//System.out.println(t.getCase(3,2));
	//t.affiche();
	réc1.déplacer(5,6);
	réc1.déchargées(ruche);
	réc1.déplacer(5,2);
	réc1.récolter(t);
	//System.out.println(t.getCase(5,2));
	t.affiche();
	réc1.déplacer(5,6);
	réc1.déchargées(ruche);
	System.out.println(ruche.get_reserve());//il y a 15 fruit et 20 graines dans la fourmillière
	//t.affiche();
	System.out.println(ruche.get_reserve());
	réc1.déplacer(7,2);
	réc1.attendre(t);
	réc1.déplacer(5,2);
	réc1.attendre(t);
	réc1.déplacer(7,2);
	réc1.attendre(t);
	System.out.println(ruche.get_reserve());// En attendant les plantes on pu se régénérer, mais certaine on pue être colonisée par des chenilles et d'autre mangées par un herbivore.
	//Maintenent je veux de la viande.
	réc1.déplacer(7,3);
	réc1.récolter(t);
	réc1.déplacer(5,6);
	réc1.déchargées(ruche);
	réc1.déplacer(7,4);
	réc1.récolter(t);
	réc1.déplacer(5,6);
	réc1.déchargées(ruche);
	System.out.println(ruche.get_reserve());//Je viens de rajouter 20 chenilles.
	//Je veux encore plus de viandes, je peux metre des chenilles dans des plantes pour commencer une production plus importante de chenilles.
	réc1.déplacer(9,9);
	réc1.récolter(t);
	réc1.déplacer(3,3);
	réc1.semmée(t);
	réc1.déplacer(5,3);
	réc1.semmée(t);
	réc1.déplacer(5,6);
	réc1.déchargées(ruche);
	t.affiche();//Je peux planté
	réc1.déplacer(1,1);
	réc1.récolter(t);

	réc1.déplacer(1,2);
	réc1.semmée(t);
	t.affiche();
	réc1.déplacer(5,6);
	réc1.déchargées(ruche);//je peux désherber
	ag1.déplacer(1,1);
	ag1.désherber(t);
	t.affiche();
	System.out.println(ruche.get_reserve());
	System.out.println("Bien! Vous avez sufisament de nouriture pour passez l'hiver!");
	}
}
	
	
