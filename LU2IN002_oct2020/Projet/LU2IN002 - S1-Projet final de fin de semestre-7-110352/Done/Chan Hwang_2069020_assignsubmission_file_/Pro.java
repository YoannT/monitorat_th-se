/**
	* @author J\u00e9r\u00e9my LIN | Chang Yeong HWANG
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Pro extends Joueur implements Effet{
	protected double Pbtaper=0.90;
	protected double Pbprecision=0.80;
	protected double Pbcoupe= 0.45;
	protected double Pblift=0.22;
	protected double Pbsmash=0.15;
	protected double PbEffet=0.30;
	protected int classement;



	public Pro(String name,int classement)throws ClassementException{
		super(name);
		if (classement > 100){
			// Ici moins le classement est élevée plus le joueur est compétent
			throw new ClassementException("Mauvaise categorie, veuillez choisir un classement moins \u00e9lev\u00e9e");
		}
		this.classement=classement;
  	}


  public String toString(){
  		return "Je suis "+this.getNom();
  	}

	public int getClassement(){
		return classement;
	}
	public void setClassement(int a){
		this.classement=a;
	}
  public boolean coupe(){
    if((Math.random()*(1))>Pbcoupe){
			return true;
		}
		return false;
  }

  public boolean lift(){
    if((Math.random()*(1))>Pblift){
			return true;
		}
		return false;
  }

  public boolean smash(){
  	if((Math.random()*(1))>Pbsmash){
			return true;
		}
	return false;
  }

	public boolean renvoyerBienPro(Joueur j, boolean coupe, boolean lift, boolean smash){//joueur adversaire en parametre
		double p=(Math.random()*(1));
		double t=(Math.random()*(1));
		if(p <= Pbtaper && t <= Pbprecision){
			double e=(Math.random()*(1-0.2)+0.2);
			if(e <= PbEffet){
				System.out.println(this.getNom()+" choisissez un effet :\n-1 pour le coup\u00e9\n-2 pour le lift\n-3 pour le smash");
				Scanner clavier = new Scanner(System.in);
				int q = Integer.parseInt(clavier.nextLine());
				switch(q){
      		case 1 :
      		System.out.println(this.getNom()+" cherche a faire le coup\u00e9");
					if(this.coupe()){
						System.out.println("coup\u00e9 reussi");
						j.setPbtaper(j.getPbtaper()-0.2);
						coupe=true;
					}
					else{
						System.out.println("Effet non r\u00e9ussi");
					}
      	return true;
      		case 2 :
      		System.out.println(this.getNom()+" cherche a faire le lift");
					if(this.lift()){
						System.out.println("lift r\u00e9ussi");
						j.setPbtaper(j.getPbtaper()-0.2);
						lift=true;
					}
					else{
						System.out.println("Effet non r\u00e9ussi");
					}
      		return true;
					case 3 :
      		System.out.println(this.getNom()+" cherche a faire le smash");
					if(this.smash()){
						System.out.println("smash r\u00e9ussi");
						j.setPbtaper(j.getPbtaper()-0.4);
						smash=true;
					}
					else{
						System.out.println("Effet non r\u00e9ussi");
					}
      		return true;
				}
			}
		}
		if(p>Pbtaper)
			System.out.println(this.getNom()+" n'a pas pu taper la balle");
		else if(t>Pbprecision)
			System.out.println("Faute pour "+this.getNom()+" La balle est sortie du terrain");
		return false;
	}

	public boolean renvoyerBien(){
			return true;
	}

}
