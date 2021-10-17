import java.util.ArrayList;

class TournoiBasket extends CompetitionCollective{
	
	public TournoiBasket(String pDate){
		super(pDate,"TournoiBasket");
		this.nbJoueurs=5;
	}
	
	public String toString(){
		return "Tournoi de basket du "+this.date;
	}
	
	public Class getTypeAthlete(){
		return Basketteur.class;
	}
	
	public void deroulement(JO jo){
		this.writeLigne(jo,this.toString()+"\n");
		super.initParticipants(jo);
		ArrayList<ArrayList<Basketteur>> a11,a12,a21,a22,b11,b12,b21,b22;
		a11=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(0,this.participant.size()/8));	
		a12=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(this.participant.size()/8,this.participant.size()/4));	
		a21=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(this.participant.size()/4,3*this.participant.size()/8));	
		a22=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(3*this.participant.size()/8,this.participant.size()/2));	
		b11=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(this.participant.size()/2,5*this.participant.size()/8)); 
		b12=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(5*this.participant.size()/8,3*this.participant.size()/4));
		b21=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(3*this.participant.size()/4,7*this.participant.size()/8));
		b22=new ArrayList<ArrayList<Basketteur>>(this.participant.subList(7*this.participant.size()/8,this.participant.size()));
		
		ArrayList<ArrayList<Basketteur>> qf1=this.getVainqueur(a11,a12);
		ArrayList<ArrayList<Basketteur>> qf2=this.getVainqueur(a21,a22);
		ArrayList<ArrayList<Basketteur>> qf3=this.getVainqueur(b11,b12);
		ArrayList<ArrayList<Basketteur>> qf4=this.getVainqueur(b21,b22);
		
		this.writeLigne(jo,"Qualifies des groupes :");
		this.writeLigne(jo,qf1.get(0).get(0).getPays().getNom());
		this.writeLigne(jo,qf2.get(0).get(0).getPays().getNom());
		this.writeLigne(jo,qf3.get(0).get(0).getPays().getNom());
		this.writeLigne(jo,qf4.get(0).get(0).getPays().getNom());
		
		MatchBasket df1=new MatchBasket(this.date,qf1.get(0),qf2.get(0));
		df1.match();
		MatchBasket df2=new MatchBasket(this.date,qf3.get(0),qf4.get(0));
		df2.match();
		
		this.writeLigne(jo,"Qualifies pour la finale : ");
		this.writeLigne(jo,df1.getPremier().get(0).getPays().getNom());
		this.writeLigne(jo,df2.getPremier().get(0).getPays().getNom());
		
		MatchBasket f1=new MatchBasket(this.date,df1.getDeuxieme(),df2.getDeuxieme());
		f1.match();
		MatchBasket f2=new MatchBasket(this.date,df1.getPremier(),df2.getPremier());
		f2.match();
		
		
		this.mOr=f1.getPremier().get(0);
		this.mOr.setMOr();
		this.mArgent=f1.getDeuxieme().get(0);
		this.mArgent.setMArgent();
		this.mBronze=f2.getPremier().get(0);
		this.mBronze.setMBronze();
		
		this.writeLigne(jo,"Resultat de la petite finale (medaille de bronze) :");
		this.writeLigne(jo,f1.getPremier().get(0).getPays().getNom());
		this.writeLigne(jo,"Medaille d'argent :");	
		this.writeLigne(jo,f2.getDeuxieme().get(0).getPays().getNom());
		this.writeLigne(jo,"Medaille d'or :");		
		this.writeLigne(jo,f2.getPremier().get(0).getPays().getNom());
		this.writeLigne(jo,"");
		
		
		
	}
	
	public ArrayList<ArrayList<Basketteur>> getVainqueur(ArrayList<ArrayList<Basketteur>> liste1,ArrayList<ArrayList<Basketteur>> liste2){
			ArrayList<ArrayList<Basketteur>> retour=new ArrayList<ArrayList<Basketteur>>();
			if(liste1.size()==1 && liste2.size()==1){
				MatchBasket match=new MatchBasket(this.date,liste1.get(0),liste2.get(0));
				match.match();
				retour.add(match.getPremier());
				return retour;
			}
			if(liste1.size()==0){
				return liste2;
			}if(liste2.size()==0){
				return liste1;
			}
			
			ArrayList<ArrayList<Basketteur>> liste11=new ArrayList<ArrayList<Basketteur>>(liste1.subList(0,liste1.size()/2));
			ArrayList<ArrayList<Basketteur>> liste12=new ArrayList<ArrayList<Basketteur>>(liste1.subList(liste1.size()/2,liste1.size()));
			
			ArrayList<ArrayList<Basketteur>> liste21=new ArrayList<ArrayList<Basketteur>>(liste1.subList(liste1.size()/2,liste1.size()));
			ArrayList<ArrayList<Basketteur>> liste22=new ArrayList<ArrayList<Basketteur>>(liste1.subList(liste1.size()/2,liste1.size()));
			
			return getVainqueur(getVainqueur(liste11,liste12),getVainqueur(liste21,liste22));
	}

}
