public class ReineDesFourmis extends Agent {
    private int vitesse; //le nombre d'enfant né quand il y a de nourriture
    private int larve;
    
    public ReineDesFourmis (int x, int y) {
        super(x, y);
        vitesse=(int)(Math.random()+1);
        larve=0;
    }
    
    public ReineDesFourmis (ReineDesFourmis rm) {
        super(rm.x, rm.y);
    }
    
    @Override
    public String recolte() {
        larve+=vitesse;
        return "La reine des fourmis a donner naissance à "+larve+" enfants.";
    }
    
    @Override
    public int getVitesse() {
        return vitesse;
    } 
}