public class Simulation{
  
  private Terrain t;
  private Agent[] tab_ag;
  private int m, n;         //m et n sont respectivement le nombre de ressource et d'agents
  
  
  public Simulation(Terrain t1, Agent[] tab_ag1, int nb_ressource, int nb_agent){
    t = t1;
    tab_ag = tab_ag1;
    
    m = nb_ressource;
    n = nb_agent;
    
    int i = 0;
    
    for(i=0; i<m; i++){
      int lig = (int)(Math.random()*t1.nbLignes);
      int col = (int)(Math.random()*t1.nbColonnes);
      
      if(i >= t1.nbLignes*t1.nbColonnes-1){       //Si on a placé plus de ressource qu'il n'y a de place on s'arrête
      //I want to
        break;
      //free
      }
      
      while((!t.caseEstVide(lig, col))){        //On s'assure qu'on ne place pas de ressource là où il  en a déjà
        lig = (int)(Math.random()*t1.nbLignes);
        col = (int)(Math.random()*t1.nbColonnes);
      }

      if(i%2 == 0){
        t.setCase(lig, col, new Ressource("Blé", (int)(Math.random()*5)));
      }
      else{
        t.setCase(lig, col, new Ressource("Métal", (int)(Math.random()*5)));
      }
    }
    
    for(i=0; i<n; i++){
      if(i%2 == 0){
        tab_ag[i] = new Metalo();
      }
      else{
        tab_ag[i] = new Agriculteur();
      }
    }
  }
  
  public void whereAgent(){
    int i = 0;
    for(i=0; i<n; i++){
      System.out.println("L'agent n° "+tab_ag[i].getId()+" est en ("+tab_ag[i].getX()+", "+tab_ag[i].getY()+")"+"("+tab_ag[i].getClasse()+")");
    }
  }
  public Terrain getTerrain(){
    return t;
  }
  
  public Agent[] getTabAgent(){
    return tab_ag;
  }
  
  public void lancerSimulation(Base b1){
    
    int v = 0;            //la simulation avance pas à pas, v est ma variable d'itération de boucles
    int nb_jour_famine = 0;   //nombre de jour ou Chatori-san n'a pas pu manger
    
    
  //Hey
  //It's been a
    while(b1.getPiece()<50){
  //How you doin ?  
      
      System.out.println("Nb de jour de famine : "+nb_jour_famine);
      t.affiche();
      whereAgent();
      for(int i = 0; i<n; i++){
        int x = tab_ag[i].getX();             //Cette variable n'existe que pour simplifier l'écriture du code
        int y = tab_ag[i].getY();             //Cette variable n'existe que pour simplifier l'écriture du code
        
        if(tab_ag[i].getNbRessource() >= 5){  //Les agents ne peuvent porter que 5 ressources en même temps
          tab_ag[i].allerVersBase();
        }
        else{
        
          if( t.getCase(x,y) != null){                  //Si un automate découvre qu'une case qui contenait auparavant des ressources
           if((t.getCase(x,y)).getQuantite() == 0){     //n'en contient plus, on la vide
               t.videCase(x,y);
            }
          }
          if(t.caseEstVide(x,y)){ 
            tab_ag[i].allerVersRessource(tab_ag[i].chercherRessource(t));
          }
          else if((  (tab_ag[i].getClasse() == "Metalo") && ( t.getCase(x,y).type == "Métal")) || (  (tab_ag[i].getClasse() == "Agriculteur") && ( t.getCase(x,y).type == "Blé"))){ //Les agents vont chercher les ressources correspondant à leur type
            tab_ag[i].recupererRessource(t.getCase(x,y));
          }
          else{
            tab_ag[i].allerVersRessource(tab_ag[i].chercherRessource(t));
          }
        }
        if(((x == 0) && (y == 0) && (tab_ag[i].getNbRessource() == 5))){  //Les agents déposent leurs ressource à la base pour que celle si soient transformée
          if(tab_ag[i].getClasse() == "Agriculteur"){
            b1.upPain();
            tab_ag[i].setNbRessource();
          }
          else if (tab_ag[i].getClasse() == "Metalo"){
            b1.upPiece();
            tab_ag[i].setNbRessource();
          }
        }
        System.out.println("L'agent n° "+tab_ag[i].getId()+" a "+tab_ag[i].getNbRessource()+" ressource");
      }
      System.out.println("Il y a "+b1.getPain()+" pains dans la base");
      System.out.println("Il y a "+b1.getPiece()+" pieces dans la base");
      
      try{
        Thread.sleep(1);
      }
      catch(InterruptedException a){
      }
      v++;
      System.out.println("Nombre d'itération de la boucle "+v);
      if (v%240 == 0){ //Une journee est composee de 240 itération de boucles
        if(b1.getPain() <= 1){    //Si Chatori-san ne mange pas au moins 2 pains lors d'une journée au considère cette journée comme "famine"
          if(b1.getPain() == 1){
            b1.downPain();
          }
          nb_jour_famine++; 
         }
         if(b1.getPain() >= 2){
           b1.downPain(); b1.downPain();
           nb_jour_famine = 0;
         }
         
        for(int i=0; i<20; i++){                                        //Chaque jour au plus 20 nouvelles ressources apparaisnt sur le terrain
          int lig = (int)(Math.random()*t.nbLignes);
          int col = (int)(Math.random()*t.nbColonnes);
      
      
          if((!t.caseEstVide(lig, col))){
            continue;
          }

          if(i%2 == 0){
            t.setCase(lig, col, new Ressource("Blé", (int)(Math.random()*5)));
          } 
          else{
            t.setCase(lig, col, new Ressource("Métal", (int)(Math.random()*5)));
          }
        }      
      }
      if(nb_jour_famine >= 5){
        System.out.println("\n\nChatori-San est mort de faim\nL'empereur Macaron mis son plan a Execution\nLa République-Unie fut envahie\nPuis le reste du monde qui a été renommé \"Macarontopia \"\n\n");
        
      //You look tired
      //You should take a
        break;
      }
    }
    if(b1.getPiece() >= 50){
      System.out.println("\n\nChatori-san a réparé son avion et a réussi à avertir le monde des plan maléfique de Macaron\nL'empereur a été déstitué et emprisoné\nEt est désormais appelé \"Macaron périmé\" en guise d'humiliation\n\n");
    }
  }
  
