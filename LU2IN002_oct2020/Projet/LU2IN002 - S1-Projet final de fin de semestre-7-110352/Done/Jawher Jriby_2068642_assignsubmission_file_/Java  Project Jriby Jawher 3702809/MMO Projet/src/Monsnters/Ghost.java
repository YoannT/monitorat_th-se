package Monsnters;

import Fights.Dark;

public class Ghost extends Goblin{

	protected Dark type;
	private final static double HP = 200;
	
	
	public Ghost() {
		super(HP);
		type = new Dark();
	}

}
