package Monsnters;

import Hero.Hero;
import Hero.Valkyrie;

public class Goblin extends Monster{

	protected double hp;
	protected double damage;
	protected int lvl;
	int cpt;
	private final static int MAXLVL = 30;
	private final static int DEFAULT_HP =100;
	private final static int DEFAULT_DAMAGE =5;
	private final static int DEFAULT_XP =30;

	private final static int ULTCPT = 6;
	private final static int ULT = 3;
		
	public Goblin() {
		this.lvl=(int)(Math.random()*(MAXLVL-1))+1;
		this.hp=DEFAULT_HP*lvl;
		this.damage=DEFAULT_DAMAGE*lvl;
	}
	
	public Goblin clone() {
		return new Goblin(lvl);
	}
	
	public Goblin(int lvl) {
		this.lvl=lvl;
		this.hp=DEFAULT_HP*lvl;
		this.damage=DEFAULT_DAMAGE*lvl;
		}
	
	public Goblin(double hp) {
		this.lvl=(int)(Math.random()*(MAXLVL-1))+1;
		this.hp=hp;
		this.damage=DEFAULT_DAMAGE*lvl;
	}
	
	

	@Override
	public double xpgiven() {
		return lvl*DEFAULT_XP;
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
	
	@Override
	public void attack(Hero a) {
		if (a.getClass().equals(Valkyrie.class)) {
			Valkyrie p =(Valkyrie)a;
			p.damaged(damage / (100 - p.getArmor()));			
		}else {
			a.damaged(damage);
		}
	cpt++;
	}
	
	@Override
	public void ultimateattack(Hero a) {
		if (cpt>=ULTCPT) {
			cpt=0;
			System.out.println(getClass().getSimpleName()+"is using his ultimate attack");
			a.damaged(damage*ULT);
			}
		else {
			System.out.println(ULTCPT-cpt+" attacks missing for the "+getClass().getSimpleName()+" to activate the ultimate attack"+"\n");
		}		
	}
	
	@Override
	public void attacked(double a) {
		hp-=a;
	}
	
	@Override
	public void dead() {
			System.out.println("This "+getClass().getSimpleName()+" is dead and you earned  "+xpgiven()+" xp points yey!!");
	}
		
}
