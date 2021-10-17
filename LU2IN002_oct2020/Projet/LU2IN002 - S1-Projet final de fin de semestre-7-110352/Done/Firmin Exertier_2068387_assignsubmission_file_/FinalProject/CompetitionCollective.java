import java.util.ArrayList;

abstract class CompetitionCollective extends Competition{

	public CompetitionCollective(String pDate,String pNom){
		super(pDate,pNom);
		this.participant=new ArrayList<ArrayList<SportifCollectif>>();
		this.nbJoueurs=11;
	}
	
	public String toString(){
		return super.toString()+" Competition Collective";
	}
	
	public abstract void deroulement(JO jo);
	public abstract Class getTypeAthlete();
	
	@Override
	public void initParticipants(JO jo){
		for(int i=0;i<jo.getListePays().size();i++){
			ArrayList<Athlete> temp=new ArrayList<Athlete>();
			for(int j=0;j<jo.getListePays().get(i).getListeAthletes().size();j++){
				if(jo.getListePays().get(i).getListeAthletes().get(j).getClass()==this.getTypeAthlete()){
					temp.add(jo.getListePays().get(i).getListeAthletes().get(j));
				}
				this.participant.add(temp);
			}
		}
	}
	

}