  public void narration(){
    /*Cette méthode pose le contexte dans lequel on se trouve*/
    System.out.println("Nous sommes en 2099\n");
    try{
      Thread.sleep(2500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Suite à la révolution de 2022 faisant suite au Brexit, le Royaume-uni est devenu la Répuplique-unie\n");
    try{
      Thread.sleep(5000);
    }
    catch(InterruptedException a){
    }
    System.out.println("Super-Chatori est un espion cyborg travaillant pour le LIP6,");
    try{
      Thread.sleep(1900);
    }
    catch(InterruptedException a){
    }
    System.out.println("Le service de renseignement britannique né des cendres du MI6, dissolu après la révolution\n");
    try{
      Thread.sleep(7000);
    }
    catch(InterruptedException a){
    }
    System.out.println("Lors d'une de ses missions Chatori-san dû infiltrer le gouvernement de l'empire de France");
    try{
      Thread.sleep(4000);
    }
    catch(InterruptedException a){
    }
    System.out.println("Sur lequel règne un terrible empereur");
    try{
      Thread.sleep(3000);
    }
    catch(InterruptedException a){
    }
    System.out.println("Manuel Macaron\n");
    try{
      Thread.sleep(4500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Durant cette mission, Chatori-san découvrit que l'empire était en train de lever une armée de Droïde");
    try{
      Thread.sleep(5500);
    }
    catch(InterruptedException a){
    }
    System.out.println("L'empereur Macaron prévoyait d'envahir la Répuplique-unie\n");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Chatori-san tenta alors de s'enfuir vers Londres avec des preuves pouvant compromettre le plan de Macaron");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Mais lors de sa fuite son avion s'écrasa en plein désert\n");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Chatori-san survécu\n");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Il réussit à fabriquer des automates à partir de la carcasse de son avion");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Ces automates ont pour but d'explorer le terrain sur lequel Chatori-san s'est écrasé");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Et d'en récupérer les ressources telles que le blé et le métal\n");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Permettant à Chatori-San de se nourrir et de réparer son avion pour regagner Londres\n");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("Et empêcher ce qui pourrait bien être\n");
    try{
      Thread.sleep(3500);
    }
    catch(InterruptedException a){
    }
    System.out.println("La 5e guerre mondiale");
    try{
      Thread.sleep(5000);
    }
    catch(InterruptedException a){
    }
  }
}
