import java.util.ArrayList;

public class Simulation {
    //Les composant de simulation
    private Terrain terrain;
    private ArrayList<Agent> agent;
    private ArrayList<Ressource> ressource;
    private Fourmiliere f;
     
    public Simulation (int m, int n, int x, int y) {
        //Initialisation de terrain
        terrain=new Terrain(x, y);
        
        //Initialisation du tableau de agent
        agent=new ArrayList<Agent>();
        for (int i=0; i<n-1; i++) { //Ajout des fourmis dans le tableau
            agent.add(new Fourmis(((int)(Math.random()*x)), ((int)(Math.random()*y))));
        }
        agent.add(new ReineDesFourmis(0, 0)); //Ajout de la reine des fourmis
        
        //Initialisation du tableau de ressource
        ressource=new ArrayList<Ressource>();
        for (int i=0; i<m; i++) { //Ajout des ressource dans la liste et le terrain
            Ressource r=new Ressource("Nourriture", ((int)(Math.random()*2+1)));
            r.setPosition((int)(Math.random()*x), (int)(Math.random()*y));
            ressource.add(r);
            terrain.setCase(r.getX(), r.getY(), r);
        }
        
        //Inicialisation de fourmiliere
        f=new Fourmiliere(0, 0);
    }
    
    public void afficheTerrain() { //Affichage de terrain avec des ressources
        terrain.affiche();
        System.out.println ("Informations sur le terrain:\n"+terrain);
    }
    
    public void valideRessource() { //Verification
        for (Ressource ress: ressource) {
            int rx=ress.getX(); 
            int ry=ress.getY();
            
            if (!terrain.sontValides(rx, ry))
                System.out.println("Incorrect: problème de coordonnées ("+rx+", "+ry+")!");   
        }
    }
    
    public void recolteRessource() {
        System.out.println(f.position());
        
        for (Ressource ress: ressource) { //Pour chaque nourriture
            int rx=ress.getX(); 
            int ry=ress.getY();
            
            int p=0; //Creer une variable p: le plus proche avec le nourriture
            
            //Boucle pour tous les fourmis sauf la reine qui doit rester chez eux
            for (int i=0; i<(agent.size())-1; i++) {
                while (agent.get(i).getTemps()>10) { //Repos
                    System.out.println(agent.get(i)+". Il travaille trop, il va rentre pour reposer.");
                    agent.remove(i);
                }
                
                //Pour trouver le fourmis le plus proche
                if (agent!=null) {
                    if (agent.get(p).distance(rx, ry)>agent.get(i).distance(rx, ry))
                        p=i;
                    System.out.println(agent.get(p)+" est le plus proche que "+ress+".");
                    double d=agent.get(p).distance(rx, ry); //Calcul de distance avec ress
                    double temps1=d/agent.get(p).getVitesse(); //Calcul de temps pour arriver
                    agent.get(p).seDeplacer(rx, ry); //Deplacer vers les ress
                    System.out.println("Il prend "+temps1+"min pour arriver.");
            
                    agent.get(p).setTemps(temps1); //Calcul du temps travalle
            
                    terrain.videCase(rx,ry); //recuperer des ress donc vider la case
                    System.out.println(agent.get(p).recolte());
            
                    System.out.println("Il decide de le ramener dans le fourmiliere.");
                    d=agent.get(p).distance(f.getX(), f.getY()); //Calcul de distance avec f
                    double temps2=d/agent.get(p).getVitesse(); //Calcul de temps pour rentrer
                    agent.get(p).seDeplacer(f.getX(), f.getY()); //Deplacer vers f
                    System.out.println("Il prend "+temps2+"min pour rentrer.");
            
                    agent.get(p).setTemps(temps2); //Calcul de temps total de travailler 
            
                    f.ajoutNourr(ress.getQuantite()); //Ajout de nourriture chez les fourmis
                    System.out.println("Grace au nourriture, "+agent.get(agent.size()-1).recolte());
                    System.out.println("================================================");
                    System.out.println("================================================");
                }
            }
        }
    }
    
    
    public void statistique () {
        System.out.println(f.toString()); //Le nb total de ress recupere
        System.out.println(agent.get(agent.size()-1).recolte()); //Le nb total de larve ne
    }
}











