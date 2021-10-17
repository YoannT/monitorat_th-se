class Trampoliniste extends Gymnaste{
	private int score1,score2,score3;

	
	public Trampoliniste(Pays pPays){
		super(pPays);
		this.score1=0;
		this.score2=0;
		this.score3=0;
	}
	
	public String toString(){
		return super.toString()+" Trampoliniste";
	}
	
		
	
	public void setScores(int p1,int p2,int p3){
		if(p1!=0){
			this.score1=p1;
		}if(p2!=0){
			this.score2=p2;
		}if(p3!=0){
			this.score3=p3;
		}
	}
	
	public int getScore(){
		if(this.score1>=this.score2 && this.score1>=this.score3) {
			return this.score1;
		}if(this.score2>=this.score3){
			return this.score2;
		}
		return this.score3;
	}
}
