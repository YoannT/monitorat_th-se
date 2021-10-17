import java.util.ArrayList;
/**
* Cette classe teste toutes les classes du programme et simule la gestion du club sportif
*@author Louise Le Reun
*/
public class TestGestion{
	public static void main(String[] args) {
		Explications.afficher();

		System.out.println("     ====== Debut de la simulation ======     ");
		System.out.println("");

		try{
			Personne a1= new Personne(25,"Paul");
			Personne a2= new Personne(43,"Vivianne");
			Personne a3= new Personne(39,"Lola");
			Personne e1= new Personne(13,"Marcel");
			Personne e2= new Personne(15,"Angelo");

			System.out.println("---------- affichages des ages et tarifs des personnes creees ----------");
			System.out.println("age de Paul :"+a1.getAge());
			System.out.println("tarif Annuel de Paul :"+a1.tarifAnnuel(a1.getAge()));
			System.out.println("");
			System.out.println("age de Marcel :"+e1.getAge());
			System.out.println("tarif Annuel de Marcel :"+e1.tarifAnnuel(e1.getAge()));
			System.out.println("");
			System.out.println("age de Lola :"+a3.getAge());
			System.out.println("tarif Annuel de Lola :"+a3.tarifAnnuel(a3.getAge()));
			System.out.println("");
			System.out.println("age de Vivianne :"+a2.getAge());
			System.out.println("tarif Annuel de Vivianne :"+a2.tarifAnnuel(a2.getAge()));
			System.out.println("");
			System.out.println("age d'Angelo :"+e2.getAge());
			System.out.println("tarif Annuel d'Angelo :"+e2.tarifAnnuel(e2.getAge()));
			System.out.println("");
			
			//creation de la liste d'adherents
			ArrayList<Personne> adherents= new ArrayList<Personne>();
			adherents.add(a1);
			adherents.add(a2);
			adherents.add(a3);
			adherents.add(e1);
			adherents.add(e2);

			Gestion gestion= Gestion.getInstance(adherents);

			//verification du singleton
			ArrayList<Personne> testSingleton= new ArrayList<Personne>();
			Personne pers= new Personne(a1);
			testSingleton.add(pers);
			Gestion gestion2= Gestion.getInstance(testSingleton);

			System.out.println("---------- Verification du singleton ----------");
			System.out.println("");
			System.out.println("Premier singleton cree :");
			System.out.println(gestion.adherents);
			System.out.println("Deuxieme singleton cree :");
			System.out.println(gestion2.adherents);
			System.out.println("Les deux affichages sont similaires, youhou !");
			System.out.println("");

			System.out.println("---------- affichages de la liste d'adherents et du chiffre d'affaire du club ----------");
			System.out.println("");
			System.out.println("Liste d'adherents avant desabonnement :");
			gestion.afficheAdherent();
			System.out.println("");
			System.out.println("Chiffre d'affaire de l'annee avant desabonnement :"+gestion.chiffreAffaire(adherents)+" euros");
			System.out.println("");
			gestion.desabonnement(a1);
			System.out.println("Liste d'adherents apres desabonnement :");
			gestion.afficheAdherent();
			System.out.println("");
			System.out.println("Chiffre d'affaire de l'annee apres desabonnement :"+gestion.chiffreAffaire(adherents)+" euros");
			System.out.println("");

			//creation de l'emploi du temps
			//ligne des jours
			gestion.setCase(0,0," - ");
			gestion.setCase(0,1,"lundi   ");
			gestion.setCase(0,2,"mardi   ");
			gestion.setCase(0,3,"mercredi");
			gestion.setCase(0,4,"jeudi   ");
			gestion.setCase(0,5,"vendredi");
			gestion.setCase(0,6,"samedi");

			//colonne des heures
			gestion.setCase(1,0,"10h-12h");
			gestion.setCase(2,0,"14h-16h");
			gestion.setCase(3,0,"16h-18h");

			//ajout des cours
			gestion.setCase(1,1,"tennis J");
			gestion.setCase(2,1,"tennis P");
			gestion.setCase(3,1,"tennis A");

			gestion.setCase(1,2,"hand P   ");
			gestion.setCase(2,2,"hand A   ");
			gestion.setCase(3,2,"hand J   ");

			gestion.setCase(1,3,"foot A   ");
			gestion.setCase(2,3,"foot J   ");
			gestion.setCase(3,3,"foot P   ");

			gestion.setCase(1,4,"rugby P   ");
			gestion.setCase(2,4,"rugby J   ");
			gestion.setCase(3,4,"rugby A   ");

			gestion.setCase(1,5,"basket J");
			gestion.setCase(2,5,"basket P");
			gestion.setCase(3,5,"basket A");

			gestion.setCase(1,6,"course A");
			gestion.setCase(2,6,"course P");
			gestion.setCase(3,6,"course J");

			Explications.remarqueEDT();
			System.out.println("---------- affichage de l'emploi du temps ----------");
			System.out.println("");
			gestion.afficher();
			System.out.println("");			

			//creation des sports
			Tennis t= new Tennis(2,"lundi","tennis avance",true);
			Handball h= new Handball(6,"mardi","handball junior",true);
			Football f= new Football(11,"mercredi","football debutant","soleil");
			Rugby r= new Rugby(12,"jeudi","rugby debutant","soleil");
			Basket b= new Basket(5,"vendredi","basket junior",false);
			CourseRelais c= new CourseRelais(4,"samedi","course pro","pluie");
			
			//creation de Personnes
			Personne p1= new Personne(18,"Virgile");
			gestion.abonnement(p1);
			Personne p2= new Personne(43,"Beatrice");
			gestion.abonnement(p2);
			Personne p3= new Personne(33,"Julia");
			gestion.abonnement(p3);
			Personne p4= new Personne(21,"Abel");
			gestion.abonnement(p4);
			Personne p5= new Personne(50,"Pauline");
			gestion.abonnement(p5);
			Personne p6= new Personne(19,"Marie");
			gestion.abonnement(p6);
			Personne p7= new Personne(37,"Jacques");
			gestion.abonnement(p7);
			Personne p8= new Personne(46,"Youssef");
			gestion.abonnement(p8);
			Personne p9= new Personne(29,"Lilas");
			gestion.abonnement(p9);
			Personne p10= new Personne(32,"Killyan");
			gestion.abonnement(p10);
			Personne p11= new Personne(61,"Bernard");
			gestion.abonnement(p11);
			Personne p12= new Personne(19,"Eve");
			gestion.abonnement(p12);

			Personne p13= new Personne(p1);
			p13.setNom("Hannah");
			gestion.abonnement(p13);
			Personne p14= new Personne(p2);
			p14.setNom("Albertine");
			gestion.abonnement(p14);
			Personne p15= new Personne(p3);
			p15.setNom("Yanis");
			gestion.abonnement(p15);
			Personne p16= new Personne(p4);
			p16.setNom("Laurene");
			gestion.abonnement(p16);
			Personne p17= new Personne(p5);
			p17.setNom("Lois");
			gestion.abonnement(p17);
			Personne p18= new Personne(p6);
			p18.setNom("Adam");
			gestion.abonnement(p18);
			Personne p19= new Personne(p7);
			p19.setNom("Lise");
			gestion.abonnement(p19);
			Personne p20= new Personne(p8);
			p20.setNom("Jack");
			gestion.abonnement(p20);
			Personne p21= new Personne(p9);
			p21.setNom("Harry");
			gestion.abonnement(p21);
			Personne p22= new Personne(p10);
			p22.setNom("Axelle");
			gestion.abonnement(p22);
			Personne p23= new Personne(p11);
			p23.setNom("Norbert");
			gestion.abonnement(p23);
			Personne p24= new Personne(p12);
			p24.setNom("Clarisse");
			gestion.abonnement(p24);

			System.out.println("---------- creation de nouvelles personnes ----------");
			System.out.println("");

			System.out.println("chiffre d'affaire annuel :"+gestion.chiffreAffaire(adherents)+" euros");
			System.out.println("");

			//Personne en trop
			Personne pSup= new Personne(p1);

			//remarques sur le sport
			Explications.remarqueSport();
			System.out.println("");

			//affectaction des equipes de hand
			h.ajouterEquipe(p1);
			h.ajouterEquipe(p2);
			h.ajouterEquipe(p3);
			h.ajouterEquipe(p4);
			h.ajouterEquipe(p5);
			h.ajouterEquipe(p6);
			h.ajouterEquipe(p7);
			h.ajouterEquipe(p8);
			h.ajouterEquipe(p9);
			h.ajouterEquipe(p10);
			h.ajouterEquipe(p11);
			h.ajouterEquipe(p12);

			//affectation des equipes de tennis
			t.ajouterEquipe(p1);
			t.ajouterEquipe(p2);
			t.ajouterEquipe(p23);
			t.ajouterEquipe(p24);

			//affectation des equipes de basket
			b.ajouterEquipe(p5);
			b.ajouterEquipe(p10);
			b.ajouterEquipe(p20);
			b.ajouterEquipe(p3);
			b.ajouterEquipe(p13);
			b.ajouterEquipe(p23);
			b.ajouterEquipe(p6);
			b.ajouterEquipe(p16);
			b.ajouterEquipe(p15);
			b.ajouterEquipe(p9);

			//affectation des equipes de foot
			f.ajouterEquipe(p23);
			f.ajouterEquipe(p4);
			f.ajouterEquipe(p15);
			f.ajouterEquipe(p22);
			f.ajouterEquipe(p3);
			f.ajouterEquipe(p1);
			f.ajouterEquipe(p20);
			f.ajouterEquipe(p10);
			f.ajouterEquipe(p13);
			f.ajouterEquipe(p1);
			f.ajouterEquipe(p6);
			f.ajouterEquipe(p8);
			f.ajouterEquipe(p19);
			f.ajouterEquipe(p14);
			f.ajouterEquipe(p2);
			f.ajouterEquipe(p5);
			f.ajouterEquipe(p9);
			f.ajouterEquipe(p17);
			f.ajouterEquipe(p21);
			f.ajouterEquipe(p7);
			f.ajouterEquipe(p11);
			f.ajouterEquipe(p12);

			//affectation des equipes de course
			c.ajouterEquipe(p20);
			c.ajouterEquipe(p14);
			c.ajouterEquipe(p2);
			c.ajouterEquipe(p18);
			c.ajouterEquipe(p24);
			c.ajouterEquipe(p3);
			c.ajouterEquipe(p15);
			c.ajouterEquipe(p9);

			//affectation des equipes de rugby
			r.ajouterEquipe(p1);
			r.ajouterEquipe(p2);
			r.ajouterEquipe(p3);
			r.ajouterEquipe(p4);
			r.ajouterEquipe(p5);
			r.ajouterEquipe(p6);
			r.ajouterEquipe(p7);
			r.ajouterEquipe(p8);
			r.ajouterEquipe(p9);
			r.ajouterEquipe(p10);
			r.ajouterEquipe(p11);
			r.ajouterEquipe(p12);
			r.ajouterEquipe(p13);
			r.ajouterEquipe(p14);
			r.ajouterEquipe(p15);
			r.ajouterEquipe(p16);
			r.ajouterEquipe(p17);
			r.ajouterEquipe(p18);
			r.ajouterEquipe(p19);
			r.ajouterEquipe(p20);
			r.ajouterEquipe(p21);
			r.ajouterEquipe(p22);
			r.ajouterEquipe(p23);
			r.ajouterEquipe(p24);

			//affichage des equipes de hand
			System.out.println("---------- affichage des equipes de hand ----------");
			System.out.println("");
			System.out.println(h.getNom()+" Equipe 1 :");
			h.afficheEquipe(h.getEquipe1());
			System.out.println("");
			System.out.println(h.getNom()+" Equipe 2 :");
			h.afficheEquipe(h.getEquipe2());
			System.out.println("");

			//affichage des equipes de tennis
			System.out.println("---------- affichage des equipes de tennis ----------");
			System.out.println("");
			System.out.println(t.getNom()+" Equipe 1 :");
			t.afficheEquipe(t.getEquipe1());
			System.out.println("");
			System.out.println(t.getNom()+" Equipe 2 :");
			t.afficheEquipe(t.getEquipe2());
			System.out.println("");

			//affichage des equipes de basket
			System.out.println("---------- affichage des equipes de basket ----------");
			System.out.println("");
			System.out.println(b.getNom()+" Equipe 1 :");
			b.afficheEquipe(b.getEquipe1());
			System.out.println("");
			System.out.println(b.getNom()+" Equipe 2 :");
			b.afficheEquipe(b.getEquipe2());
			System.out.println("");

			//affichage des equipes de rugby
			System.out.println("---------- affichage des equipes de rugby ----------");
			System.out.println("");
			System.out.println(r.getNom()+" Equipe 1 :");
			r.afficheEquipe(r.getEquipe1());
			System.out.println("");
			System.out.println(r.getNom()+" Equipe 2 :");
			r.afficheEquipe(r.getEquipe2());
			System.out.println("");

			//affichage des equipes de football
			System.out.println("---------- affichage des equipes de foot ----------");
			System.out.println("");
			System.out.println(f.getNom()+" Equipe 1 :");
			f.afficheEquipe(f.getEquipe1());
			System.out.println("");
			System.out.println(f.getNom()+" Equipe 2 :");
			f.afficheEquipe(f.getEquipe2());
			System.out.println("");

			//affichage des equipes de course
			System.out.println("---------- affichage des equipes de course ----------");
			System.out.println("");
			System.out.println(c.getNom()+" Equipe 1 :");
			c.afficheEquipe(c.getEquipe1());
			System.out.println("");
			System.out.println(c.getNom()+" Equipe 2 :");
			c.afficheEquipe(c.getEquipe2());
			System.out.println("");

			//test d'ajout de la personne supplementaire
			System.out.println("---------- test d'ajout d'une personne en trop ----------");
			System.out.println("");
			h.ajouterEquipe(pSup);
			t.ajouterEquipe(pSup);
			b.ajouterEquipe(pSup);
			r.ajouterEquipe(pSup);
			f.ajouterEquipe(pSup);
			c.ajouterEquipe(pSup);

			System.out.println("---------- matchs de sport ----------");
			System.out.println("");

			//1er match entre les deux equipes de hand
			System.out.println(h.match(h.getEquipe1(),h.getEquipe2()));

			//1er match entre les deux equipes de tennis
			System.out.println(t.match(t.getEquipe1(),t.getEquipe2()));

			//1er match entre les deux equipes de basket
			System.out.println(b.match(b.getEquipe1(),b.getEquipe2()));
			b.libereSalle();
			System.out.println("Apres liberation de la salle :");
			System.out.println(b.match(b.getEquipe1(),b.getEquipe2()));
			System.out.println("");

			//1er match entre les deux equipes de foot
			System.out.println("Vetements a prevoir pour le foot :");
			f.vetements(f.getMeteo());
			System.out.println(f.match(f.getEquipe1(),f.getEquipe2()));
			System.out.println("");

			//1er match entre les deux equipes de rugby
			System.out.println("Vetements a prevoir pour le rugby :");
			r.vetements(r.getMeteo());
			System.out.println(r.match(r.getEquipe1(),r.getEquipe2()));
			System.out.println("");

			//1er match entre les deux equipes de course
			System.out.println("Vetements a prevoir pour la course :");
			c.vetements(c.getMeteo());
			System.out.println(c.match(c.getEquipe1(),c.getEquipe2()));
			System.out.println("");

			System.out.println("---------- modification de l'emploi du temps ----------");
			System.out.println("");

			//suppression d'un cours
			gestion.videCase(2,3);
			System.out.println("Le cours de Football Junior a ete supprime");

			gestion.afficher();
			System.out.println("");

			//echance de deux cours
			String temp=gestion.getCase(3,5);
			gestion.setCase(3,5,gestion.getCase(1,5));
			gestion.setCase(1,5,temp);

			System.out.println("Les cours de basket avance et basket junior ont ete echanges");
			gestion.afficher();
			System.out.println("");
			System.out.println("");

			System.out.println("---------- modification de la liste d'adherents ----------");
			System.out.println("");

			//nouvel affichage de la liste d'adhérents
			gestion.afficheAdherent();
			System.out.println("Chiffre d'affaire du club :"+gestion.chiffreAffaire(adherents)+"euros");
			gestion.desabonnement(p10);
			System.out.println("");
			System.out.println("Chiffre d'affaire du club :"+gestion.chiffreAffaire(adherents)+"euros");

			System.out.println("---------- vieillissement d'une ou plusieurs personnes et affichage de leur nouvel age ----------");
			System.out.println("");
			p16.vieillir();
			p3.vieillir();
			p21.vieillir();
			System.out.println(p16.getNom()+" a maintenant "+p16.getAge()+" ans");
			System.out.println(p3.getNom()+" a maintenant "+p3.getAge()+" ans");
			System.out.println(p21.getNom()+" a maintenant "+p21.getAge()+" ans");
			System.out.println("---------- affichage du nouveau chiffre d'Affaire ----------");
			System.out.println("");
			System.out.println("Chiffre d'affaire du club :"+gestion.chiffreAffaire(adherents)+"euros");
			System.out.println("");

			System.out.println("----------ajout d'un enfant dans le club et affichage du tarif total de sa famille----------");
			System.out.println("");
			Enfant enfant = new Personne(10,"Henri");
			System.out.println(" Nouvel enfant :"+enfant.getNom()+"\tTarif Annuel : "+enfant.tarifAnnuel(enfant.getAge())+" euros");
			System.out.println(" Adulte responsable :"+p8.getNom()+"\tTarif Annuel : "+p8.tarifAnnuel(p8.getAge())+" euros");
			System.out.println("");
			gestion.abonnement((Personne)enfant);
			System.out.println("tarif de "+enfant.getNom()+" et "+p8.getNom()+" : "+p8.famille(enfant)+" euros");
			System.out.println("");
			System.out.println("Chiffre d'affaire du club :"+gestion.chiffreAffaire(adherents)+"euros");
			System.out.println("");


		}catch(ErrAge e){
			e.printStackTrace();
		}catch(ErrEquipe e){
			e.printStackTrace();
		}

		//test des exceptions
		System.out.println("----------Test des exceptions----------");
		try{
			Personne normale = new Personne(17,"Louis");
			Personne exception = new Personne(0,"Billy");
			Personne normale2 = new Personne(normale);
			Tennis tennisErreur = new Tennis(2,"lundi","tennis pro",false);
			tennisErreur.match(tennisErreur.getEquipe1(),tennisErreur.getEquipe2());
		}catch(ErrAge e){
			e.printStackTrace();
			System.out.println("");
		}catch(ErrEquipe e){
			e.printStackTrace();
			System.out.println("");
		}
		finally{
			System.out.println("");
			System.out.println("     ====== Fin de la simulation ======     ");
			System.out.println("");
		}
	}
}