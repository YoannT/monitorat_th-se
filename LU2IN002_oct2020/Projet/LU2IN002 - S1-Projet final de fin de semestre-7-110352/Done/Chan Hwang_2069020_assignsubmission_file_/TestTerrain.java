/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
public class TestTerrain{
	public static void main(String[] args){
		Terrain t= Terrain.singletonTerrain();
		t.afficheTerrain();
		Balle b1= new Balle(4,17);
		t.placeBalleInTerrain(b1);
		t.afficheTerrain();
		t.removeBalleOutTerrain();
		t.afficheTerrain();
	}
}
