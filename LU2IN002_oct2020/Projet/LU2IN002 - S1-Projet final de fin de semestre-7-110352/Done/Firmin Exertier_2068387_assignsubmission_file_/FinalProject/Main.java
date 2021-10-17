import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Main{
	public static void main(String args[])throws DossierNonExistantException{
		boolean valide=true;
		String date="";
		String ville="";
		Scanner scan= new Scanner(System.in);
		while(valide){
			System.out.println("Entre un nom de ville");
	    	ville=scan.nextLine();
	    	if(verifString.estVille(ville)){
	    		valide=false;
	    	}
		}
		valide=true;
		while(valide){
			System.out.println("Entre une date format --/--/----");
	    	date=scan.nextLine();
	    	if(verifString.estDate(date)){
	    		valide=false;
	    	}
		}
					
		JO jo=JO.creerJO(date,ville);
		jo.init();
		jo.deroulement();
				

		
	}
}
