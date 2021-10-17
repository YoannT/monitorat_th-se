class GymnasteRythmique extends Gymnaste{
	private int scoreBallon,scoreMassue,scoreCerceau,scoreRuban;
	
	public GymnasteRythmique(Pays pPays){
		super(pPays);
		this.scoreBallon=0;
		this.scoreMassue=0;
		this.scoreCerceau=0;
		this.scoreRuban=0;
	}
	
	public String toString(){
		return super.toString()+" Gymnaste Rythmique";
	}
	
	public void setScores(int p1,int p2,int p3,int p4){
		if(p1!=0){
			this.scoreBallon=p1;
		}if(p2!=0){
			this.scoreMassue=p2;
		}if(p3!=0){
			this.scoreCerceau=p3;
		}if(p4!=0){
			this.scoreRuban=p4;
		}
	}
	
	public int getScore(){
		return this.scoreBallon+this.scoreMassue+this.scoreCerceau+this.scoreRuban;
	}
}
