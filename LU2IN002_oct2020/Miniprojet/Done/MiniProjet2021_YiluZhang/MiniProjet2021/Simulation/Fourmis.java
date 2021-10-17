public class Fourmis extends Agent {
    private static int vitesse=2;   //la vitesse de chaque fourmis/min.
    
    public Fourmis (int x, int y) {
        super(x, y);
    }
    
    public Fourmis (Fourmis fm) {
        super(fm.x, fm.y);
    }
    
    @Override
    public String recolte() {
        return "Le fourmis "+super.id+" a trouve de nourriture";
    }
    
    @Override
    public int getVitesse() {
        return vitesse;
    }
}