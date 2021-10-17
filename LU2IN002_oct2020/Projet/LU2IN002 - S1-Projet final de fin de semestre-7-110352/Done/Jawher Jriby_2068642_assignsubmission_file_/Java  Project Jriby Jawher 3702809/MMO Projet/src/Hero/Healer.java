package Hero;

import java.util.ArrayList;

import Interfaces.Actions;
import Interfaces.Levelling;
import Monsnters.Monster;

public class Healer extends Hero implements Levelling,Actions{

protected int healing;
private final static int DEFAULT_HEALING = 5;
private final static int RANGE = 4;
private final static int DEFAULT_HP = 200;
private final static int DEFAULT_AD = 30;
private final static double LEVELLING_AD = 1.05;
private final static double LEVELLING_HP = 1.1;
private final static int ULT = 3;
private final static int ULTCPT = 3;
private final static double HEAL_TRIGGER = 0.2;
private final static int RANGE_PRIORITY = 2;
private final static double HALF_HEALTH = 0.5;



boolean ult;
int cpt1=0;	
int cpt=0;

ArrayList<Hero> L = new ArrayList<Hero>() ; 

	public Healer(String name) {
		super(DEFAULT_HP,DEFAULT_AD,name,RANGE);
		healing=DEFAULT_HEALING;
	}
	
	@Override
	public void lvlup() {
		super.lvlup();
		while(cpt1<super.getlvl()-1) {
			cpt1++;
			super.setphyAtt(LEVELLING_AD);	
			super.sethpmax(LEVELLING_HP);
			healing++;
			}
		}
	
	public int getHealing() {
		return healing;
	}
	
	public void heal(ArrayList<Hero> L) {
			for (Hero a : L) {
				if (a.gethp() <= ( a.gethpmax()*HEAL_TRIGGER ) ) {
					a.sethp(healing);
					System.out.println("The "+a.getClass().getSimpleName()+" "+a.getName()+" is healed !"+"\n");
					return;
				}else {
					if(a.getRange() <= RANGE_PRIORITY && a.gethp() <= ( a.gethpmax()*HALF_HEALTH )) {
					a.sethp(healing);
					System.out.println("The "+a.getClass().getSimpleName()+" "+a.getName()+" is healed !"+"\n");
					return;
					}
				}
			}		
		}
		
	
	@Override
	public String toString() {
		return super.toString()+"Healing :"+healing+"\n";
	}
		
	@Override
	public void attack(Monster a) {
		a.attacked(getphyAtt());
		cpt++;
	}
	
	@Override
		public void ultimate() {
			if(cpt >= ULTCPT) {
				cpt=0;
				healing+=ULT;
				System.out.println(getName()+"'s  Ultimate Healing is On"+"\n");
				ult=true;
			}
	}
	
	@Override
		public void ultimateused() {
				if(ult) {
				healing-=ULT;
				ult=false;
				System.out.println(getName()+"'s  Ultimate Healing is used"+"\n");
				}
	}
}
