/**
 * @author Loona Macabre Groupe 7
 */
/** 
 * Les heros sont les agents de cette simulation.
 * Chaque heros a une jauge de vie maximale
 * de 10 coeurs. Il peut obtenir des coeurs apres
 * avoir battu un ennemi. Si jamais la jauge de vie 
 * se retrouve vide, le heros est elimine. */
public abstract class Heros {
    protected final int jaugeVieMax = 10;

    protected int jaugeVie;
    protected String nom;
    protected int x;
    protected int y;


    /**
     * Position a (0,0)
     * @param nom
     */
    protected Heros(String nom){
        this.nom = nom;
        x = 0;
        y = 0;
        jaugeVie = jaugeVieMax;
    }

    /**
     * Position initialisee par l'utilisateur
     * @param nom
     * @param x
     * @param y
     */
    protected Heros(String nom, int x, int y) {
        this(nom);
        this.x = x;
        this.y = y;
        jaugeVie = jaugeVieMax;
    }

    /**
     * Constructeur de copie
     */
    protected Heros(Heros h){
        nom = h.nom;
        x = h.x;
        y = h.y;
        jaugeVie = h.jaugeVie;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return la distance (euclidienne) entre la case courante et celle de coordonnees (x,y)
     */
    public double distance(int x,int y){
        return Math.sqrt((x - this.x)*(x - this.x) + (y - this.y)*(y - this.y));
    }

    /**
     * place le heros aux coordonnees (xnew,ynew)
     * @param xnew
     * @param ynew
     */
    public void seDeplacer(int xnew,int ynew){
        x = xnew;
        y = ynew;
    }

    /**
     * accesseur au nom du heros
     * @return le nom du heros
     */
    public String getNom(){
        return nom;
    }

    /**
     * accesseur a x
     * @return la ligne sur laquelle est le heros
     */
    public int getX(){
        return x;
    }

    /**
     * accesseur a y
     * @return la colonne sur laquelle est le heros
     */
    public int getY(){
        return y;
    }

    /**
     * accesseur a la jauge de vie du heros
     * @return la jauge de vie
     */
    public int getJaugeVie(){
        if (jaugeVie < 0){
            jaugeVie = 0;
        }
        return jaugeVie;
    }

    /**
     * calcule la probabilite de reussir son attaque du premier coup
     * @param ennemi
     * @return la probabilite
     */
    public double determinerProbaAttaqueReussie(Ressource ennemi){
        double probaAttaqueReussie;
        int qteEnnemis = ennemi.getQuantite();
        if (qteEnnemis < 2){
            probaAttaqueReussie = 0.80;
        }
        else {
            if (qteEnnemis < 4){
                probaAttaqueReussie = 0.70;
            }
            else {
                probaAttaqueReussie = 0.60;
            }
        }
        return probaAttaqueReussie;
    }

    /**
     * 
     * @param ennemi
     * @return true si il reussit son attaque du premier coup, false sinon
     */
    public boolean attaqueReussie(Ressource ennemi){
        double proba = determinerProbaAttaqueReussie(ennemi);
        double alea = (Math.random()*100 + 1)/(double)100;
        if (alea < proba){
            return true;
        }
        return false;
    }

    /**
     * dans le cas ou l'attaque n'est pas reussie du premier coup, le heros est blesse par l'ennemi
     * @param ennemi
     */
    public void attaqueRatee(Ressource ennemi){
        int qteEnnemis = ennemi.getQuantite();
        if (qteEnnemis < 2){
            jaugeVie -= 1;
        }
        else {
            if (qteEnnemis < 4){
                jaugeVie -= 3;
            }
            else {
                jaugeVie -= 5;
            }
        }
    }

    /**
     * 
     * @return la jauge magique (pour la classe Mage)
     */
    public int getJaugeMag(){return 0;}

    /**
     * (pour Mage)
     * @param qteEnnemis
     */
    public void degatsMag(int qteEnnemis){}

    public abstract void recompense(Ressource ennemi);

    public abstract String toString();
}