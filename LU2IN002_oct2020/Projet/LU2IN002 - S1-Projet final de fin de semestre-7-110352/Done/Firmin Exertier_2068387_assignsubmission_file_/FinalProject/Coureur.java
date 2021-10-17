class Coureur extends Athlete implements Courir{
	private int force,endurance,score;
	
	public Coureur(Pays pPays){
		super(pPays);
		this.force=Random.rInt(7,10);
		this.endurance=Random.rInt(7,10);
		this.score=0;
		this.numero=id;
		id++;
	}
	
	public int courir(){
		return this.force+this.endurance;
	}
	
	public String toString(){
		return super.toString()+" Coureur";
	}
	
	public String getStats(){
		return this.force+" "+this.endurance;
	}
	
	public void setScore(int pScore){
		this.score=pScore;
	}
	
	public int getScore(){
		return this.courir();
	}
	
	public boolean estDevant(Coureur c)	{
		return this.getScore()>c.getScore();
	}
	
}
