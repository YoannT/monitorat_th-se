package Fights;

import java.util.ArrayList;

import Hero.Assassin;
import Hero.Healer;
import Hero.Hero;
import Hero.Valkyrie;
import Monsnters.Ghost;
import Monsnters.Goblin;
import Monsnters.LegendaryMonster;

public final class Game {
private static Game instance = new Game();
private static int LVLNEEDED =15;
private static int MIN=5;

private Game() {}

public static Game getInstance() {
	return instance;
}

ArrayList<Hero> L = new ArrayList<Hero>() ; 

public void JoinBossBattle (Hero a) throws BattleException {
	try {
			if (a.getlvl()<LVLNEEDED )
				throw new BattleException("The Hero's level is too low to join the raid boss battle!! "+"\n");
			for(Hero i : L) {
				if (i == a) {
					throw new RuntimeException(a.getName()+" has already joined the battle !! "+"\n");
				}
			}
			L.add(a);	
			System.out.println(a.getName()+" has joined the battle !! "+"\n");
		} 
	catch (BattleException e) {
		System.out.println("To join the boss battle you should be lvl "+LVLNEEDED+"\n");
	} 
	catch(RuntimeException e) {
		System.out.println("This hero has already joined the battle !! "+"\n");

	}
}

public void ReadyForBossBatlle() {
	try {
		if ( L.size()< MIN )
		throw new BattleException("The number of participants is not suffisant "+"\n");
		System.out.println("Let the battle begin!!"+"\n");

	}
	catch(BattleException e) {
		System.out.println (MIN-L.size()+" Heros are remaining!!"+"\n");
	
	}
}


public void GoblinBattle(Goblin gob,Hero h) {
	gob.respawn();
	h.inithp();
	System.out.println("let the Battle of the "+h.getClass().getSimpleName()+" "+h.getName()+" begin"+"\n");
	if (gob.getClass().equals(Ghost.class)) {
		if(  (h.getClass().equals(Valkyrie.class))  ||  (h.getClass().equals(Assassin.class))  ||  (h.getClass().equals(Healer.class))  ) {
			while(h.gethp()>0) {
				gob.attack(h);
			}
			System.out.println (h.getName()+" lost the battle The "+h.getClass().getSimpleName()+" Class can't use magic to kill the Ghost"+"\n");
			return;
			}
		}
		while((gob.getHp()>0) && (h.gethp()>0)){
			h.attack(gob);
			gob.attack(h);
			h.ultimateattack(gob);
			h.ultimateused();
			h.ultimate();
			gob.ultimateattack(h);
		}
	if (gob.getHp()<=0) {
		gob.dead();
		h.xpgain(gob.xpgiven());
		h.lvlup();
	}else {
		System.out.println (h.getName()+"lost the battle better luck next time"+"\n");
		}
	
}

public boolean GroupAlive() {
	for (Hero i : L) {
		if (i.gethp()>0) {return true;}
		}
	return false;	
	}

public void BossBattle(LegendaryMonster r) {
	ReadyForBossBatlle();
	r.respawn();
	for (Hero a : L) {
		a.inithp();
	}
	while (GroupAlive() && (r.getHp()>0) ) {
		for (Hero a : L) {
			if (a.getClass().equals(Healer.class)){
				Healer p =(Healer)a;
				p.heal(L);				
				}
			a.attack(r);
			a.ultimateattack(r);
			if (a.getClass().equals(Valkyrie.class)){
				Valkyrie p =(Valkyrie)a;
				p.ultimate();

				}
			if (a.getClass().equals(Healer.class)){
				Healer p =(Healer)a;
				p.ultimate();
				}
		}
		r.rage();
		r.attackAOE(L);
		r.ultimateattackAOE(L);
		r.heal();
		for(Hero a :L) {
			if (a.getClass().equals(Valkyrie.class)){
				Valkyrie p =(Valkyrie)a;
				p.ultimateused();

			}
			if (a.getClass().equals(Healer.class)){
				Healer p =(Healer)a;
				p.ultimateused();
				}
		}
	}
	if(r.getHp()<= 0) {
		r.dead();
		for (Hero a : L) {
			a.xpgain(r.xpgiven()/L.size());
			a.lvlup();
		}	
	}else {
		System.out.println("Unfortunately the Group formed for the fight is dead better luck next time !!"+"\n");
	}	
}	
	
}