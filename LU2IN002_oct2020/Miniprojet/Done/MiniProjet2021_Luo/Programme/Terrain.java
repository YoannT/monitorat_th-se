public class Terrain{
	private int nbColonnes;
	private int nbLignes ;
	private static int NBCOLONNESMAX= 20;
	private static int NBLIGNESMAX= 20;
	public Ressource [][] terrain;
	
	public Terrain(){
		this(NBLIGNESMAX,NBCOLONNESMAX);
		
	}
	
	public Terrain(int NbL, int NbC){
		super();
		nbColonnes = NbC;
		nbLignes = NbL;
		if ((NbL > NBLIGNESMAX)||(NbC>NBCOLONNESMAX)) terrain= new Ressource [1][1];
		else {
			terrain= new Ressource [nbLignes][nbColonnes];
			for (int i=0; i<nbLignes; i++){
				for(int j=0; j<nbColonnes; j++) terrain[i][j]=null;
			}
		}
		
	}
	
	public void affiche() {
		for(int i = 0 ; i < nbLignes; i++) {
			for(int j = 0; j<nbColonnes;j++) {
			System.out.print(":-----");
	
			}
			System.out.print(":");
			System.out.println();
			for(int j =0 ; j< nbColonnes;j++){
				if(!caseEstVide(i, j)){
					String tmp = "Order " + terrain[i][j].getIdent() + ":" + terrain[i][j].getQuantite() + " " + terrain[i][j].getType() ;
					System.out.print(String.format("|%-5s", tmp));
				}
				else{
					System.out.print("|     ");
				}
			}
			System.out.print("|");
			System.out.println();
		}
		for (int i =0 ; i< nbColonnes;i++) {
			System.out.print(":-----");
			
		}
		System.out.print(":\n\n");
		for(int i = 0; i < 3; i++){
			System.out.println("##########");
		}
		System.out.println();
	}
	
	public Ressource getCase(int lig,int col){
		return terrain[lig][col];
	}
	
	public Ressource videCase (int lig, int col){
		if(caseEstVide(lig,col)){
			return null;
		}
		else{
			Ressource tmp = terrain[lig][col];
			terrain[lig][col] = null ;
			return tmp ; 
	
		}
	}
	
	public void setCase(int lig,int col,Ressource ress){
		terrain[lig][col]=ress;
	}
	
	public boolean caseEstVide(int lig, int col){
		return terrain[lig][col] == null && sontValide(lig, col);
	}
	
	public boolean sontValide(int lig, int col){
		return col<nbColonnes || lig <nbLignes || col> 1 || lig >1;
	}
	
	public String toString() {
        return "Terrain [nbColonnes=" + nbColonnes + ", nbLigne=" + nbLignes + "]";
    }
}
		