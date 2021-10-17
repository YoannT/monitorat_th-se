abstract class Combattant extends Athlete{
	protected int cardio,force,adresse,agilite;
	
	public Combattant(Pays pPays){
		super(pPays);
		this.cardio=Random.rInt(7,10);//les stats sont prises entre 7 et 10 pour éviter les trop grands écarts
		this.force=Random.rInt(7,10);
		this.adresse=Random.rInt(7,10);
		this.agilite=Random.rInt(7,10);
		this.numero=id;
		id++;
	}
	
	public int combattre(){
		return Random.rInt(7,10)*(this.cardio+this.force+this.adresse+this.agilite);
	}
	
	public String toString(){
		return super.toString()+" Combattant";
	}	
	
	public int getCardio(){
		return this.cardio;
	}
	
	public String getStats(){
		return this.cardio+" "+this.force+" "+this.adresse+" "+this.agilite;
	}
}
