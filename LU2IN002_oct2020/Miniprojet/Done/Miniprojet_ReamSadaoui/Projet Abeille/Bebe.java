public class Bebe {
    protected String nom;
    Ressource miel;

    //Constructeur
    public Bebe(String nom) {
        this.nom = nom;
    }

    //Les bebes ne recoltent pas le miel
    public boolean recoltePasMiel() {
        return true;
    }
}
