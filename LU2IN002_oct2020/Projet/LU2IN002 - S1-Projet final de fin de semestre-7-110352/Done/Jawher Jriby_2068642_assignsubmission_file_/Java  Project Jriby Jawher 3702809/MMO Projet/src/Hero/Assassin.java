package Hero;

import Interfaces.Actions;
import Interfaces.Levelling;
import Monsnters.Monster;

public class Assassin extends Hero implements Levelling,Actions{
	
	protected int lethality;
	private final static int DEFAULT_LETHALITY = 15;
	private final static int RANGE = 2;
	private final static int DEFAULT_HP = 100;
	private final static int DEFAULT_AD = 150;
	private final static double LEVELLING_AD = 1.3;
	private final static double LEVELLING_HP = 1.1;
	private final static int ULTCPT = 5;
	private final static int ULT = 4;
	int cpt=0;
	int cpt1=0;



	public Assassin(String name) {
		super(DEFAULT_HP,DEFAULT_AD,name,RANGE);
		lethality = DEFAULT_LETHALITY;
	}	
	
	@Override
	public void lvlup() {
		super.lvlup();
		while(cpt<super.getlvl()-1) {
			super.setphyAtt(LEVELLING_AD);
			super.sethpmax(LEVELLING_HP);
			lethality++;
			cpt++;
		}
	}
	
	public int getLethality() {
		return lethality;
	}
	@Override
	public String toString() {

		return super.toString()+"Lethality : "+lethality+"\n";
	}
	
	@Override
	public void attack(Monster a) {
		a.attacked(getphyAtt()*((100+lethality)/100));
		cpt1++;
	}
	
	@Override
	public void ultimateattack(Monster a) {
		if (cpt1>=ULTCPT) {
			cpt1=0;
			System.out.println(getName()+" is using his ultimate attack"+"\n");
			a.attacked(getphyAtt()*((100+ULT*lethality)/100));
			}
		else {
			System.out.println(ULTCPT-cpt1+" attacks missing for " +getName() +" to activate the ultimate attack"+"\n");
			}	
	}
	
}