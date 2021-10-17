public class Simulation{	
	public static void main(String[] args){
		Terrain t = new Terrain();
		System.out.print(t);
		while(t.fin()){
			t.evolve();
			System.out.print(t);
			try{
		     Thread.sleep(100); // 100 ms
 			 }catch(Exception e){
 			    e.printStackTrace();
		  		}
			}
		}
		
}
