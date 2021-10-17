import java.util.ArrayList;

class CompetitionTrampoline extends Competition{
	private ArrayList<Trampoliniste> qualifies;
	
	public CompetitionTrampoline(String pDate){
		super(pDate,"Trampoline");
		this.participant=new ArrayList<Trampoliniste>();
		this.qualifies=new ArrayList<Trampoliniste>();
	}
	
	public String toString(){
		return "Competition de Trampoline du "+this.date;
	}
	
	public Class getTypeAthlete(){
		return Trampoliniste.class;
	}
	
	public void deroulement(JO jo){
		this.writeLigne(jo,this.toString()+"\n");
		super.initParticipants(jo);
		this.routineListe(this.participant);//tt les participants font leur routine
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
	
	public void routineListe(ArrayList<Trampoliniste> liste){
		for(int i=0;i<liste.size();i++){
			RoutineTrampoline rT1=new RoutineTrampoline(this.date,liste.get(i));
			RoutineTrampoline rT2=new RoutineTrampoline(this.date,liste.get(i));
			RoutineTrampoline rT3=new RoutineTrampoline(this.date,liste.get(i));
			liste.get(i).setScores(rT1.deroulement(),rT2.deroulement(),rT3.deroulement());
						
			}
				
	}
	
	
		
	public ArrayList<Trampoliniste> organiserResultats(ArrayList<Trampoliniste> liste){
		ArrayList<Trampoliniste> retour=new ArrayList<Trampoliniste>(liste);
		boolean fait=false;
		Trampoliniste temp=null;
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
