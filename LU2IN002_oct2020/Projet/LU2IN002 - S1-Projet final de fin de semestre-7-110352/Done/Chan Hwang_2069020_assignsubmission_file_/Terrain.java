/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public class Terrain{
	private static Terrain terrain=null;
	private String[][] table;

	/**
	* Constructeur standard qui cree la table de ping pong fixe
	*/
	private Terrain(){
		table= new String[40][70];
		/*la longeur(L) du terrain reel vaut 274cm et sa largeur(l) 152.5cm et
		le diametre d'une balle ping pong est 4cm ainsi lorsque divise L et l par 4
		et par arrondi on obtient 68 cases sur la longueur et 38 cases sur la largeur.*/

		
		//Initialisation par des espaces*/
		for(int i = 0 ; i < table.length ; i++){
			for(int j = 0 ; j < table[0].length ; j++){
				table[i][j]="  ";
			}
		}

		//Les bords
		for(int i = 0 ; i < table[0].length ; i++){
			table[0][i] = "+ ";
			table[(table.length)-1][i] = "+ ";
		}
		for(int j = 1 ; j < (table.length-1) ; j++){
			table[j][0] = "+ ";
			table[j][table[0].length-1] = " +";
		}

		//le filet
		for(int k = 1 ; k < (table.length-1) ; k++){
			table[k][34] = "+ ";
			table[k][35] = "+";
		}
	}


	public String toString(){
			return "Je suis un Table de ping pong !";
		}
/**
	* Methode utilisant le pattern singleton
	*@return La table de ping pong unique
	*/
	public static Terrain singletonTerrain(){
		if(terrain==null){
			terrain= new Terrain();
		}
		return terrain;
	}



	public void afficheTerrain(){
		for(int i = 0 ; i < table.length ; i++){
			for(int j = 0 ; j < table[0].length ; j++){
				System.out.printf(table[i][j]);
			}
			System.out.println("");
		}
	}


	public void placeBalleInTerrain(Balle b){
		table[b.getY()][b.getX()]="@ ";
	}


	public void removeBalleOutTerrain(){
		for(int i = 0 ; i < table.length ; i++){
			for(int j = 0 ; j < table[0].length ; j++){
				if(table[i][j]=="@ ")
					table[i][j]="  ";
			}
		}
	}



}
