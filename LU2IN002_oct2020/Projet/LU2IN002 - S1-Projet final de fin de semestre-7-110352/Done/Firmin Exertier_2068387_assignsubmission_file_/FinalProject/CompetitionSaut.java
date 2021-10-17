import java.util.ArrayList;

class CompetitionSaut extends Competition{
	private ArrayList<Sauteur> qualifies;
	
	public CompetitionSaut(String pDate){
		super(pDate,"CompetitionSaut");
		this.participant=new ArrayList<Sauteur>();
		this.qualifies=new ArrayList<Sauteur>();
	}
	
	public String toString(){
		return "Competition de saut du "+this.date;
	}
	
	
	public Class getTypeAthlete(){
		return Sauteur.class;
	}
	
	public void deroulement(JO jo){
		this.writeLigne(jo,this.toString()+"\n");
		super.initParticipants(jo);
		this.courseListe(this.participant);
		this.qualifies=ArraySplit.split(organiserResultats(this.participant),8);//les 8 premiers se qualifient pour la finale 
		this.writeLigne(jo,"Qualifies pour la finale :");
		for(int i=0;i<this.qualifies.size();i++){
			this.writeLigne(jo,this.qualifies.get(i).presentation());
		}
		this.courseListe(this.qualifies);
		this.organiserResultats(this.qualifies);
		this.mOr=qualifies.get(0);
		this.mOr.setMOr();
		this.mArgent=qualifies.get(1);
		this.mArgent.setMArgent();
		this.mBronze=qualifies.get(2);
		this.mBronze.setMBronze();
		
		this.writeLigne(jo,"Medaille de bronze :");
		this.writeLigne(jo,this.mBronze.presentation());
		this.writeLigne(jo,"Medaille d'argent :");
		this.writeLigne(jo,this.mArgent.presentation());
		this.writeLigne(jo,"Medaille d'or :");
		this.writeLigne(jo,this.mOr.presentation());
		this.writeLigne(jo,"");
		
	}
	
	public void courseListe(ArrayList<Sauteur> liste){
		for(int i=0;i<liste.size();i++){
			EpreuveSaut saut=new EpreuveSaut(this.date,liste.get(i));
			saut.setDistance(liste.get(i).getScore());
			liste.get(i).setScore(saut.getDistance());	
		}
				
	}
	
	public ArrayList<Sauteur> organiserResultats(ArrayList<Sauteur> liste){
		ArrayList<Sauteur> retour=new ArrayList<Sauteur>(liste);
		boolean fait=false;
		Sauteur temp=null;
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


}
