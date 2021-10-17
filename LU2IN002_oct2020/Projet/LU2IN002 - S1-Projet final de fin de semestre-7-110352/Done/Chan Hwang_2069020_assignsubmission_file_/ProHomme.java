/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public class ProHomme extends Pro implements Effet{

	public ProHomme(String name,int classement)throws ClassementException{
    	super(name,classement);

  	}

	public void entrainementTaper(){
		if(super.Pbtaper<1)
			super.Pbtaper=super.Pbtaper + 0.05;
	}

	public void secherEntrainement(){
		if(Pbtaper>0)
			super.Pbtaper-=0.03;
	}

	public void pause(){
		if(Pbsmash<1)
			super.Pbsmash+=0.01;
	}
	public int getClassement(){
		return super.classement;
	}
	public String toString(){
		return super.nom+ " : classement " + classement;
	}
}
