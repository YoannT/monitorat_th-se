class MatchTaekwondo extends Combat{

	public MatchTaekwondo(String pDate,Taekwondoiste b1,Taekwondoiste b2){
		super(pDate,b1,b2);
	}
	
	public Class getTypeAthlete(){
		return Taekwondoiste.class;
	}
	
	public void match(){
	double stat1=0.0,stat2=0.0;
	int r1=0;
	for(int i=0;i<3;i++){
		stat1=(double)(1+this.c1.getCardio()*i)*this.c1.combattre();//la cardio a un impact de plus en plus grand en f° des rounds
		stat2=(double)(1+this.c2.getCardio()*i)*this.c2.combattre();
		if(stat1>=stat2){
			r1++;//on attribue un round au 1er 
		}
	}
		if(r1>=2){//si le premier a 2 ou plus de round il gagne
			this.premier=this.c1;
			this.deuxieme=this.c2;
		}else{
			this.deuxieme=this.c1;
			this.premier=this.c2;
		}
	}


}
