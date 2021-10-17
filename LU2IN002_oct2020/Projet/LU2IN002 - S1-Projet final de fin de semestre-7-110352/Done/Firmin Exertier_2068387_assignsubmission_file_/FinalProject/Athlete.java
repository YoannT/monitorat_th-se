abstract class Athlete implements Cloneable{
	protected String nom,prenom;
	static int id=1;
	protected int numero;
	protected Pays pays;
	
	public  String toString(){
		return this.numero+" "+this.pays.getNom()+" "+this.prenom+" "+this.nom;
	}
	
	public Athlete(Pays pPays){
		this.pays=pPays;
		Fichier fNom=new Fichier("prenom.txt");
		this.prenom=fNom.getRandomLigne();
		Fichier fPrenom=new Fichier("nom.txt");
		this.nom=fPrenom.getRandomLigne();
		this.pays=pPays;
		
			
	}
	
	
	
	
	public Athlete clone(){
		Athlete retour=null;
		try{
			retour=(Athlete)super.clone();
		}catch(CloneNotSupportedException e){
			System.out.println(e.getMessage());
		}
		return retour;
	}
	
	public  Pays getPays(){
		return this.pays;
	}
	
	public void setMOr(){
		this.pays.addMOr();
	}
	
	public void setMArgent(){
		this.pays.addMArgent();
	}
	
	public void setMBronze(){
		this.pays.addMBronze();
	}
	
	public String presentation(){
		return this.numero+" "+this.pays.getNom()+" "+this.prenom+" "+this.nom;
	}
	
	
}
