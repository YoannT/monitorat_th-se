class MatchJudo extends Combat{

	public MatchJudo(String pDate,Judoka j1,Judoka j2){
		super(pDate,j1,j2);
	}
	
	public Class getTypeAthlete(){
		return Judoka.class;
	}
	
	public void match(){
		if(this.c1.combattre()>=this.c2.combattre()){
			this.premier=this.c1;
			this.deuxieme=this.c2;
		}else{
			this.premier=this.c2;
			this.deuxieme=this.c1;
		}	
	}
	
}
