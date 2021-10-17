package Interfaces;

import java.util.ArrayList;

import Hero.Hero;

public interface ActionsMonster {

	void attack(Hero a);
	void ultimateattack(Hero a);
	void heal();
	void rage();
	void attacked(double a);
	void dead();
	void attackAOE(ArrayList<Hero> a);
	void ultimateattackAOE(ArrayList<Hero> a);
	void respawn();
}