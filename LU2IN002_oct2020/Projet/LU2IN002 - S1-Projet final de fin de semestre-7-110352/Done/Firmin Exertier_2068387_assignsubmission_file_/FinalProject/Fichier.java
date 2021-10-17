import java.io.*;
import java.util.ArrayList;

class Fichier{
	private String nomFichier;
	
	public Fichier(String pFichier){//consructeur à utiliser lorsque le fichier est déjà present
		this.nomFichier=pFichier;
	}
	
	public Fichier(){//constructeur à utiliser lorsqu'on souhaite creer un fichier, il faut donc utiliser creerFichier()
		this.nomFichier="non defini";
	}
	
	public  int getLignesFichier(){
		int c=0;
		try{
			FileReader fR= new FileReader(new File(this.nomFichier));
			BufferedReader bR=new BufferedReader(fR);
			String s=bR.readLine();
			while(s!=null){
				c++;
				s=bR.readLine();
			}
			bR.close();
		}catch(Exception e){
				System.out.println("Erreur ouverture du fichier");
				return 0;
		}
		return c;
	}
	
	public String getRandomLigne(){
		String retour="";
		try{
			FileReader fR=new FileReader(new File(this.nomFichier));
			BufferedReader bR=new BufferedReader(fR);
			int ligne=(int)(Math.random()*this.getLignesFichier());
			for(int i=0;i<=ligne;i++){
				retour=bR.readLine();
			}
			bR.close();
		}catch(Exception e){
			System.out.println("Erreur ouverture fichier");
		}
		
		return retour;
	}
	
	public ArrayList<String> getAllLignes(){
		ArrayList<String> retour=new ArrayList<String>();
		String temp="";
		try{
			FileReader fR=new FileReader(new File(this.nomFichier));
			BufferedReader bR=new BufferedReader(fR);
			temp=bR.readLine();
			while(temp!=null){
				retour.add(temp);
				temp=bR.readLine();
			}
			bR.close();
		}catch(Exception e){
			System.out.println("Erreur ouverture fichier");
		}
		return retour;
		
	}
	
	public void creerFichier(String pNom) throws DossierNonExistantException{
		try{
			File f=new File("logs/"+pNom);
			if(f.exists()){
				System.out.println("Ancien fichier de logs ecrase");
				f.delete();
			}
			f.createNewFile();
			FileWriter fW=new FileWriter(f);
			BufferedWriter bW=new BufferedWriter(fW);
			bW.close();
		}catch(Exception e){
			File log=new File("logs");
			if(!log.exists()){
				throw new DossierNonExistantException("Dossier logs introuvable");
			}
			System.out.println(e.getMessage());
		}
		this.nomFichier=pNom;
	}
	
	public void insererLigne(String pLigne){
		try{
			BufferedWriter bW=new BufferedWriter(new FileWriter("logs/"+this.nomFichier,true));
			bW.write(pLigne+"\n");
			bW.close();
		}catch(Exception e){
			System.out.println("Erreur lors de l'écriture dans le fichier");
		}
	}
		

}
