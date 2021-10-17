package Monsnters;

import java.util.ArrayList;

import Hero.Hero;
import Interfaces.ActionsMonster;

public abstract class Monster implements ActionsMonster{


	public Monster() {}
	
	@Override
	public void attack(Hero a) {
		
	}
	
	@Override
	public void ultimateattack(Hero a) {
		
	}
	
	@Override
	public void heal() {		
	}
	
	@Override
	public void rage() {	
	}
	
	@Override
	public void attackAOE(ArrayList<Hero> a) {
		}
	
	@Override
	public void ultimateattackAOE(ArrayList<Hero> a) {		
	}
	
		
	@Override
	public void attacked(double a) {
	}
	
	@Override
	public void dead() {
		
	}
	
	@Override
	public void respawn() {
		
	}

	public abstract double xpgiven();

}


