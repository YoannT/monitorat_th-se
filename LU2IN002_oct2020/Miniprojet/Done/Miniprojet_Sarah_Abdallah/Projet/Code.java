public class Code{
    int x;
    int y;
    int nb_mots;
    public Code(int x, int y){
        this.x = x;
        this.y = y;
        nb_mots = 0;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getNb_mots(){
        return nb_mots;
    }
    public void ajouter_mot(){
        nb_mots++;
    }
    public boolean codeTrouve(int nb_mots_du_code){
        return nb_mots >= nb_mots_du_code;
    }
}