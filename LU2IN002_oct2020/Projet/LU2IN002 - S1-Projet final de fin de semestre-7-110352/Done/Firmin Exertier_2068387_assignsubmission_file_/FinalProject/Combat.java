abstract class Combat extends Epreuve{
	Combattant c1,c2;
	Combattant premier=null,deuxieme=null;
	
	protected Combat(String pDate,Combattant pC1,Combattant pC2){
		super(pDate);
		this.c1=pC1;
		this.c2=pC2;
		
	}
	
	public abstract Class getTypeAthlete();
	
	protected abstract void match();
	
	public <T> T getPremier(){
		return (T)this.premier;
	}
	
	public <T> T getDeuxieme(){
		return (T)this.deuxieme;
	}
	
	

}
