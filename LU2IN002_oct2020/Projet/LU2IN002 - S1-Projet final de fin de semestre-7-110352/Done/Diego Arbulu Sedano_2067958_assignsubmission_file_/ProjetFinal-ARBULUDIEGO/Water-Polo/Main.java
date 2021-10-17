public class Main{
  public static void main(String args[]){

  Ailier a1 = new Ailier("Alex1", 8);
  Milieu m1 = new Attaquant("Marc1",9);
  Milieu m2 = new Pointe("Max1");
  Milieu m3 = new Attaquant("Mathieu1",8);
  Ailier a2 = new Ailier(a1);
  Gardien g1 = new Gardien("Guillaume1",5);

  Joueur [] l1={a1,m1,m2,m3,a2,g1}; // rangés dans l'ordre de leur disposition sur le terrain : ailier-3 milieux-ailier et le gardien
  Equipe e1 = new Equipe("Jacobins",l1);

  Ailier b1 = new Ailier("Axel2", 2);
  Milieu n1 = new Attaquant("Marco2",6);
  Milieu n2 = new Pointe("Maxime2");
  Milieu n3 = new Attaquant("Math2",7);
  Ailier b2 = new Ailier(b1);
  Gardien h1 = new Gardien("Guillaume2",2);

  Joueur [] l2={b1,n1,n2,n3,b2,h1};
  Equipe e2 = new Equipe("Saint-Jean",l2);

  Ailier c1 = new Ailier("Alexis3", 5);
  Milieu o1 = new Attaquant("Martin3",6);
  Milieu o2 = new Pointe("Maximilien3");
  Milieu o3 = new Attaquant("Mathew3",9);
  Ailier c2 = new Ailier(c1);
  Gardien i1 = new Gardien("Guillaume3",3);

  Joueur [] l3={c1,o1,o2,o3,c2,i1};
  Equipe e3 = new Equipe("Saran",l3);

  Ailier d1 = new Ailier("Alexandre4", 3);
  Milieu p1 = new Attaquant("Marcus4",4);
  Milieu p2 = new Pointe("Maximus4");
  Milieu p3 = new Attaquant("Matheus4",6);
  Ailier d2 = new Ailier(c1);
  Gardien j1 = new Gardien("Guillaume4",2);

  Joueur [] l4={d1,p1,p2,p3,d2,j1};
  Equipe e4 = new Equipe("Laval",l4);

  Match match1 = new Match(e1,e2);
  Match match2 = new Match(e3,e4);
  Tournoi.deroule(match1,match2);


  }


}
