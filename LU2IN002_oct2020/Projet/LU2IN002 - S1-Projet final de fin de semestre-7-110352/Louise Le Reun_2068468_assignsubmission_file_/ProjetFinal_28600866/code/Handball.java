import java.util.ArrayList;
/**
* Cette classe permet de creer du Handball
* @author Louise Le Reun
*/
public class Handball extends SportInterieur{

	/**Constructeur de Handball
	@param nbJoueur nombre de joueur dans chaque equipe
	@param jour jour dedie au hand
	@param nom nom de la seance de hand (junior, avance, etc.)
	@param salleEstLibre boolean qui indique si la salle est libre
	*/
	public Handball(int nbJoueur,String jour,String nom,boolean salleEstLibre){
		super(nbJoueur,jour,nom,salleEstLibre);
	}

	/**ajoute une personne dans une des equipes du sport
	*/
	public void ajouterEquipe(Personne p){
		if(equipe1.size()<nbJoueur){
			equipe1.add(p);
		}else if(equipe2.size()<nbJoueur){
			equipe2.add(p);
		}else{
			System.out.println("Les equipes de handball sont completes.");
			System.out.println("");
		}
	}

	/**Accesseur de l'equipe 1
	@return l'equipe 1
	*/
	public ArrayList<Personne> getEquipe1(){
		return equipe1;
	}

	/**Accesseur de l'equipe 2
	@return l'equipe 2
	*/
	public ArrayList<Personne> getEquipe2(){
		return equipe2;
	}

	/**affiche le nom des membres de l'equipe passee en parametre
	@param equipe equipe a afficher
	*/
	public void afficheEquipe(ArrayList<Personne> equipe){
		for(Personne i:equipe){
			System.out.print(i.getNom()+"\t");
		}
		System.out.println("");
	}

	/**{@inheritDoc}
	@param equipe1 equipe 1 de hand
	@param equipe2 equipe 2 de hand
	@exception ErrEquipe si l'une des listes est vide
	*/
	public String match(ArrayList<Personne> equipe1,ArrayList<Personne> equipe2) throws ErrEquipe{
		if(equipe1==null || equipe2==null){
			throw new ErrEquipe("les equipes de Hand sont vides, il ne peut pas y avoir de match");
		}else{
			int gagnant=(int)(Math.random()*10)%2;
			if(salleEstLibre){
				if(gagnant==0){
					return "l'equipe 1 a gagne le match de handball";
				}else{
					return "l'equipe 2 a gagne le match de handball";
				}
			}else{
				return "desole, la salle n'est pas disponible pour le match de handball";
			}
		}
	}
}