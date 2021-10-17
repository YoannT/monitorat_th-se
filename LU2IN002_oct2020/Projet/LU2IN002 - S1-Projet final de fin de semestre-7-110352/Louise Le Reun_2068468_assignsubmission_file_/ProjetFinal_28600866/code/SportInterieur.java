
/**
* Cette classe permet de creer des Sports d'Interieur
* @author Louise Le Reun
*/
public abstract class SportInterieur extends Sport{
	protected boolean salleEstLibre;

	/**Constructeur de Sport d'Interieur
	@param nbJoueur nombre de Joueur dans chaque equipe
	@param jour jour dedie au sport
	@param nom nom de la seance (junior, avance,etc.)
	@param salleEstLibre boolean qui indique si la salle est libre
	*/
	protected SportInterieur(int nbJoueur,String jour, String nom, boolean salleEstLibre){
		super(nbJoueur,jour,nom);
		this.salleEstLibre=salleEstLibre;
	}

	/**{@inheritDoc}
	*/
	public String toString(){
		return "nom : "+nom+"\nnombre de joueurs dans chaque equipe : "+nbJoueur+"\njour dedie :"+jour+"\nLa salle est libre ?"+salleEstLibre;
	}

	/**libere la salle
	*/
	public void libereSalle(){
		salleEstLibre=true;
	}

	/**Accesseur de SalleEstLibre
	@return true si la salle est libre, false sinon
	*/
	public boolean getSalleLibre(){
		return salleEstLibre;
	}
}