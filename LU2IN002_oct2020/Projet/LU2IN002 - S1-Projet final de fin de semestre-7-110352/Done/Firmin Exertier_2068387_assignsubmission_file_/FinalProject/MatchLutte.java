class MatchLutte extends Combat{
	
	public MatchLutte(String pDate,Lutteur l1,Lutteur l2){
		super(pDate,l1,l2);
	}
	
	public Class getTypeAthlete(){	
		return Lutteur.class;
	}
	
	public void match(){
		double stat1=0.0,stat2=0.0;
		int r1=0,r2=0;
		for(int i=0;i<2;i++){	
			stat1=(double)(1+this.c1.getCardio()*i)*this.c1.combattre();//la cardio a un impact de plus en plus grand en f° des rounds
			stat2=(double)(1+this.c2.getCardio()*i)*this.c2.combattre();
			if(stat1>=stat2){
				r1++;//on attribue un round au 1er 
			}else{
				r2++;
			}
		}if(r1>=1){//en cas d'égalité 1 l'emporte
			this.premier=this.c1;
			this.deuxieme=this.c2;
		}else{
			this.deuxieme=this.c1;
			this.premier=this.c2;
		}
	}
	
}
