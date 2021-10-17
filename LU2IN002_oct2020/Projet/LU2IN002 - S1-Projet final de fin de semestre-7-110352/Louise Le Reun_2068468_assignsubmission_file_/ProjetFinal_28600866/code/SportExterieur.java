/**
* Cette classe permet de creer des Sports d'Exterieur
* @author Louise Le Reun
*/
public abstract class SportExterieur extends Sport{
	protected String meteo;

	/**Constructeur de Sport d'Exterieur
	@param nbJoueur nombre de Joueur dans chaque equipe
	@param jour jour dedie au sport
	@param nom nom de la seance (junior, avance,etc.)
	@param meteo meteo du jour
	*/
	protected SportExterieur(int nbJoueur,String jour,String nom, String meteo){
		super(nbJoueur,jour,nom);
		this.meteo=meteo;
	}

	/**{@inheritDoc}
	*/
	public String toString(){
		return "nom : "+nom+"\nnombre de joueurs dans chaque equipe : "+nbJoueur+"\njour dedie :"+jour+"\nmeteo du jour :"+meteo;
	}

	/**Accesseur de la meteo
	@return la meteo
	*/
	public String getMeteo(){
		return meteo;
	}

	/**Indique les vetements a prevoir selon la meteo
	*/
	public void vetements(String meteo){
		if(meteo=="pluie"){
			System.out.println("Il faut prendre un K-way");
		}else if(meteo=="neige"){
			System.out.println("Il faut des vetements chauds");
		}else if(meteo=="soleil"){
			System.out.println("Il faut une casquette ou un chapeau");
		}
	}
}