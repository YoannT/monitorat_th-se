import java.util.ArrayList;

public class TestSimulation {

    public static void main(String[] args) {

        Ruche ruche = new Ruche();
        Simulation simulation = new Simulation();

        Simulation.afficherStats();

        System.out.println("\nAffichage du terrain initial SANS ruche :");
        simulation.terrain.affiche();

        //Production d'un miel
        simulation.productionMiel();

        System.out.println("Affichage du terrain après production d'un miel et d'une ruche : ");
        simulation.terrain.affiche();

        Simulation.afficherStats();

        System.out.println("\nRecolte d'un miel par les abeilles et check que la ruche est bien vide : ");
        simulation.recolter();
        System.out.println("La ruche est-elle vide? " + ruche.estVide());

        System.out.println("\nAffichage du terrain après recolte d'un miel : ");
        simulation.terrain.affiche();

        Simulation.afficherStats();

        ruche.remplir();
        System.out.println("\nLa ruche est-elle vide? " + ruche.estVide());

        System.out.println("\nLes frelons mangent la recolte !");
        simulation.frelons.mangerRecolte(ruche);

        System.out.println("La ruche est-elle toujours remplie ? " + ruche.estVide() + " :(");

        System.out.println("\nRecuperation des 5 miels : ");
            for (int i = 1; i < simulation.terrain.nbColonnes; i++) {
                simulation.recolter();
            }

            simulation.terrain.affiche();
        Simulation.afficherStats();

        System.out.println("\nOH NOOOOON !! UNE ATTAQUE DE FRELONS SUR TOUTES LA RUCHE ");
        simulation.attaqueDeFrelons();

        System.out.println("\nAffichage du terrain après l'attaque des frelons sur la ruche :(");
        simulation.terrain.affiche();

        System.out.println("\nBONUS : IL RESTE UN MIEL CAR C'EST UN MIEL DE LAVANDE ET PAS DE MILLEFLEUR !!!!!");

    }

    }

