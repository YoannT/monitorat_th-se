public class Tournoi{
  public Match m1;
  public Match m2;
  public Match m3;

  public Tournoi(Match mat1, Match  mat2){
    this.m1=mat1;
    this.m2=mat2;
  }

  public static void deroule(Match M1, Match M2){
    Equipe e1=M1.equ1; Equipe e2=M1.equ2; //on récupère les deux équipes du prmier match
    int t1=Match.miseEnJeu(e1,e2); //la mise en jeu détermine quelle équipe entame les hostilités
    if(t1<2){Match.miTempsA(e1,e2,2,8);} //la première
    else{Match.miTempsB(e2,e1,2,8);} //ou la deuxième
    System.out.println("Les scores actuels sont "+e1.nom+" : "+Score.get1()+" à "+e2.nom+" : "+Score.get2()+".\n\n"); //scores non définitifs
    Match.nbActions=0; //remise du compteur d'action (de temps) à zéro
    e1.energie();e2.energie(); //reprise d'énergie lors de la pause
    if(t1<2){Match.miTempsA(e1,e2,2,8);}
    else{Match.miTempsB(e2,e1,2,8);}
    System.out.println("Les scores finaux sont "+e1.nom+" : "+Score.get1()+" à "+e2.nom+" : "+Score.get2()+".\n\n"); // fin du premier match

    Equipe f1; //équipe qualifiée pour la finale
    if(Score.get1()>=Score.get2()){
      f1=(M1.equ1);
    }
    else{
      f1=(M1.equ2);
    }
    Score.set1(0);Score.set2(0); //remise des compteurs de scores à zéro

    Equipe e3=M2.equ1; Equipe e4=M2.equ2;
    int t2=Match.miseEnJeu(e3,e4);
    if(t2<2){Match.miTempsA(e3,e4,2,8);}
    else{Match.miTempsB(e4,e3,2,8);}
    System.out.println("Les scores actuels sont "+e3.nom+" : "+Score.get1()+" à "+e4.nom+" : "+Score.get2()+".\n\n");
    Match.nbActions=0;
    e3.energie();e4.energie();
    if(t2<2){Match.miTempsA(e3,e4,2,8);}
    else{Match.miTempsB(e4,e3,2,8);}
    System.out.println("Les scores finaux sont "+e3.nom+" : "+Score.get1()+" à "+e4.nom+" : "+Score.get2()+".\n\n"); // fin du deuxième match

    Equipe f2;
    if(Score.get1()>=Score.get2()){
      f2=(M2.equ1);
    }
    else{
      f2=(M2.equ2);
    }
    Score.set1(0);Score.set2(0);
    f1.energie();f2.energie();
    f1.energie();f2.energie(); // les joueurs récupèrent de l'énergie

    int t3=Match.miseEnJeu(f1,f2);
    if(t3<2){Match.miTempsA(f1,f2,2,8);}
    else{Match.miTempsB(f2,f1,2,8);}
    System.out.println("Les scores actuels sont "+f1.nom+" : "+Score.get1()+" à "+f2.nom+" : "+Score.get2()+".\n\n");
    Match.nbActions=0;
    if(t3<2){Match.miTempsA(f1,f2,2,8);}
    else{Match.miTempsB(f2,f1,2,8);}
    System.out.println("Les scores finaux sont "+f1.nom+" : "+Score.get1()+" à "+f2.nom+" : "+Score.get2()+".\n\n"); // fin du dernier match

    Equipe s;
    if(Score.get1()>=Score.get2()){
      s=f1;
    }
    else{
      s=f2;
    }

    System.out.println("Le vainqueur du tournoi est l'équipe "+s.nom+"! Félicitations !\n");
  }
}
