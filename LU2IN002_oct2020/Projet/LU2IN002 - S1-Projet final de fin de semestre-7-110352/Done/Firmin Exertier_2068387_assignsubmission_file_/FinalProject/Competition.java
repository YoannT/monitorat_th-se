import java.util.ArrayList;

abstract class Competition{
	protected Athlete mOr,mArgent,mBronze;
	protected ArrayList participant;//il faut donc déclarer le type des participants avec new ArrayList<type>
	protected String date,nom;
	protected int nbJoueurs;
	
	public Competition(String pDate,String pNom){
		this.date=pDate;
		this.nom=pNom;
	}
	public  String toString(){
		return this.date+" "+this.nom;
	}
	public abstract void deroulement(JO jo);
	public abstract Class getTypeAthlete();
	
	public Athlete getMOr(){
		return this.mOr;
	}
	
	public Athlete getMArgent(){
		return this.mArgent;
	}
	
	public Athlete getMBronze(){
		return this.mBronze;		
	}
	
	
	
	public void initParticipants(JO jo){
		for(int i=0;i<jo.getListePays().size();i++){
			for(int j=0;j<jo.getListePays().get(i).getListeAthletes().size();j++){
				if(jo.getListePays().get(i).getListeAthletes().get(j).getClass()==this.getTypeAthlete()){
					this.participant.add(jo.getListePays().get(i).getListeAthletes().get(j));
				}
			}
		}
	}
	
	public ArrayList getListeParticipants(){
		return this.participant;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public int getNbJoueurs(){
		return this.nbJoueurs;
	}
	

	public void writeLigne(JO jo,String pLigne){
		jo.getFichier().insererLigne(pLigne);
	}

}

