abstract class SportifCollectif extends Athlete{
	protected int force,endurance,adresse,collectif;
	
	public SportifCollectif(Pays pPays) {
		super(pPays);
		this.force=Random.rInt(7,10);
		this.endurance=Random.rInt(7,10);
		this.adresse=Random.rInt(7,10);		
		this.collectif=Random.rInt(7,10);		
		this.numero=id;
		id++;
	}
	
	public int jouer(){
		return Random.rInt(7,10)*(this.force+this.endurance+this.adresse+this.collectif);
	}
	
	public String toString(){
		return super.toString()+" SportifCollectif";
	}
	
	public String getStats(){
		return this.force+" "+this.endurance+" "+this.adresse+" "+this.collectif;
	}
	
}
