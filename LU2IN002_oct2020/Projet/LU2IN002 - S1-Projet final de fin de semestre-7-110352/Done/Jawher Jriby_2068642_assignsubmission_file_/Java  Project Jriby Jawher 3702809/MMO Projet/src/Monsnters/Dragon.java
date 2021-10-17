package Monsnters;

import java.util.ArrayList;

import Fights.Dark;
import Fights.Element;
import Fights.Fire;
import Fights.Light;
import Fights.Water;
import Hero.Hero;
import Hero.Mage;
import Hero.Valkyrie;

public class Dragon extends LegendaryMonster{
	
	protected Element type;
	private static final double HP = 90000;
	private static final double	DAMAGE = 200;
	private static final double RAGE = 5000;
	private static final int RAGE_EMPOWERMENT = 5;
	private static final int EFFICIENCY = 2;
	private static final double LESS_EFFICIENCY = 0.75;
	private final static int ULT = 3;
	private final static int ULTCPT = 5;

	
	public Dragon(Element type) {
		super(HP, DAMAGE, RAGE);
		this.type=type;
	}
	
	public Element getType() {
		return type;
	}
	
	@Override
	public void rage() {
		if(super.getHp()<RAGE)
			super.setDamage(RAGE_EMPOWERMENT);	
		}
	
	@Override
	public void respawn() {
		hp=HP;
		}
	
	@Override
	public void ultimateattackAOE(ArrayList<Hero> a) {
		if (super.cpt>=ULTCPT) {
			super.cpt=0;
			super.cpt1++;
			System.out.println(getClass().getSimpleName()+" is using his ultimate attack"+"\n"+"He will deal around "+getDamage()*ULT+" Damage!!"+"\n");
			for(Hero i :a) {
				if (i.getClass().equals(Valkyrie.class)) {
					Valkyrie p =(Valkyrie)i;
					p.damaged((damage*ULT/p.getRange()) / (100 - p.getArmor()));			
				}else {
				if(i.getClass().equals(Mage.class)) {
					Mage p = (Mage) i;
					if(type.getClass().equals(Water.class) && p.getType().getClass().equals(Fire.class) 
					|| type.getClass().equals(Light.class) && p.getType().getClass().equals(Dark.class)) {
						p.damaged((ULT*damage*EFFICIENCY)/p.getRange());
					}
					if(type.getClass().equals(p.getType().getClass())) {
					p.damaged((ULT*damage*LESS_EFFICIENCY)/p.getRange());}
				}
				}
				i.damaged(ULT*damage/i.getRange());
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
			if(i.getClass().equals(Mage.class)) {
				Mage p = (Mage) i;
				if(type.getClass().equals(Water.class) && p.getType().getClass().equals(Fire.class) 
				|| type.getClass().equals(Light.class) && p.getType().getClass().equals(Dark.class)) {
					p.damaged((damage*EFFICIENCY)/p.getRange());
				}	
				if(type.getClass().equals(p.getType().getClass())) {
					p.damaged((damage*LESS_EFFICIENCY)/p.getRange());}			}
			}
			i.damaged(damage/i.getRange());
			}
		super.cpt++;
		super.cpt1++;
	}
}
