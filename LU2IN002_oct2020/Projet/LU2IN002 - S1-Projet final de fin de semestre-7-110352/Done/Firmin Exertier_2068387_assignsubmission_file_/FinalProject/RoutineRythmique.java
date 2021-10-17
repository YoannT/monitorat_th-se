class RoutineRythmique extends Routine{
	
	public RoutineRythmique(String pDate,GymnasteRythmique g){
		super(pDate,g);
	}
	
	public Class getTypeAthlete(){
		return GymnasteRythmique.class;
	}
	
	public int deroulement(){
		return this.gymnaste.gymnastiquer();
	}
	
}
