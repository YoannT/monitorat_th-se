public class Ruche extends Ressource {
    private Abeilles abeilles;
    private Terrain terrain;
    private Ressource ruche;
    private Ressource miel;
    private boolean estVide;

    public Ruche(){
        super("ruche",1);
        estVide = true;
    }

    public boolean estVide() {
        return estVide;
    }

    // La ruche n'est plus vide !
    public void remplir(){
        if (estVide = true) {
            estVide = false;
        }

    }

}
