class TestVillageois{
	public static void main(String[] args) {
		Villageois v0 = new Villageois("A");
		Villageois v1 = new Villageois("B");
		Villageois v2 = new Villageois("C");
		Villageois v3 = new Villageois("D");

		System.out.println(
			v0.toString() + "\n" 
			+ v1.toString() + "\n" 
			+ v2.toString() + "\n" 
			+ v3.toString()
			);

		double poidsTotal = v0.poidsSouleve()
		+ v1.poidsSouleve() + v2.poidsSouleve() + v3.poidsSouleve();

		if (poidsTotal > 100)
			System.out.println("Le rocher a ete souleve!, poids Total: " + poidsTotal);
		else
			System.out.println("Le rocher n'a pas été souleve  poids Total: " + poidsTotal);

	}
}