package Fights;

import Hero.Assassin;
import Hero.Healer;
import Hero.Mage;
import Hero.Valkyrie;
import Monsnters.Dragon;
import Monsnters.Ghost;
import Monsnters.Goblin;

public class TestGame {
public static void main(String[] args) throws Exception {
	
	Game game= Game.getInstance();
	Fire fire= new Fire();
	Dark dark= new Dark();
	Water water= new Water();
	Light light= new Light();
	Ghost g= new Ghost();
	Goblin gob = new Goblin(10);
	Goblin p = gob.clone();
	System.out.println(p.getHp());
	System.out.println(gob.getHp());
	
	Mage l= new Mage("Skeptomia 1",light);
	Mage s= new Mage("Skeptomia",fire);
	Mage m= new Mage("Skeptomia Fan",dark);

	Valkyrie v= new Valkyrie("Heilong");
	Assassin a= new Assassin ("Bengi");
	Healer h= new Healer("Soraka");
	System.out.println(s.toString());
	s.xpgain(60000);
	s.lvlup();
	a.xpgain(6000);
	a.lvlup();
	v.xpgain(6000);
	v.lvlup();
	h.xpgain(6000);
	h.lvlup();
	l.xpgain(60000);
	l.lvlup();
	
	System.out.println();
	System.out.println(g.getHp()+"\n");
	System.out.println(s.toString());

	game.GoblinBattle(gob,v);


	System.out.println();
	System.out.println();
	System.out.println(s.toString());
	
	game.JoinBossBattle(s);
	game.JoinBossBattle(a);
	game.JoinBossBattle(v);
	game.JoinBossBattle(h);
	game.JoinBossBattle(m);
	game.ReadyForBossBatlle();

	m.xpgain(6000);
	m.lvlup();
	game.JoinBossBattle(m);

	
	game.ReadyForBossBatlle();
	Dragon heilong = new Dragon(water);
	game.BossBattle(heilong);
}
}
