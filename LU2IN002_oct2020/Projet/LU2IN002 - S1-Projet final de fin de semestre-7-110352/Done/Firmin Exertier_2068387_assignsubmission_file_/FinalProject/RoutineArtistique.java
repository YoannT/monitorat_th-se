class RoutineArtistique extends Routine{
	public RoutineArtistique(String pDate,GymnasteArtistique g){
		super(pDate,g);
	}

	public Class getTypeAthlete(){
		return GymnasteArtistique.class;
	}
	
	public int deroulement(){
		return this.gymnaste.gymnastiquer();
	}

}
