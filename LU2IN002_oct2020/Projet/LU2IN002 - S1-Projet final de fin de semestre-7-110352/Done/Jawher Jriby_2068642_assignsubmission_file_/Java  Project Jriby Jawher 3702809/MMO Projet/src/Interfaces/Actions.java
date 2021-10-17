package Interfaces;

import Monsnters.Monster;

public interface Actions {

	void inithp();
	void attack(Monster a);
	void ultimateattack(Monster a);
	void damaged(double a);
	void ultimate();
	void ultimateused();
	
	
}
