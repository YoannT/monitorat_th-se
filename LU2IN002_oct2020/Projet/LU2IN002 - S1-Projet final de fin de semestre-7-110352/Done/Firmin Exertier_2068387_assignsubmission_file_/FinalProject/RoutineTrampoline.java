class RoutineTrampoline extends Routine{

	public RoutineTrampoline(String pDate,Trampoliniste t){
		super(pDate,t);	
	}
	
	public Class getTypeAthlete(){
		return Trampoliniste.class;
	}
	
	public int deroulement(){
		return this.gymnaste.gymnastiquer();
	}
	
}
