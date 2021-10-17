package Hero;

import java.text.DecimalFormat;

import Interfaces.Actions;
import Interfaces.Levelling;
import Monsnters.Monster;

public class Hero implements Levelling,Actions{


private double hp,hpmax;
private double xp;
private double phyAtt;
private int lvl;
private double xpmax;
private String name;
private int range;


public Hero(int hp,int phyAtt,String name,int range) {
	this.name = name;
	this.hpmax = hp;
	this.phyAtt = phyAtt;
	this.range=range;
	lvl = 1;
	xp =0;
	xpmax = 50;
	this.hp=hpmax; 
}


public Hero() {
}


public void xpgain(double exp) {
	xp+=exp;
}

public void lvlup() {
	int p =lvl;
	while (xp>xpmax && lvl<30) {
		xp-=xpmax;
		lvl++;
		xpmax=xpmax*1.2;
		}
	if (p<lvl)
	System.out.println(name +" Congratulations!! Now you're level "+lvl+"\n");
	}
	

public double gethp(){
	return hp;
}

public double gethpmax(){
	return hpmax;
}

public void sethp(double a) {
	hp=hp+(hpmax*a/100);
	if (hp>hpmax) {
		hp =hpmax;
	}
}

public void sethpmax(double a) {
	hpmax=hpmax*a;
}

public double getxp() {
	return xp;
}

public double getphyAtt() {
	return phyAtt;
}

public void setphyAtt(double a) {
	phyAtt= phyAtt * a;
}

public int getlvl() {
	return lvl;
}

public double getxpmax() {
	return xpmax;
}

public String getName() {
	return name;
}

@Override
public void inithp() {
	hp=hpmax;
}

@Override
public void attack(Monster a) {
}

@Override
public void ultimateattack(Monster a) {
}

DecimalFormat df = new DecimalFormat("#.##");

public String toString() {
	return "Name = "+name+"\n"+"Hp : "+df.format(hpmax)+"\n"+"Lvl : "+lvl+"\n"+"Xp : "+df.format(xp)+"\n";
}

public void damaged(double a) {
	hp-=a;
}

@Override
public void ultimate() {
}

@Override
public void ultimateused() {
}


public int getRange() {
	return range;
}

}