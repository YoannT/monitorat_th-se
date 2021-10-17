public class Match{
  public static int nbFautes;
  public static int nbActions;
  public Equipe equ1;
  public Equipe equ2;
  public int t;

  public Match(Equipe e1, Equipe e2){
    nbFautes=0;
    nbActions=8;
    this.equ1=e1;
    this.equ2=e2;
  }

  public static int miseEnJeu(Equipe e1, Equipe e2){
    if(((Ailier)(e1.composition[0])).vitesse > ((Ailier)(e2.composition[0])).vitesse){
      System.out.println("L'équipe "+e1.nom+" a récupéré la balle, elle se positionne devant la cage adverse\n");
      return 1;
    }
    else{
      System.out.println("L'équipe "+e2.nom+" a récupéré la balle, elle se positionne devant la cage adverse\n");
      return 2;
    }
  }

    public static void miTempsA(Equipe e1, Equipe e2, int i, int nbActions){ //A car l'équipe 1 a la balle
      if(nbActions==0){ //condition d'arret de jeu
        System.out.println("Coup de sifflet! Fin de la mi-temps.\nLes joueurs se reposent.\n");
      }
      else{
        String name=(e1.composition[i]).nom; //racourci pour le nom du joueur à la pointe
        System.out.println(name+" a la balle\n");
        int r=((int)(Math.random()*((3-0)+1))); //valeur aléatoire qui décide du jeu
        switch(r){
          case (0):
            if(((e1.composition[i]).tir())&&((e2.composition[i]).intercepter())&&(((Gardien)e2.composition[5]).parer())){ //le succès du tir dépend du lanceur, de son défenseur et du gardien adverse
              System.out.println(name+" tire et marque !"+e1.nom+" gagne un point.\n");
              Score.increment1(); //score de l'équipe 1

              miTempsB(e2,e1,2,(nbActions-1)); //point marqué, l'équipe adverse récupère la balle, une action s'est écoulée
            }
            else{
              System.out.println(name+" tire et rate !\n");
              miTempsA(e1,e2,(r+2),(nbActions-1)); //l'équipe garde la main, mais un autre joueur hérite de la balle, une action s'est écoulée
            }
            break;

          case(1):
            if((i>0)&&((e1.composition[i]).passe(e1.composition[i-1]))&&(e2.composition[i].intercepter())){ //le succès d'une passe vers les bas dépend de l'existance d'un coéquipier à la bonne position, du lanceur et du défenseur
              System.out.println(name+" a fait une passe à "+e1.composition[i-1].nom+"\n");
              miTempsA(e1,e2,i-1,(nbActions-1)); //l'équipe garde la balle mais c'est la cible de la passe qui l'a, une action s'est écoulée
            }
          else{
            System.out.println(name+" tente de faire une passe mais échoue. \n");
            miTempsA(e1,e2,(r+1),(nbActions-1)); //l'équipe garde la balle mais c'est un autre joueur qui la récupère
            }
            break;

          case(2):
            if((i<4)&&((e1.composition[i]).passe(e1.composition[i+1]))&&((e2.composition[i]).intercepter())){//passe vers le haut, existance coéquipier, lanceur, défenseur
              System.out.println(name+" a fait une passe à "+e1.composition[i+1].nom+"\n");
              miTempsA(e1,e2,i+1,(nbActions-1)); //meme équipe, cible de la passe, action écoulée
            }
            else{
              System.out.println(name+" tente de faire une passe mais échoue. \n");
              miTempsA(e1,e2,(r-1),(nbActions-1)); //meme équipe, autre joueur, action écoulée
            }
            break;

          case(3):
            if(((e1.composition[i]).faute())&&(e2.composition[i].intercepter())&&((Arbitre.getA()).juge())){ //la faute dépend du Joueur, de son défenseur et de l'arbitre
              System.out.println("SIFFLET! L'arbitre a signalé une faute. Balle au camp adverse. \n");
              nbFautes++; //[le nombre de fautes devait déclencher une exception s'il devenait suffisamment important mais je ne l'ai pas implémenté]
              miTempsB(e2,e1,2,(nbActions-1)); //faute avérée, l'équipe adverse récupère la balle, action écoulée
            }
          else{
            System.out.println("L'arbitre dit Jeu ! \n"); //la faute est reconnue comme non avenue
            miTempsA(e1,e2,2,(nbActions-1)); //meme équipe, la pointe récupère la balle comme en remise en jeu, action écoulée
          }
          break;
        }
      }
    }

    public static void miTempsB(Equipe e1, Equipe e2, int i, int nbActions){
      if(nbActions==0){
        System.out.println("Coup de sifflet! Fin de la mi-temps.\nLes joueurs se reposent.\n");
      }
      else{
        String name=(e1.composition[i]).nom;
        System.out.println(name+" a la balle\n");
        int r=(int)(Math.random()*((3-0)+1));
        switch(r){
          case (0):
            if(((e1.composition[i]).tir())&&((e2.composition[i]).intercepter())&&(((Gardien)e2.composition[5]).parer())){
              System.out.println(name+" tire et marque !"+e1.nom+" gagne un point.\n");
              Score.increment2();

              miTempsA(e2,e1,2,(nbActions-1));
            }
            else{
              System.out.println(name+" tire et rate !\n");
              miTempsB(e1,e2,(r+2),(nbActions-1));
            }
            break;

          case(1):
            if((i>0)&&((e1.composition[i]).passe(e1.composition[i-1]))&&(e2.composition[i].intercepter())){
              System.out.println(name+" a fait une passe à "+e1.composition[i-1].nom+"\n");
              miTempsB(e1,e2,i-1,(nbActions-1));
            }
          else{
            System.out.println(name+" tente de faire une passe mais échoue. \n");
            miTempsB(e1,e2,(r+1),(nbActions-1));
            }
            break;

          case(2):
            if((i<4)&&((e1.composition[i]).passe(e1.composition[i+1]))&&((e2.composition[i]).intercepter())){
              System.out.println(name+" a fait une passe à "+e1.composition[i+1].nom+"\n");
              miTempsB(e1,e2,i+1,(nbActions-1));
            }
            else{
              System.out.println(name+" tente de faire une passe mais échoue. \n");
              miTempsB(e1,e2,(r-1),(nbActions-1));
            }
            break;

          case(3):
            if(((e1.composition[i]).faute())&&(e2.composition[i].intercepter())&&((Arbitre.getA()).juge())){
              System.out.println("SIFFLET! L'arbitre a signalé une faute. Balle au camp adverse. \n");
              nbFautes++;
              miTempsA(e2,e1,2,(nbActions-1));
            }
          else{
            System.out.println("L'arbitre dit Jeu ! \n");
            miTempsB(e1,e2,2,(nbActions-1));
          }
          break;
        }
    }

  }
}
