class GymnasteArtistique extends Gymnaste{
	private int scoreSol,scoreCheval,scoreAnneaux,scoreSaut,scoreParalleles,scoreFixe;
	
	public GymnasteArtistique(Pays pPays){
		super(pPays);
		this.scoreSol=0;
		this.scoreCheval=0;
		this.scoreAnneaux=0;
		this.scoreSaut=0;
		this.scoreParalleles=0;
		this.scoreFixe=0;	
	}
	
	public String toString(){
		return super.toString()+" Gymnaste Artistique";
	}
	
	public void setScores(int p1,int p2,int p3,int p4,int p5,int p6){
		if(p1!=0){
			this.scoreSol=p1;
		}if(p2!=0){
			this.scoreCheval=p2;
		}if(p3!=0){
			this.scoreAnneaux=p3;
		}if(p4!=0){
			this.scoreSaut=p4;
		}if(p5!=0){
			this.scoreParalleles=p5;
		}if(p6!=0){
			this.scoreFixe=p6;
		}
	}
	
	public int getScore(){
		return this.scoreSol+this.scoreCheval+this.scoreAnneaux+this.scoreSaut+this.scoreParalleles+this.scoreFixe;
	}
	
}
