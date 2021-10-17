public abstract class Personne{

	protected int posx;
	protected int posy;
	protected String nom;
	
	public Personne(int posx,int posy,String nom){
		this.posx = posx;
		this.posy = posy;
		this.nom = nom;
	}

	
	public void setPosition( int posx, int posy) { // Méthode permettant de donner une nouvelle position à la personne
        this.posx = posx;
        this.posy = posy;
  }
  
   public void Positioninit() { // Position de la personne lorsque celle ci n'est pas dans l'arene (hors de celle ci)
        this.posx = -1;
        this.posy = -1;
    }


	

	public abstract void action();//Méthode abstract permettant une action différente selon la personne
	
	
	
	public String get_nom(){ //Méthode permettant d'obtenir le nom de la personne
    	return this.nom;

   }
  
}
