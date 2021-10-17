package Hero;

import Interfaces.Actions;
import Interfaces.Levelling;
import Monsnters.Monster;

public class Valkyrie extends Hero implements Levelling,Actions{
	protected int armor;
	private final static int DEFAULT_ARMOR = 10;
	private final static int RANGE = 1;
	private final static int DEFAULT_HP = 500;
	private final static int DEFAULT_AD = 60;
	private final static double LEVELLING_AD = 1.1;
	private final static double LEVELLING_HP = 1.11;
	private final static int ULT = 3;
	private final static int ULTCPT = 3;

	int cpt=0;
	int cpt1=0;
	boolean ult;
	
	public Valkyrie(String name) {
		super(DEFAULT_HP,DEFAULT_AD,name,RANGE);
		armor =DEFAULT_ARMOR;
	}
	
	public Valkyrie() {
		super();
	}

	@Override
	public void lvlup() {
		super.lvlup();
		while(cpt < super.getlvl()-1){
			cpt++;
			super.setphyAtt(LEVELLING_AD);
			super.sethpmax(LEVELLING_HP);
			armor++;
		}
	}
	
	public int getArmor() {
		return armor;
	}
	
	@Override
	public void attack(Monster a) {
		a.attacked(getphyAtt());
		cpt1++;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Armor : "+armor+"\n";
	}
	
	@Override
	public void ultimate() {		
		if ( cpt1 >= ULTCPT) {	
			cpt1=0;
			armor+=ULT;
			System.out.println(getName()+"'s  MythicShiled is On"+"\n");
			ult=true;
		}
}	
	
	@Override
	public void ultimateused() {
			if(ult) {
			armor-=ULT;
			ult=false;
			System.out.println(getName()+"'s  MythicShiled is Off"+"\n");
			}
	}
}