public class Simulation{
  //une licorne peut recolter toute la quantite d'etoile
  //une etoile permet de fabriquer une baguette magique
  //une case peut contenir une etoile de quantite maximale de 5
  /*une licorne qui ne trouve pas d'etoiles a sa premiere expedition
    va faire une deuxieme expedition. Cependant si elle n'en trouve toujours pas
    elle rentrera alors a l'Academie des mages */
  /*une etoile peut se renouveller a chque recolte : si une licorne a recolte
    une etoile alors elle peut se renouveller a la prochaine recolte elle aura
    donc une quantite egale a 1*/
  /*si une etoile n'a pas ete recolte alors sa quantite augmente de 1*/

  private Terrain T;
  private Licorne [] troupe;
  private Ressource [] res;
  private AcademieDesMages AcademieDesMages;

  public Simulation(Terrain t, AcademieDesMages a, int m, int n){
    T=t;
    AcademieDesMages=a;
    res=new Ressource [m];
    troupe=new Licorne [n];
    int i;
    int x;
    int y;
    for (i=0;i<m;i++){
      //creation d'une ressource.
      res[i]=new Ressource("etoile",(int)(Math.random()*5+1));
      //position aleatoire de la ressource cree.
      x=(int)(Math.random()*(T.nbLignes+1));
      y=(int)(Math.random()*(T.nbColonnes+1));
      //il ne peut pas avoir d'etoiles dans la case ou se situe l'Academie des mages
      while(x==AcademieDesMages.getPositionX() && y==AcademieDesMages.getPositionY()){
        x=(int)(Math.random()*(T.nbLignes+1));
        y=(int)(Math.random()*(T.nbColonnes+1));
      }
      /*si la case n'est pas vide l'etoile cree vole
        la quantite de la premiere etoile*/
      if (T.caseEstVide(x,y)==false){
        res[i].setQuantite(T.getCase(x,y).getQuantite()+res[i].getQuantite());
        T.getCase(x,y).setQuantite(0);
        if (res[i].getQuantite()>5){
          res[i].setQuantite(5);
        }
      }
      //ajout de la ressource sur le terrain.
      T.setCase(x,y,res[i]);
    }
    //creation de la premiere licorne a academie des mages
    troupe[0]=new Licorne(AcademieDesMages.getPositionX(),AcademieDesMages.getPositionY());
    for (i=1;i<n;i++){
      //creation d'une Licorne a l'aide du constructeur par copie
      troupe[i]=new Licorne(troupe[0]);
    }
  }

  /*methode qui ajoute une quantite a chque etoile non recolte sinon
    si l'etoile a ete recolte sa quantite passe a 1 si Repousse est egale a 1*/
  public void majRes(){
    int Repousse=-1;
    for (int i=0;i<res.length;i++){
      Repousse=(int)(Math.random()*2);
      if (res[i].getQuantite()==0){
        if (Repousse==1){
          res[i].setQuantite(1);
        }
      }
      else{
        res[i].setQuantite(res[i].getQuantite()+1);
        if (res[i].getQuantite()>5){
          res[i].setQuantite(5);
        }
      }
    }
  }
  /*methode qui fait recolter la licorne a la position (x,y)
    une etoile s'il y en a*/
  public void recolteLicorne(Licorne l){
    int x=l.getNumeroLigne();
    int y=l.getNumeroColonne();
    //la case ou se trouve la licorne
    Ressource etoile = T.getCase(x,y);

    if (T.caseEstVide(x,y)!= true){
      //une licorne recolte toute la quantite de l'etoile present dans la case
      l.setPossedeEtoile(etoile.getQuantite());
      etoile.setQuantite(0);
    }
  }

  public void recolte(){
    int x=0;
    int y=0;

    for(Licorne l:troupe){
      //la licorne l se deplace dans une case aleatoire
      x=(int)(Math.random()*(T.nbLignes+1));
      y=(int)(Math.random()*(T.nbColonnes+1));
      l.seDeplacer(x,y);
      //si il n'y a pas d'etoile la licorne se deplace a nouveau
      if (T.caseEstVide(x,y)){
        x=(int)(Math.random()*(T.nbLignes+1));
        y=(int)(Math.random()*(T.nbColonnes+1));
        l.seDeplacer(x,y);
      }
      //la licorne fait sa recolte s'il y en a
      recolteLicorne(l);
      //toutes les licornes rentre a l'academie
      l.seDeplacer(AcademieDesMages.getPositionX(),AcademieDesMages.getPositionY());
      //si la licorne possede des etoiles elle les transforme en baguettes
      if (l.getPossedeEtoile()!=0){
        AcademieDesMages.setNbBaguette(AcademieDesMages.getNbBaguette()+l.getPossedeEtoile());
        l.setPossedeEtoile(0);
      }
    }
    majRes();
  }

  public void affiche(int nbRecolte){
    //nombre d'etoile recolte au jour i-1
    int nbEtoileRecolte=0;
    for (int i=1;i<=nbRecolte;i++){
      recolte();
      //on place la ressource baguette a l'academie des mages s'il y en a
      if (AcademieDesMages.getNbBaguette()!=0){
        T.setCase(AcademieDesMages.getPositionX(),AcademieDesMages.getPositionY(),
        AcademieDesMages.getBaguette());
      }
      //Information sur Nulexia(=nom du terrain)
      System.out.println("Informations sur Nulexia:\n"+T);
      //Information sur les etoiles recoltes a chaque recolte
      System.out.println("La recolte "+i+", les licornes ont recolte "+
      (AcademieDesMages.getNbBaguette()-nbEtoileRecolte)+" etoiles.\n");
      nbEtoileRecolte=AcademieDesMages.getNbBaguette();
      //Information sur combien de baguettes fabriquees au total
      System.out.println("Au total, "+AcademieDesMages.getNbBaguette()+
      " baguettes magiques ont ete cree.\n");
      /*a la derniere recolte les etoiles ne doivent ayant une quantote egale a
      0 ne doivent plus etre afficher*/
      if (i==nbRecolte){
        //parcours chque case du Terrain
        for (int a=0;a<T.nbLignes;a++){
          for (int b=0;b<T.nbColonnes;b++){
            if (T.caseEstVide(a,b)==false){
              if (T.getCase(a,b).getQuantite()==0){
                //vide la case car il n'y a plus d'etoile
                T.videCase(a,b);
                System.out.println("Il n'y a plus d'etoiles dans la case ("+
                a+","+b+").\n");
              }
            }
          }
        }
        System.out.println("Informations sur Nulexia:\n"+T);
      }
      T.affiche();
    }
  }
}
