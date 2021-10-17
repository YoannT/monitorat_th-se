public class Fourmiliere {
    private int x, y, nourr;
    
    public Fourmiliere(int x, int y){
        this.x=x;
        this.y=y;
        nourr=0; //0 nourriture au debut
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public String position() {
        return "La position de la fourmiliere et la reine est ("+x+", "+y+").";
    }
    
    public void ajoutNourr(int n) {
        nourr+=n;
    }
    
    public int getNourr() {
        return nourr;
    }
    
    public String toString() {
        return "Dans le fourmiliere, le quantite de nourriture recupere est "+nourr;
    }
}