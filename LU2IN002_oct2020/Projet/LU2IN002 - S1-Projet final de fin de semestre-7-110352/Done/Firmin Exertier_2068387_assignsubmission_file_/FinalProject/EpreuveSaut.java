class EpreuveSaut extends Epreuve{
	private Sauteur sauteur;
	private int distance;
	
	public EpreuveSaut(String pDate,Sauteur s)	{
		super(pDate);
		this.sauteur=s;
		this.distance=0;
	}
	
	
	public String toString(){
		return super.toString()+" EpreuveSaut";
	}
	
	public Class getTypeAthlete(){
		return Sauteur.class;
	}
	
	public void setDistance(int pDistance){
		this.distance=pDistance;
	}
	
	public int getDistance(){
		return this.distance;
	}

}
