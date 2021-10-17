/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public class ProFemme extends Pro implements Effet{
	public ProFemme(String name,int classement)throws ClassementException{
    	super(name,classement);

  	}

	public void entrainementPrecision(){
		super.Pbprecision=super.Pbprecision + 0.10;
	}

	public void secherEntrainement(){
		if(Pbprecision<1)
			super.Pbprecision-=0.05;
	}

	public void pause(){
		if(Pbcoupe<1)
			super.Pbcoupe+=0.01;
		if(Pblift<1)
			super.Pblift+=0.01;
	}
	public int getClassement(){
		return super.classement;
	}

	public String toString(){
		return super.nom+ " : classement " + classement;
	}
}
