import java.util.ArrayList;

class CompetitionTaekwondo extends Competition{

	public CompetitionTaekwondo(String pDate){
		super(pDate,"Taekwondo");
		this.participant=new ArrayList<Taekwondoiste>();
	}
	
	public String toString(){
		return "Competition de Taekwondo du "+this.date;
	}
	
	public  Class getTypeAthlete(){
		return Taekwondoiste.class;
	}
	
	
	public void deroulement(JO jo){
	
		this.writeLigne(jo,this.toString()+"\n");
		
		this.initParticipants(jo);
		
		ArrayList<Taekwondoiste> a11,a12,a21,a22,b11,b12,b21,b22;
		a11=new ArrayList<Taekwondoiste>(this.participant.subList(0,this.participant.size()/8));	
		a12=new ArrayList<Taekwondoiste>(this.participant.subList(this.participant.size()/8,this.participant.size()/4));	
		a21=new ArrayList<Taekwondoiste>(this.participant.subList(this.participant.size()/4,3*this.participant.size()/8));	
		a22=new ArrayList<Taekwondoiste>(this.participant.subList(3*this.participant.size()/8,this.participant.size()/2));	
		b11=new ArrayList<Taekwondoiste>(this.participant.subList(this.participant.size()/2,5*this.participant.size()/8)); 
		b12=new ArrayList<Taekwondoiste>(this.participant.subList(5*this.participant.size()/8,3*this.participant.size()/4));
		b21=new ArrayList<Taekwondoiste>(this.participant.subList(3*this.participant.size()/4,7*this.participant.size()/8));
		b22=new ArrayList<Taekwondoiste>(this.participant.subList(7*this.participant.size()/8,this.participant.size()));
		
		
		
		ArrayList<Taekwondoiste> df1=this.getVainqueur(a11,a12);//qualifie des gp
		ArrayList<Taekwondoiste> df2=this.getVainqueur(a21,a22);
		ArrayList<Taekwondoiste> df3=this.getVainqueur(b11,b12);
		ArrayList<Taekwondoiste> df4=this.getVainqueur(b21,b22);
		
		this.writeLigne(jo,"Qualifies des groupes :");
		this.writeLigne(jo,df1.get(0).presentation());
		this.writeLigne(jo,df2.get(0).presentation());
		this.writeLigne(jo,df3.get(0).presentation());
		this.writeLigne(jo,df4.get(0).presentation());
		
		//demi
		MatchTaekwondo matchD1=new MatchTaekwondo(this.date,df1.get(0),df2.get(0));
		matchD1.match();
		MatchTaekwondo matchD2=new MatchTaekwondo(this.date,df3.get(0),df4.get(0));
		matchD2.match();
		
		this.writeLigne(jo,"Qualifies pour la finale : ");
		this.writeLigne(jo,matchD1.<Taekwondoiste>getPremier().presentation());
		this.writeLigne(jo,matchD2.<Taekwondoiste>getPremier().presentation());
							
		//petite finale
		MatchTaekwondo matchF1=new MatchTaekwondo(this.date,matchD1.getDeuxieme(),matchD2.getDeuxieme());
		matchF1.match();
		this.mBronze=matchF1.getPremier();
		this.mBronze.setMBronze();
		
		this.writeLigne(jo,"Resultat de la petite finale (medaille de bronze) :");
		this.writeLigne(jo,matchF1.<Taekwondoiste>getPremier().presentation());
		
							
		//finale
		MatchTaekwondo matchF2=new MatchTaekwondo(this.date,matchD1.getPremier(),matchD2.getDeuxieme());
		matchF2.match();
		this.mArgent=matchF2.<Taekwondoiste>getDeuxieme();
		this.mArgent.setMArgent();
		this.mOr=matchF2.<Taekwondoiste>getPremier();
		this.mOr.setMOr();
		
		this.writeLigne(jo,"Medaille d'argent :");
		this.writeLigne(jo,matchF2.<Taekwondoiste>getDeuxieme().presentation());
		this.writeLigne(jo,"Medaille d'or :");
		this.writeLigne(jo,matchD2.<Taekwondoiste>getPremier().presentation());
		this.writeLigne(jo,"");
		
	}
	
	public ArrayList<Taekwondoiste> getVainqueur(ArrayList<Taekwondoiste> liste1,ArrayList<Taekwondoiste> liste2){
		ArrayList<Taekwondoiste> retour=new ArrayList<Taekwondoiste>();
		if(liste1.size()==1 && liste2.size()==1){
			MatchTaekwondo match=new MatchTaekwondo(this.date,liste1.get(0),liste2.get(0));
			match.match();
			retour.add(match.getPremier());
			return retour;
		}
		if(liste2.size()==0){
			return liste1;
		}
		if(liste1.size()==0){
			return liste2;
		}

		ArrayList<Taekwondoiste> liste11=new ArrayList<Taekwondoiste>(liste1.subList(0,liste1.size()/2));//on split les list
		ArrayList<Taekwondoiste> liste12=new ArrayList<Taekwondoiste>(liste1.subList(liste1.size()/2,liste1.size()));

		ArrayList<Taekwondoiste> liste21=new ArrayList<Taekwondoiste>(liste2.subList(0,liste2.size()/2));
		ArrayList<Taekwondoiste> liste22=new ArrayList<Taekwondoiste>(liste2.subList(liste2.size()/2,liste2.size()));


		return getVainqueur(getVainqueur(liste11,liste12),getVainqueur(liste21,liste22));

	}

}
