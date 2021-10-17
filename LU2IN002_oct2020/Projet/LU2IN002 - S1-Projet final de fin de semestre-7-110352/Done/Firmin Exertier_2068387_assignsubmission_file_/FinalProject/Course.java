class Course extends Epreuve{
	private Coureur coureur;
	private int temps;
	
	public Course(String pDate,Coureur c)	{
		super(pDate);
		this.coureur=c;
		this.temps=0;
	}
	
		
	public String toString(){
		return super.toString()+" Course";
	}
	
	public Class getTypeAthlete(){
		return Coureur.class;
	}
	
	public void setTemps(int pTemps){
		this.temps=pTemps;
	}
	
	public int getTemps(){
		return this.temps;
	}

}
