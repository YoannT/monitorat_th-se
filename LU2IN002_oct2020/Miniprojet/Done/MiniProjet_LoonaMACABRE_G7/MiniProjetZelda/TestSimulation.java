/**
 * @author Loona Macabre, Groupe 7
 */
public class TestSimulation {
    public static void main(String[]args){
        /*Simulation S1 = new Simulation();
        S1.deroulementBataille();
        S1.compteRenduBataille();*/

        //en utilisant le constructeur d'Epeistes par copie
        Heros zora1 = new Epeiste("zora",0,9);
        Heros zora2 = new Epeiste(zora1);
        Heros zora3 = new Epeiste(zora1);
        Heros zora4 = new Epeiste(zora1);
        Heros[] heros = {zora1,zora2,zora3,zora4};

        Ressource monstre1 = new Ressource("monstre",3);
        Ressource monstre2 = new Ressource("monstre",2);
        Ressource monstre3 = new Ressource("monstre",5);
        Ressource monstre4 = new Ressource("monstre",1);
        Ressource monstre5 = new Ressource("monstre",4);
        Ressource[] ennemis = {monstre1,monstre2,monstre3,monstre4,monstre5};

        Ressource kidA = new Ressource("enfant",1);
        Ressource kidB = new Ressource("enfant",1);
        Ressource kidC = new Ressource("enfant",1);
        Ressource[] kids = {kidA,kidB,kidC};
        Simulation S2 = new Simulation(heros, 5, 6);
        S2.deroulementBataille();
        S2.compteRenduBataille();
    }
}
