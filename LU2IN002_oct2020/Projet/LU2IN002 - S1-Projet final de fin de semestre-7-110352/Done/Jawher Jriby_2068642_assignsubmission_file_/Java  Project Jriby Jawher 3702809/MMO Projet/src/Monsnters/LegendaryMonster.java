package Monsnters;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Hero.Hero;
import Hero.Valkyrie;

public class LegendaryMonster extends Monster{

	protected double hp;
	protected double damage;
	protected double rage;
	private final static int XPGIVEN = 10000;
	private final static int ULT = 3;
	private final static int ULTCPT = 5;
	private final static int HEALINGCPT = 3;
	private final static int HEALING = 8000;


	int cpt1=0;
	int cpt=0;
	
	public LegendaryMonster(double hp,double damage,double rage) {
		this.hp=hp;
		this.damage=damage;
		this.rage=rage;
		}
	@Override
	public double xpgiven() {
		return XPGIVEN;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public double getDamage() {
		return damage;
	}
	public void setDamage(int a) {
		damage=damage*a;
	}
	
	public double getRage() {
		return rage;
	}
		
	@Override
	public void ultimateattackAOE(ArrayList<Hero> a) {
		if (cpt>=ULTCPT) {
			cpt=0;
			cpt1++;
			System.out.println(getClass().getSimpleName()+" is using his ultimate attack"+"\n"+"He will deal around "+getDamage()*ULT+" Damage!!"+"\n");
			for(Hero i :a) {
				if (i.getClass().equals(Valkyrie.class)) {
					Valkyrie p =(Valkyrie)i;
					p.damaged(((damage*ULT)/p.getRange()) / (100 - p.getArmor()));			
				}else {
					i.damaged((damage*ULT)/i.getRange());
				}
				}
		}
		else {
			System.out.println(ULTCPT-cpt+" attacks missing for this " +getClass().getSimpleName()+" to activate the ultimate attack "+"\n");
		}		
	}
	
	@Override
	public void attackAOE(ArrayList<Hero> a) {
		for(Hero i :a) {
		if (i.getClass().equals(Valkyrie.class)) {
			Valkyrie p =(Valkyrie)i;
			p.damaged((damage/p.getRange()) / (100 - p.getArmor()));			
		}else {
			i.damaged(damage/i.getRange());
		}
		}
	cpt++;
	cpt1++;
	}
	
	@Override
	public void attacked(double a) {
		hp=hp-a;
	}

	public void dead() {
		if (hp<=0) {
			System.out.println("This "+getClass().getSimpleName()+" is dead and you earned  "+xpgiven()+" xp points yey!!"+"\n");
		}
	}
	@Override
	public void respawn() {		
	}

	@Override
	public void heal() {
		if (cpt1 >= HEALINGCPT && hp>0) {
			cpt1=0;
			hp+=HEALING;
			System.out.println("The "+getClass().getSimpleName()+" is healing himself !!"+"\n"+"now he has "+df.format(hp)+" Health points!"+"\n" );
		}
	}

	DecimalFormat df = new DecimalFormat("#.##");

	
}

