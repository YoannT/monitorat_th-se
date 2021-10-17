public class Abeilles extends Bebe implements Cloneable {
    private Ressource ressource;
    protected String agent = "abeille";
    private int x,y;

    //Constructeur
    public Abeilles (String nom){
        super(nom);
    }

    //Clonage d'abeille
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    //Getters
    public int getX() { return x;}
    public int getY() { return  y;}

    int i = 0;
    public String toString() {
        i++;
        return "Abeille " + i + ". En position" + ", x = " + x + ", y = " + y  ;
    }

    //Renvoie la distance entre 2 points
    public double distance (int x, int y){
        double distance = Math.sqrt((x-this.x * x - this.x) + (y - this.y * y - this.y));
        return Math.round(distance);
    }

    //Fais deplacer l'abeille
    public void seDeplacer(int xnew, int ynew){
        this.x = xnew;
        this.y = ynew;
    }

    //Recolte le miel
    public boolean recoltePasMiel() {
            return !(super.recoltePasMiel());
        }
    }


