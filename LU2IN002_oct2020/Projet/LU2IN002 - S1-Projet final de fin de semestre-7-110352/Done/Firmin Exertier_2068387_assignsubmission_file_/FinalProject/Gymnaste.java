abstract class Gymnaste extends Athlete{
	protected int concentration,force,adresse,mobilite;
	
	public Gymnaste(Pays pPays){
		super(pPays);
		this.concentration=Random.rInt(7,10);//les stats sont prises entre 7 et 10 pour éviter les trop grands écarts
		this.force=Random.rInt(7,10);
		this.adresse=Random.rInt(7,10);
		this.mobilite=Random.rInt(7,10);
		this.numero=id;
		id++;
	}

	public int gymnastiquer(){//et oui c'est français
		return Random.rInt(7,10)*(this.concentration+this.force+this.adresse+this.mobilite);
	}

	public String toString(){
		return super.toString()+" Gymnaste";
	}	
		
	public String getStats(){
		return this.concentration+" "+this.force+" "+this.adresse+" "+this.mobilite;
	}
	
	public abstract int getScore();
	
	public boolean estDevant(Gymnaste g){
		return this.getScore()>g.getScore();
	}
}
