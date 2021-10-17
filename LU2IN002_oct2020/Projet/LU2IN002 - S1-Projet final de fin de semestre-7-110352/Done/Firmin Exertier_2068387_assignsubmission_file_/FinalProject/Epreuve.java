abstract class Epreuve{
	protected String date;
	public abstract Class getTypeAthlete();
	
	protected Epreuve(String pDate){
		this.date=pDate;
	}
	
	public String toString(){
		return "Epreuve du "+this.date;
	}
}
