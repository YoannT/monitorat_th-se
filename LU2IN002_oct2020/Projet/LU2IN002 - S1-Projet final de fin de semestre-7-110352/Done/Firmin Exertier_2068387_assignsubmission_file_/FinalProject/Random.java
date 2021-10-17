final class Random{
	public static int rInt(int borneMax){//tire un nombre entre 0 et borne compris
		return (int)(Math.random()*(borneMax+1));
	}
	public static int rInt(int borneMin,int borneMax){//tire un nombre entre borneMin et borneMax compris
		if(borneMin>borneMax){
			System.out.println("Mauvaises Bornes");
			return 0;
		}
		return rInt(borneMax-borneMin)+borneMin;
		}
}
