import java.util.ArrayList;

class CompetitionJudo extends Competition{
	
	public CompetitionJudo(String pDate){
		super(pDate,"Judo");
		this.participant=new ArrayList<Judoka>();

	}
	
	public String toString(){
		return "Competition de judo du "+this.date;
	}
	
	public  Class getTypeAthlete(){
		return Judoka.class;
	}
	
	
	public void deroulement(JO jo){
	
		this.writeLigne(jo,this.toString()+"\n");
		
		this.initParticipants(jo);
		
		ArrayList<Judoka> a11,a12,a21,a22,b11,b12,b21,b22;
		a11=new ArrayList<Judoka>(this.participant.subList(0,this.participant.size()/8));	
		a12=new ArrayList<Judoka>(this.participant.subList(this.participant.size()/8,this.participant.size()/4));	
		a21=new ArrayList<Judoka>(this.participant.subList(this.participant.size()/4,3*this.participant.size()/8));	
		a22=new ArrayList<Judoka>(this.participant.subList(3*this.participant.size()/8,this.participant.size()/2));	
		b11=new ArrayList<Judoka>(this.participant.subList(this.participant.size()/2,5*this.participant.size()/8)); 
		b12=new ArrayList<Judoka>(this.participant.subList(5*this.participant.size()/8,3*this.participant.size()/4));
		b21=new ArrayList<Judoka>(this.participant.subList(3*this.participant.size()/4,7*this.participant.size()/8));
		b22=new ArrayList<Judoka>(this.participant.subList(7*this.participant.size()/8,this.participant.size()));
		
		
		
		ArrayList<Judoka> df1=this.getVainqueur(a11,a12);//qualifie des gp
		ArrayList<Judoka> df2=this.getVainqueur(a21,a22);
		ArrayList<Judoka> df3=this.getVainqueur(b11,b12);
		ArrayList<Judoka> df4=this.getVainqueur(b21,b22);
		
		this.writeLigne(jo,"Qualifies des groupes :");
		this.writeLigne(jo,df1.get(0).presentation());
		this.writeLigne(jo,df2.get(0).presentation());
		this.writeLigne(jo,df3.get(0).presentation());
		this.writeLigne(jo,df4.get(0).presentation());

		//demi
		MatchJudo matchD1=new MatchJudo(this.date,df1.get(0),df2.get(0));
		matchD1.match();
		MatchJudo matchD2=new MatchJudo(this.date,df3.get(0),df4.get(0));
		matchD2.match();
		
		this.writeLigne(jo,"Qualifies pour la finale : ");
		this.writeLigne(jo,matchD1.<Judoka>getPremier().presentation());
		this.writeLigne(jo,matchD2.<Judoka>getPremier().presentation());
							
		//petite finale
		MatchJudo matchF1=new MatchJudo(this.date,matchD1.getDeuxieme(),matchD2.getDeuxieme());
		matchF1.match();
		this.mBronze=matchF1.getPremier();
		this.mBronze.setMBronze();
		
		this.writeLigne(jo,"Resultat de la petite finale (medaille de bronze) :");
		this.writeLigne(jo,matchF1.<Judoka>getPremier().presentation());
		
							
		//finale
		MatchJudo matchF2=new MatchJudo(this.date,matchD1.getPremier(),matchD2.getDeuxieme());
		matchF2.match();
		this.mArgent=matchF2.<Judoka>getDeuxieme();
		this.mArgent.setMArgent();
		this.mOr=matchF2.<Judoka>getPremier();
		this.mOr.setMOr();
		
		this.writeLigne(jo,"Medaille d'argent :");
		this.writeLigne(jo,matchF2.<Judoka>getDeuxieme().presentation());
		this.writeLigne(jo,"Medaille d'or :");
		this.writeLigne(jo,matchD2.<Judoka>getPremier().presentation());
		this.writeLigne(jo,"");
	
		
	}


	public ArrayList<Judoka> getVainqueur(ArrayList<Judoka> liste1,ArrayList<Judoka> liste2){
		ArrayList<Judoka> retour=new ArrayList<Judoka>();
		if(liste1.size()==1 && liste2.size()==1){
			MatchJudo match=new MatchJudo(this.date,liste1.get(0),liste2.get(0));
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

		ArrayList<Judoka> liste11=new ArrayList<Judoka>(liste1.subList(0,liste1.size()/2));//on split les list
		ArrayList<Judoka> liste12=new ArrayList<Judoka>(liste1.subList(liste1.size()/2,liste1.size()));

		ArrayList<Judoka> liste21=new ArrayList<Judoka>(liste2.subList(0,liste2.size()/2));
		ArrayList<Judoka> liste22=new ArrayList<Judoka>(liste2.subList(liste2.size()/2,liste2.size()));


		return getVainqueur(getVainqueur(liste11,liste12),getVainqueur(liste21,liste22));

	}
}

