
public class Frelons  extends Bebe {
    private Abeilles abeilles;
    private Ruche ruche;
    Terrain terrain;

    public Frelons(String nom) {
        super(nom);
    }

    //Les frelons ne recoltent pas le miel
    public boolean recolterMiel() {
        return super.recoltePasMiel();
    }

    //Les frelons mangent toute la recolte
    public void mangerRecolte (Ruche ruche) {
        if (ruche.estVide() == false) {
            ruche.estVide();
            System.out.println("R.I.P les recoltes");
        } else
            System.out.println("Il n'y pas de recolte à la base ...");
    }
}
