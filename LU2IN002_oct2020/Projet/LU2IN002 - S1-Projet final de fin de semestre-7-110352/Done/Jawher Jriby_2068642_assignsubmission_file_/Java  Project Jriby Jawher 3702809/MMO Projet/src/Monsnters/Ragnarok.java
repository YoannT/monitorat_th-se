package Monsnters;

public class Ragnarok extends LegendaryMonster{
	private static final double HP = 70000;
	private static final double	DAMAGE = 300;
	private static final double RAGE = 6000;
	private static final int RAGE_EMPOWERMENT = 3;
	public Ragnarok() {
		super(HP, DAMAGE, RAGE);
		
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

}


