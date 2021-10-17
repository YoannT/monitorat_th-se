import java.util.ArrayList;

class CompetitionGymnastiqueRythmique extends Competition{
	private ArrayList<GymnasteRythmique> qualifies;
	
	public CompetitionGymnastiqueRythmique(String pDate){
		super(pDate,"GymnastiqueRythmique");
		this.participant=new ArrayList<GymnasteRythmique>();
		this.qualifies=new ArrayList<GymnasteRythmique>();
			
	}
	
	public String toString(){
		return "Competition de Gymnastique Rythmique du "+this.date;
	}
	
	public Class getTypeAthlete(){
		return GymnasteRythmique.class;
	}
	
	public void deroulement(JO jo){
		this.writeLigne(jo,this.toString()+"\n");
		super.initParticipants(jo);
		this.routineListe(this.participant);
		this.qualifies=ArraySplit.split(organiserResultats(this.participant),8);//les 9 premiers se qualifient pour la finale 
		this.writeLigne(jo,"Qualifies pour la finale :");
		for(int i=0;i<this.qualifies.size();i++){
			this.writeLigne(jo,this.qualifies.get(i).presentation());
		}
		this.routineListe(this.qualifies);
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
	
	public void routineListe(ArrayList<GymnasteRythmique> liste){
		for(int i=0;i<liste.size();i++){
			RoutineRythmique rR1=new RoutineRythmique(this.date,liste.get(i));
			RoutineRythmique rR2=new RoutineRythmique(this.date,liste.get(i));
			RoutineRythmique rR3=new RoutineRythmique(this.date,liste.get(i));
			RoutineRythmique rR4=new RoutineRythmique(this.date,liste.get(i));
			liste.get(i).setScores(rR1.deroulement(),rR2.deroulement(),rR3.deroulement(),rR4.deroulement());
						
			}
				
	}
	
	
		
	public ArrayList<GymnasteRythmique> organiserResultats(ArrayList<GymnasteRythmique> liste){
		ArrayList<GymnasteRythmique> retour=new ArrayList<GymnasteRythmique>(liste);
		boolean fait=false;
		GymnasteRythmique temp=null;
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
