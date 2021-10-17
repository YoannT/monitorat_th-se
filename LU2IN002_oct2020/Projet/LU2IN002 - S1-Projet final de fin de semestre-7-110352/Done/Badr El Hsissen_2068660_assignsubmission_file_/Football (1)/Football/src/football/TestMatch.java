package football;

import java.util.Scanner;
public class TestMatch {

	public static void main(String[] args) {
		
		Championnat ch= new Championnat(8);
		ch.ChargerEquipe(8);
		String menu;
		ch.Tirage();
		boolean continuer= true;
		Scanner sc= new Scanner(System.in);
		while(continuer) {
		menu= "1- Afficher le nom de l'equipe, joueurs et leurs prime, salaire : \n 2- Afficher le deroulement de la Championnat \n 3- Quitter\n ";
		int choix;
		System.out.println(menu);
		System.out.println("quel est votre choix? ");
		choix=sc.nextInt();
		switch (choix){
		case 1:	
			
			for(int i=0;i<8;i++) {
				System.out.println(ch.equipes[i].toString());
			}
				break;
				
		case 2:
			
			ch.Classement();
			System.out.println("le classement des equipes est: ");
			for(int i=0;i<8;i++) {
				System.out.println(ch.equipes[i].NomEquipe);
				System.out.println(ch.equipes[i].NombrePoints);
			}
			break;
			
		case 3:
			
			continuer=false;
			System.out.println(menu);
			break;
			
			}
		}
	}
}