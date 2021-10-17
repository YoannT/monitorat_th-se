# -*- coding: utf-8 -*-
from transition import Transition
from state import State
import os
import copy
import sp
from sp import *
from parser import Parser
from itertools import product
from automateBase import AutomateBase

""" SUPPRIMER CONTNENU FONCTIONS AVANT DE DONNER AUX ETUDIANTS"""

class Automate(AutomateBase):

    """Définition d'une fonction retournant la liste des états accessibles 
       à partir d'un état par l'étiquette lettre
    """

    def succ1 (self, state, lettre):  
        #print "DEBUT succ1"
        successeurs = []
        for t in self.getListTransitionsFrom (state) :
            if t.etiquette == lettre and t.stateDest not in successeurs:
                successeurs.append(t.stateDest)
        return successeurs

    """idem a partir d'une liste d'etats 
    """
    def succ (self, listStates, lettre):  
        #print "DEBUT succ"
        successeurs = []
        for s in listStates :
            for t in self.getListTransitionsFrom (s) :
                if t.etiquette == lettre:
                    if t.stateDest not in successeurs :
                        successeurs.append(t.stateDest)
        
        #print "FIN succ"
        return successeurs

    """ calcul des etats accessibles
    """
    def acc (self):  
        alpha = self.getAlphabetFromTransitions()
        acc=self.getListInitialStates()
        #ajout a accPost des successeurs de acc
        while True:
            accPost = acc
            for lettre in alpha :
                succLettre = self.succ(acc,lettre)
                for s in succLettre :
                    if s not in accPost :
                        accPost.append(s)
            if accPost == acc :
                break
            else :
                acc= accPost
        return acc

    """ Définition d'une fonction déterminant si un mot est accepté par un automate.
        Exemple :
            a=Automate.creationAutomate("monAutomate.txt")
            if Automate.accepte(a,"abc"):
                print "L'automate accepte le mot abc"
            else:
                print "L'automate n'accepte pas le mot abc"
    """    
    @staticmethod
    def accepte(auto,mot) :
        #Récupération des états initiaux de l'automate
        liste = auto.getListInitialStates()
        fin = auto.getListFinalStates()
        #Parcours du mot et calcul des différents ensembles d'états visités
        for a in mot :
            liste = auto.succ(liste,a)
        
        #Teste si un état est final
        for state in liste:
            if state in fin:
                return True

        return False

    """retourne true si le langage de l'automate est vide
    """
    @staticmethod
    def accepteVide(auto) :
        accessibles=auto.acc()
        fin = auto.getListFinalStates()
        for s in accessibles :
            if s in fin :
                return False
        return True     
        
    @staticmethod
    def estComplet(auto,alphabet) :
        for s in auto.listStates :
            for a in alphabet :
                trouve = False
                for t in auto.getListTransitionsFrom(s) :
                    if t.etiquette == a :
                        trouve = True
                        break
                if not trouve :
                    return False
        return True
        
        
    @staticmethod
    def estDeterministe(auto) :
        if len(auto.getListInitialStates())>1:
            return False
        for s in auto.listStates : 
            lettres = []
            for t in auto.getListTransitionsFrom(s):
                if t.etiquette in lettres :
                    return False
                else :
                    lettres.append(t.etiquette)
        return True
    
    
    """ NON TESTE
    """ 
    @staticmethod
    def completeAuto(auto,alphabet) :
        autocomp = copy.deepcopy(auto)
        if Automate.estComplet(auto,alphabet):
            return autocomp

        puits = State(-1, False, False, "puits")
        #Pour le cas ou IL EXSISTE DEJA UN ETAT d'id -1
        while(puits in auto.listStates):
            puits.id = puits.id -1
        autocomp.addState(puits)
        
        for s in autocomp.listStates:
            for a in alphabet :
                trouve = False
                for t in autocomp.getListTransitionsFrom(s):
                    if t.etiquette == a :
                        trouve = True
                        break
                if not trouve :
                    nt = Transition(s,a,puits)
                    autocomp.addTransition(nt)
        return autocomp

    """produit cartesien de deux automates
    Rq : product construit le produit cartesien de deux listes
    """
    @staticmethod
    def produit (a0, a1):
        #Recuperation des etats initiaux
        ini0 = a0.getListInitialStates()
        ini1 = a1.getListInitialStates()
        listTravail = list(product(ini0,ini1))
        listPaires = list(product(ini0,ini1)) 
        listTransPaires= []

        #creation des transitions entre paires
        while listTravail != [] :
            paire = listTravail.pop()
            for t0 in a0.getListTransitionsFrom(paire[0]) :
                for t1 in a1.getListTransitionsFrom(paire[1]) :
                    if t0.etiquette == t1.etiquette :
                        psucc = tuple((t0.stateDest,t1.stateDest))
                    if psucc not in listPaires :
                        listPaires.append(psucc)
                        listTravail.append(psucc)
                        tprod = Transition(paire, t0.etiquette, psucc)
                        listTransPaires.append(tprod)

        listePairesEtatsTrans =[listPaires,listTransPaires]
        return listePairesEtatsTrans
       
    
    """automate acceptant l'intersection des langages
    """
    @staticmethod
    def intersection (a0, a1):
        #Recuperation des deux listes
        listeProduit = Automate.produit(a0,a1)
        listPaires = listeProduit[0]
        listTransPaires = listeProduit[1]

        #Transformation
        listStates = []
        listTrans = []
        for s in listPaires :
            ids = listPaires.index(s)
            labels = "("+ str(s[0].label) + ", " + str(s[1].label) + ")"
            inits = s[0].init and s[1].init
            fins = s[0].fin and s[1].fin
            listStates.append(State(ids, inits, fins, labels))
        for t in listTransPaires :
            src = listStates[listPaires.index(t.stateSrc)]
            dest = listStates[listPaires.index(t.stateDest)]
            etiq = t.etiquette
            listTrans.append(Transition(src,etiq,dest))                    
        
        #a = Automate(listTrans)
        #print a
        return Automate(listTrans)


    """automate acceptant l'union des langages
    """
    @staticmethod
    def union (a0, a1):       
        #recuperation des alphabets et completions
        alpha0 = a0.getAlphabetFromTransitions()
        alpha1 = a1.getAlphabetFromTransitions()
        alpha = alpha0
        for lettre in alpha1:
            if lettre not in alpha:
                alpha.append(lettre)
        a0 = Automate.completeAuto(a0,alpha)
        a1 = Automate.completeAuto(a1,alpha)

        #Recuperation des deux listes
        listeProduit = Automate.produit(a0,a1)
        listPaires = listeProduit[0]
        listTransPaires = listeProduit[1]
 
        #Transformation
        listStates = []
        listTrans = []
        for s in listPaires :
            ids = listPaires.index(s)
            labels = "("+ str(s[0].label) + ", " + str(s[1].label) + ")"
            inits = s[0].init and s[1].init
            fins = s[0].fin or s[1].fin
            listStates.append(State(ids, inits, fins, labels))
        for t in listTransPaires :
            src = listStates[listPaires.index(t.stateSrc)]
            dest = listStates[listPaires.index(t.stateDest)]
            etiq = t.etiquette
            listTrans.append(Transition(src,etiq,dest))                    
        
        #a = Automate(listTrans)
        return Automate(listTrans)  

    
    """automate acceptant l'union non deterministe des langages
    """
    @staticmethod
    def unionND (a1, a2):       
        
        #renommage
        a1.prefixStates("a1")
        a2.prefixStates("a2")

        #recuperation des transitions de a1 et a2 -- copies 
        listTrans = list(a1.listTransitions) + list(a2.listTransitions)
 
        a = Automate(listTrans)
        return Automate(listTrans)                 
        
    
    @staticmethod        
    def determinisation(auto) :
        autodet = copy.deepcopy(auto)
        if Automate.estDeterministe(autodet):
            return autodet
        alphabet = auto.getAlphabetFromTransitions()
        listStates = []
        listTravail = []
        listTransitions=[]
        setCourant = set(auto.getListInitialStates())
        listStates.append(setCourant)
        listTravail.append(setCourant)
        
        while listTravail != [] :
            courant = listTravail.pop()
            indCourant = listStates.index(courant)
            
            for a in alphabet :
                suivant = set(auto.succ(courant, a))
                #transformer suivant en set pour ignorer l'ordre des elements
                if suivant not in listStates :
                    listStates.append(suivant)
                    listTravail.append(suivant)
                    
                indSuivant=listStates.index(suivant)
                #ajouter les labels pour affichage
                label = "{"
                for s in courant:
                    if label != "{":
                        label = label+", "
                    label = label + s.label
                label = label + "}"
                stateCourant = State(indCourant, auto.allInitial(courant), State.isFinalIn(courant), label)
                label = "{"
                for s in suivant:
                    if label != "{":
                        label = label+", "
                    label = label + s.label
                label = label + "}"
                stateSuivant = State(indSuivant, auto.allInitial(suivant), State.isFinalIn(suivant),label) 
                trans = Transition(stateCourant, a, stateSuivant)
                listTransitions.append(trans)

        return Automate(listTransitions)

    @staticmethod
    def determinisation2(auto) :
        """ Automate  -> Automate
        rend l'automate déterminisé d'auto
        """

        if Automate.estDeterministe(auto):
            return auto
        # auto2: Automate
        auto2 = copy.deepcopy(auto)
        # tempList : List[set(State)]
        tempList = []
        # listTous: List[set(States)]
        listTous = [auto2.getListInitialStates()]
        # randomList: List[State]
        randomList = set(auto2.getListInitialStates())
        # listTrans : List[Transition]
        listTrans = []
        sInit = [auto2.getListInitialStates()]
        for j in listTous:
            for i in auto2.getAlphabetFromTransitions():
                # tr: Transition
                if (len(auto2.succ(j, i))) != [] and (auto2.succ(j, i) not in listTous):
                    listTous.append(auto2.succ(j,i))
                # stOld: State
                # stNew: State
                # StIn: Bool
                StIn = False
                # StFi: Bool
                StFi = False
                if j in auto2.getListInitialStates():
                    StIn = True
                if j in auto2.getListFinalStates():
                    stFi = True
                stOld = State(listTous.index(j), StIn, StFi)
                for k in auto2.succ(randomList, i):
                    if k in auto2.getListInitialStates():
                        StIn = True
                    if k in auto2.getListFinalStates():
                        stFi = True
                stNew = State(listTous.index(auto2.succ(j, i)), StIn, StFi)
                tr = Transition(stOld, i, stNew)
                if tr not in listTrans:
                    listTrans.append(tr)
        automateResultat = Automate(listTrans)
        return automateResultat
            
    def allInitial(self, setOfStates) : # ici aussi des sets
        return set(self.getListInitialStates()) == setOfStates

    """automate acceptant le complementaire du langage
    """
    
    @staticmethod
    def complementaire(a):
        b = Automate.determinisation(a)
        listStatesb = b.listStates
        for s in listStatesb:
            if s.fin:
                s.fin = False
            else:
                s.fin = True
        return b

    
    """automate acceptant la concatenation des langages
    """
    @staticmethod
    def concatenation (a1, a2):       

        # test du cas ou le mot vide appartient a L(a2)
        b = Automate.accepte(a2,"")
        #print b

        #renommage a2
        a2.prefixStates(0)

        #Recuperation des etats finals de a1 et initiaux de a2
        listFin1 = a1.getListFinalStates()
        listInit2 = a2.getListInitialStates() 

        #reformatage des etats
        for s in listInit2 :
            s.init = False
        if not b :
            for s in listFin1 :
                s.fin = False

        #recuperation des transitions de a1 et a2 -- copies 
        listTrans = list(a1.listTransitions) + list(a2.listTransitions)

        #ajout des transitions de jonction
        for i2 in listInit2 :
            listeTransJonction = a2.getListTransitionsFrom(i2)
            for t in listeTransJonction :
                etiq = t.etiquette
                dest = t.stateDest
                for f1 in listFin1 :
                    listTrans.append(Transition(f1,etiq,dest)) 

 
        return Automate(listTrans)  

    @staticmethod
    def plus (a):       

        #Recuperation des etats finals et initiaux
        listFin = a.getListFinalStates()
        listInit = a.getListInitialStates() 

        #recuperation des transitions de a -- copie
        listTrans = list(a.listTransitions)


        print(listInit)
        #creation du nouvel automate
        plusa = Automate(listTrans)
        #print a

        #ajout des transitions de jonction
        for i in listInit :
            listeTransJonction = a.getListTransitionsFrom(i)
            for t in listeTransJonction :
                etiq = t.etiquette
                dest = t.stateDest
                for f in listFin :
                    plusa.addTransition(Transition(f,etiq,dest)) 

        return plusa    

    @staticmethod
    def etoile (a):       
        b = Automate.plus(a)
        #print Automate.accepte(a,"")
        if Automate.accepte(a,"") :
            print("Blah")
            return b

        etatMotVide = State(-1, True, True, "mot_vide")
        #Pour le cas ou IL EXSISTE DEJA UN ETAT d'id -1
        while(etatMotVide in b.listStates) :
            etatMotVide.id = etatMotVide.id -1
        b.listStates.append(etatMotVide)


        return b
        

 
        