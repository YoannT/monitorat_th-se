public abstract class Agent {
    protected int x;
    protected int y;
    protected double t_travaille;
    protected static int cpt=0;
    protected final int id;
    
    public Agent(int x, int y) {
        cpt++;
        id=cpt;
        t_travaille=0.0;
        this.x=x;
        this.y=y;
    }
    
    public String toString() {
        return "L'agent "+id+" est en position ("+x+", "+y+")";
    }
    
    public double distance(int x, int y) { //la distance entre agent et (x,y)
        return (Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y)));
    }
    
    public void seDeplacer(int xnew, int ynew) { //Agent deplacer vers(xnew, ynew)
        this.x=xnew;
        this.y=xnew;
    }
    
    public void setTemps(double t) { //temps travaille de l'agent
        t_travaille+=t;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public double getTemps() {
        return t_travaille;
    }
    
    public abstract String recolte(); 
    public abstract int getVitesse(); 
}