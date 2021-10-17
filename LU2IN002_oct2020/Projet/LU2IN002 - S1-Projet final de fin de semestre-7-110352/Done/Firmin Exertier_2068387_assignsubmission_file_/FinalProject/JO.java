import java.util.ArrayList;
import java.lang.reflect.Constructor;

class JO{
	private String date,pays;
	private ArrayList<Competition> listeCompetitions;
	private ArrayList<Pays> listePays;
	private static JO singleton=null; 
	Fichier fichier;
	
	
	
	private JO(String pDate,String pPays){
		this.date=pDate;
		this.pays=pPays;
		this.listeCompetitions=new ArrayList<Competition>();
		this.listePays=new ArrayList<Pays>();

	}
	
	public void init()throws DossierNonExistantException{	
	
		String pDate=this.date;
		int j=0;
		Fichier fC=new Fichier("competition.txt");
		ArrayList<String> arrayCompetition=fC.getAllLignes();
		for(int i=0;i<arrayCompetition.size();i++){
			if(j>2){
				pDate=Date.getNextDate(pDate);
				j=0;
			}
			this.ajouterCompetition(arrayCompetition.get(i),pDate);
			j++;
		}
		
		
		
		Fichier fP=new Fichier("pays.txt");
		ArrayList<String> arrayPays=fP.getAllLignes();
		for(int i=0;i<arrayPays.size();i++){
			this.listePays.add(new Pays(arrayPays.get(i),this));//initialise les pays grâce au fichier txt
		}
		
		this.writeInit();
		
	}
	
	public void deroulement(){
		try{
			for(int i=0;i<this.listeCompetitions.size();i++){
				System.out.println(this.listeCompetitions.get(i).toString());
				this.listeCompetitions.get(i).deroulement(this);
				System.out.println("Medaille d'or : "+this.listeCompetitions.get(i).getMOr().presentation());
				System.out.println("Medaille d'argent : "+this.listeCompetitions.get(i).getMArgent().presentation());
				System.out.println("Medaille de bronze : "+this.listeCompetitions.get(i).getMBronze().presentation());
				this.listePays=actualiserResultats();
				System.out.println("");
				this.printPays();
				System.out.println("\n");
				Thread.sleep(500);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		for(int i=0;i<this.listePays.size();i++){
			this.fichier.insererLigne(this.listePays.get(i).toString());
		}
		System.out.println("Liste des medailles :");
		this.printMedailles();
	}
	
	
	
	public static JO creerJO(String pDate,String pPays){
		if(singleton!=null){
			return singleton;
		}
		return singleton=new JO(pDate,pPays);
	}
	
	private void ajouterCompetition(String pNom,String pDate){
		Constructor constructeur=null;
		try{
			Class typeCompetition=Class.forName(pNom);
			constructeur=typeCompetition.getConstructor(String.class);
			Competition c =(Competition) constructeur.newInstance(pDate);//on instancie grace au constructeur
			this.listeCompetitions.add(c);//on recupere le constrcteur de la class du type d'athlete
		
		}catch(Exception e){
			System.out.println("Erreur lors de l'initialisation des competitions");
		}
	}
	
	public ArrayList<Competition> getListeCompetitions(){
		return this.listeCompetitions;		
	}
	
	public ArrayList<Pays> getListePays(){
		return this.listePays;
	}
	
	public String toString(){
		return "JO de "+this.date+" de "+this.pays;
	}
	
	public void printCompetitions(){
		for(int i=0;i<this.listeCompetitions.size();i++){
			System.out.println(this.listeCompetitions.get(i).toString());
		}
	}
	public void printPays(){
		for(int i=0;i<this.listePays.size();i++){
			System.out.println(this.listePays.get(i).toString());
		}
	}
	
	public void printAthletes(){
		for(int i=0;i<this.listePays.size();i++){
			this.listePays.get(i).printAthletes();
		}
	}
	
	public ArrayList<Pays> actualiserResultats(){
		ArrayList<Pays> retour=new ArrayList<Pays>(this.listePays);
		boolean fait=false;
		Pays temp=null;
		while(!fait){
			fait=true;
			
			
			for(int i=0;i<retour.size()-1;i++){
				if(retour.get(i+1).estDevant(retour.get(i))){
					temp=retour.get(i);
					retour.set(i,retour.get(i+1));
					retour.set(i+1,temp);
					fait=false;
				}
			}
		}
		return retour;
	}
	
	public void writeInit()throws DossierNonExistantException{
		this.fichier=new Fichier();
		String nomTemps=this.pays+"-"+this.date.substring(0,2)+"-"+this.date.substring(3,5)+"-"+this.date.substring(6,10)+".txt";
		this.fichier.creerFichier(nomTemps);
		this.fichier.insererLigne("Bienvenue dans les logs des JO prenant place a "+this.pays+" en "+this.date.substring(6,10));
		this.fichier.insererLigne("Liste de pays :");
		for(int i=0;i<this.listePays.size();i++){
			this.fichier.insererLigne(this.listePays.get(i).getNom());
		}
		this.fichier.insererLigne("\n\n");
		this.fichier.insererLigne("Liste des competitions et leurs dates");
		for(int i=0;i<this.listeCompetitions.size();i++){
			this.fichier.insererLigne(this.listeCompetitions.get(i).getNom()+" "+this.listeCompetitions.get(i).getDate());
		}
		this.fichier.insererLigne("");
	}
	
	
	public Fichier getFichier(){
		return this.fichier;
	} 
	
	public void printMedailles(){
		ArrayList<Athlete> liste=new ArrayList<Athlete>();
		for(int i=0;i<this.listeCompetitions.size();i++){
			liste.add(this.listeCompetitions.get(i).getMOr().clone());
			liste.add(this.listeCompetitions.get(i).getMArgent().clone());
			liste.add(this.listeCompetitions.get(i).getMBronze().clone());
		}
		for (int i=0;i<liste.size();i++){
			System.out.println(liste.get(i).toString());
		}
	}
	
}
