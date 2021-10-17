import java.util.ArrayList;
import java.lang.reflect.Constructor;


class Pays{
	private String nom;
	private ArrayList<Athlete> athletes;
	private int nbMOr,nbMArgent,nbMBronze;
	
	
	public Pays(String pNom,JO pJO){
		this.athletes=new ArrayList<Athlete>();
		this.nom=pNom;
		this.nbMOr=0;
		this.nbMArgent=0;
		this.nbMBronze=0;
		boolean sportCo=false;
		Constructor constructeur=null;
		for(int i=0;i<pJO.getListeCompetitions().size();i++){
			if(pJO.getListeCompetitions().get(i).getNom().length()>6){
				if(pJO.getListeCompetitions().get(i).getNom().substring(0,7).compareTo("Tournoi")==0){//cas d'un sport co
					sportCo=true;
				}
			}
			try{
				Class typeAthlete=pJO.getListeCompetitions().get(i).getTypeAthlete();
				constructeur=typeAthlete.getConstructor(Pays.class);//on recupere le constrcteur de la class du type d'athlete
			}catch(Exception e ){
				System.out.println("Erreur lors de l'initialisation des athletes");//Exception obligatoire
			}
			int nbAthletes=Random.rInt(3)+1;//on determine le nb d'athlete, le minimum étant 1
			if(sportCo){
				nbAthletes=pJO.getListeCompetitions().get(i).getNbJoueurs();
			}
			for(int j=0;j<nbAthletes;j++){
				try{
					Athlete a =(Athlete) constructeur.newInstance(this);//on instancie grace au constructeur
					this.athletes.add(a);//on l'ajoute à la liste des athletes
				}
				catch(Exception e){
					System.out.println("Erreur lors de l'initialisation des athletes");//Exception obligatoire
				}
			}
		}
		
	}
	
	public void printAthletes(){
		for(int i=0;i<this.athletes.size();i++){
			System.out.println(this.athletes.get(i).toString());
		}
	}
	
	public boolean estDevant(Pays pPays){
		if(this.nbMOr!=pPays.getNbMOr()){
			return this.nbMOr>pPays.getNbMOr();
		}if(this.nbMArgent!=pPays.getNbMArgent()){
			return this.nbMArgent>pPays.getNbMArgent();
		}if(this.nbMBronze!=pPays.getNbMBronze()){
			return this.nbMBronze>pPays.getNbMBronze();
		}
		return this.nom.compareTo(pPays.getNom())>0;
	}
	
	public String toString(){
		return this.nom+" "+this.nbMOr+" "+this.nbMArgent+" "+this.nbMBronze;
	}
	
	public ArrayList<Athlete> getListeAthletes(){
		return this.athletes;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void addMOr(){
		this.nbMOr++;
	}
	
	public void addMArgent(){
		this.nbMArgent++;
	}
	
	public void addMBronze(){
		this.nbMBronze++;
	}
	
	public int getNbMOr(){
		return this.nbMOr;
	}
	public int getNbMArgent(){
		return this.nbMArgent;
	}
	public int getNbMBronze(){
		return this.nbMBronze;
	}
}
