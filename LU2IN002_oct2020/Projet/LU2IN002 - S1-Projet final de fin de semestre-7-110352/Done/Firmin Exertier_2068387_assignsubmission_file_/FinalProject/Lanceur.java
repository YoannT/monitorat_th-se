class Lanceur extends Athlete implements Courir,Lancer{
	private int force,endurance,precision,score;
	
	public Lanceur(Pays pPays){
		super(pPays);
		this.force=Random.rInt(7,10);
		this.endurance=Random.rInt(7,10);
		this.precision=Random.rInt(7,10);
		this.score=0;
		this.numero=id;
		id++;
	}
	
	public int courir(){
		return (this.force);
	}
	
	public int lancer(){
		return (this.force+this.precision);
	}
	
	public String toString(){
		return super.toString()+" Lanceur";
	}
	
	public String getStats(){
		return this.force+" "+this.endurance+" "+this.precision;
	}
	
	public void setScore(int pScore){
		this.score=pScore;
	}
	
	public int getScore(){
		return this.courir()*this.lancer();
	}
	
	public boolean estDevant(Lanceur l)	{
		return this.getScore()>l.getScore();
	}
	
}
