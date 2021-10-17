abstract class Routine extends Epreuve{
	protected Gymnaste gymnaste;
	
	protected Routine(String pDate,Gymnaste g){
		super(pDate);
		this.gymnaste=g;
	}
	
	
	public String toString(){
		return super.toString()+" Routine";
	}
	
	public abstract Class getTypeAthlete();
	
		
}
