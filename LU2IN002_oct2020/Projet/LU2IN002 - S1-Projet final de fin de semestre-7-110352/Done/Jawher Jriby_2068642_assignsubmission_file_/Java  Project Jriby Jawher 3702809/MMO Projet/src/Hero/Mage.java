package Hero;

import Fights.Dark;
import Fights.Element;
import Fights.Fire;
import Fights.Light;
import Fights.Water;
import Interfaces.Actions;
import Interfaces.Levelling;
import Monsnters.Dragon;
import Monsnters.Monster;

public class Mage extends Hero implements Levelling,Actions{
	protected Element type;
	protected double ap;
	private final static int DEFAULT_AP = 100;
	private final static int RANGE = 3;
	private final static int DEFAULT_HP = 100;
	private final static int DEFAULT_AD = 50;
	private final static double LEVELLING_AD = 1.01;
	private final static double LEVELLING_HP = 1.1;
	private final static int ULTCPT = 4;
	private final static double LEVELLING_AP = 1.11;
	private final static double ULT = 1.5;
	private final static int  EFFICIENCY = 2;

	int cpt=0;
	int cpt1=0;

	public Mage(String name,Element type) {
		super(DEFAULT_HP,DEFAULT_AD,name,RANGE);
		this.type = type;
		ap=DEFAULT_AP;
		}
	
	@Override
	public void xpgain(double exp) {
		super.xpgain(exp);
	}
	@Override
	public void lvlup() {
		super.lvlup();
		while(cpt < (super.getlvl()-1)) {
		cpt++;
		super.setphyAtt(LEVELLING_AD);
		super.sethpmax(LEVELLING_HP);
		ap=ap*LEVELLING_AP;
		}
	}
	
	@Override
	public void attack(Monster a) {
		if(a.getClass().equals(Dragon.class)) {
			Dragon p = (Dragon)a;
			if( this.type.getClass().equals(Water.class) && p.getType().getClass().equals(Fire.class) 
				|| this.type.getClass().equals(Light.class) && p.getType().getClass().equals(Dark.class)) {
				p.attacked(ap*EFFICIENCY);
			}else {
				if(type.getClass().equals(p.getType().getClass())) {
					p.attacked((ap/EFFICIENCY));}			}
		}else {
		a.attacked(ap);
		}
		cpt1++;
	}
	
	@Override
	public void ultimateattack(Monster a) {
		if (cpt1>=ULTCPT) {
			cpt1=0;
			System.out.println(getName()+" is using his ultimate attack"+"\n");
			if(a.getClass().equals(Dragon.class)) {
				Dragon p = (Dragon)a;
				if( this.type.getClass().equals(Water.class) && p.getType().getClass().equals(Fire.class) 
					|| this.type.getClass().equals(Light.class) && p.getType().getClass().equals(Dark.class)) {
					p.attacked(ap*ULT*EFFICIENCY);
				}else {
					if(type.getClass().equals(p.getType().getClass())) {
						p.attacked((ap/EFFICIENCY));}					}
			}else {
			a.attacked(ap*ULT);
			}
			}
		else {
			System.out.println(ULTCPT-cpt1+" attacks missing for " +getName() +" to activate the ultimate attack"+"\n");
			}
	}
	
	public double getAp() {
		return ap;
	}
	
	public Element getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Magical Damage : "+df.format(ap)+"\n"+"Element : "+type.getClass().getSimpleName()+"\n";
	}
}
