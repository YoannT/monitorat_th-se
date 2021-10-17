class Sauteur extends Athlete implements Courir,Sauter{
	private int force, endurance, agilite,score;
	
	public Sauteur(Pays pPays){
		super(pPays);
		this.force=Random.rInt(7,10);
		this.endurance=Random.rInt(7,10);
		this.agilite=Random.rInt(7,10);
		this.numero=id;
		id++;
	}
	
	public int courir(){
		return this.force+this.endurance;
	}
	
	public int sauter(){
		return this.force+this.agilite;
	}
	
	public String toString(){
		return super.toString()+" Sauteur";
	}
	
	public String getStats(){
		return this.force+" "+this.endurance+" "+this.agilite;
	}
	
	public void setScore(int pScore){
		this.score=pScore;
	}
	
	public int getScore(){
		return this.sauter()*this.courir();
	}
	
	public boolean estDevant(Sauteur s)	{
		return this.getScore()>s.getScore();
	}

}
