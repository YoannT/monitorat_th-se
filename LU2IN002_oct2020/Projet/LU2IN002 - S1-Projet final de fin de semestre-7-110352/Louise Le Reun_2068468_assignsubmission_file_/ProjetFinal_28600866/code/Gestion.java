import java.util.ArrayList;
/**
*Cette classe permet de creer la gestion du club
*@author Louise Le Reun
*/
public final class Gestion{
	public ArrayList<Personne> adherents;
	public final int NBLIGNES= 4;
	public final int NBCOLONNES= 7;
	public String[][] edt;
	private static Gestion instance;

	/**Constructeur de la gestion
	@param adherents liste d'adherents du club
	*/
	private Gestion(ArrayList<Personne> adherents){
		this.adherents=adherents;
		this.edt= new String[NBLIGNES][NBCOLONNES];
	}

	/**cree l'unique instance de Gestion
	@param adherents liste d'adherents du club
	*/
	public static Gestion getInstance(ArrayList<Personne> adherents){
		if(instance==null){
			instance= new Gestion(adherents);
		}
		return instance;
	}

	/**affiche la liste des noms des adherents du club
	*/
	public void afficheAdherent(){
		for(Personne p:adherents){
			System.out.print(p.getNom()+"\t");
		}
		System.out.println("");
	}

	/**Accesseur d'une case du tableau
	@param ligne ligne de la case
	@param colonne colonne de la case
	@return le contenu de la case
	*/
	public String getCase(int ligne, int colonne){
		return edt[ligne][colonne];
	}

	/**Place le cours passe en paramtre dans une case
	@param ligne ligne de la case
	@param colonne colonne de la case
	@param cours cours a placer dans la case
	*/
	public void setCase(int ligne, int colonne, String cours){
		edt[ligne][colonne]=cours;
	}

	/**Vide la case passee en parametre
	@param ligne ligne de la case
	@param colonne colonne de la case
	*/
	public void videCase(int ligne,int colonne){
		edt[ligne][colonne]="   -    ";
	}

	/**Affichage de l'emploi du temps
	*/
	public void afficher(){
		for(int i=0 ; i<4 ; i++){
			for(int j=0 ; j<7 ; j++){
				System.out.print(edt[i][j]+"\t");
			}
		System.out.println("");
		}
	}

	/**Calcule le chiffre d'affaire annuel du club
	@param adherents liste d'adherents du club
	@return le benefice total
	*/
	public int chiffreAffaire(ArrayList<Personne> adherents){
		int somme=0;
		for(Personne p:adherents){
			somme=somme+p.tarifAnnuel(p.getAge());
		}
		return somme;
	}

	/**Enleve une personne qui souhaite quitter le club
	@param p personne a enlever
	*/
	public void desabonnement(Personne p){
		adherents.remove(p);
		System.out.println(p.getNom()+" s'est desabonne.");
	}

	/**Ajoute une personne au club
	@param p personne a ajouter
	*/
	public void abonnement(Personne p){
		adherents.add(p);
	}
}