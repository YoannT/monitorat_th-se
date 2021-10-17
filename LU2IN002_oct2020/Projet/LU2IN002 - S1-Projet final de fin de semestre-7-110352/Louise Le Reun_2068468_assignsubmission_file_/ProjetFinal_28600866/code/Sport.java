import java.util.ArrayList;
/**
* Cette classe permet de creer des Sports
* @author Louise Le Reun
*/
public abstract class Sport{
	protected int nbJoueur;
	protected String jour;
	protected String nom;
	protected ArrayList<Personne> equipe1, equipe2;

	/**Constructeur de Sport
	@param nbJoueur nombre de joueur par equipe
	@param jour jour dedie au sport
	@param nom nom du sport
	*/
	protected Sport(int nbJoueur,String jour, String nom){
		this.nbJoueur=nbJoueur;
		this.jour=jour;
		this.nom=nom;
		equipe1= new ArrayList<Personne>();
		equipe2= new ArrayList<Personne>();

	}
	/**Accesseur du nombre de joueur
	@return le nombre de joueur dans chaque equipe
	*/
	public int getNbJoueur(){
		return nbJoueur;
	}

	/**Accesseur du jour dedie au sport
	@return le jour du sport
	*/
	public String getJour(){
		return jour;
	}

	/**Accesseur du nom du sport
	@return le nom du sport (niveau junior, avance, etc.)
	*/
	public String getNom(){
		return nom;
	}

	/**Donne les informations sur le sport
	@return les informations*/
	public abstract String toString();
	
	/**Simule un match entre deux equipes
	@param equipe1 equipe 1
	@param equipe2 equipe 2
	@exception ErrEquipe si la ou les equipes sont vides
	@return l'equipe gagnante*/
	public abstract String match(ArrayList<Personne> equipe1,ArrayList<Personne> equipe2) throws ErrEquipe;
}