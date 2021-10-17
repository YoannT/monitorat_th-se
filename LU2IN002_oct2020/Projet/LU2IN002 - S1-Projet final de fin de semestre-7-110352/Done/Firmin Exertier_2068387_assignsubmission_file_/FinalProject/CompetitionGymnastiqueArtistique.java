import java.util.ArrayList;

class CompetitionGymnastiqueArtistique extends Competition{
	private ArrayList<GymnasteArtistique> qualifies;
	
	public CompetitionGymnastiqueArtistique(String pDate){
		super(pDate,"GymnastiqueArtistique");
		this.participant=new ArrayList<GymnasteArtistique>();
		this.qualifies=new ArrayList<GymnasteArtistique>();
			
	}
	
	public String toString(){
		return "Competition de Gymnastique Artistique du "+this.date;
	}
	
	public Class getTypeAthlete(){
		return GymnasteArtistique.class;
	}
	
	public void deroulement(JO jo){
		this.writeLigne(jo,this.toString()+"\n");
		super.initParticipants(jo);
		this.routineListe(this.participant);
		this.qualifies=ArraySplit.split(organiserResultats(this.participant),8);//les 8 premiers se qualifient pour la finale 
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
	
	public void routineListe(ArrayList<GymnasteArtistique> liste){
		for(int i=0;i<liste.size();i++){
			RoutineArtistique rR1=new RoutineArtistique(this.date,liste.get(i));
			RoutineArtistique rR2=new RoutineArtistique(this.date,liste.get(i));
			RoutineArtistique rR3=new RoutineArtistique(this.date,liste.get(i));
			RoutineArtistique rR4=new RoutineArtistique(this.date,liste.get(i));
			RoutineArtistique rR5=new RoutineArtistique(this.date,liste.get(i));
			RoutineArtistique rR6=new RoutineArtistique(this.date,liste.get(i));
			liste.get(i).setScores(rR1.deroulement(),rR2.deroulement(),rR3.deroulement(),rR4.deroulement(),rR5.deroulement(),rR6.deroulement());
						
			}
				
	}
	
	
		
	public ArrayList<GymnasteArtistique> organiserResultats(ArrayList<GymnasteArtistique> liste){
		ArrayList<GymnasteArtistique> retour=new ArrayList<GymnasteArtistique>(liste);
		boolean fait=false;
		GymnasteArtistique temp=null;
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
