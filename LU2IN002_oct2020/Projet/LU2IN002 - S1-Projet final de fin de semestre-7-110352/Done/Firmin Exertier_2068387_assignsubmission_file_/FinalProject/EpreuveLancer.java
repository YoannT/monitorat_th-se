class EpreuveLancer extends Epreuve{
	private Lanceur lanceur;
	private int distance;
	
	public EpreuveLancer(String pDate,Lanceur l)	{
		super(pDate);
		this.lanceur=l;
		this.distance=0;
	}
	
	public String toString(){
		return super.toString()+" EpreuveLancer";
	}
	
	public Class getTypeAthlete(){
		return Lanceur.class;
	}
	
	public void setDistance(int pDistance){
		this.distance=pDistance;
	}
	
	public int getDistance(){
		return this.distance;
	}

}
