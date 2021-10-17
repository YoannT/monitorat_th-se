# -*- coding: utf-8 -*-
"""
Code modifiable.
"""

from automate import Automate
from state import State
from transition import Transition
from parser import *

s1 = State(0, True, False,"0")
s2=State(1, False, False,"1")
s3=State(2,False,True,"2")
t1 = Transition(s1,"a",s1)
t2=Transition(s1,"b",s2)
t3=Transition(s2,"a",s3)
t4=Transition(s2,"b",s3)
t5=Transition(s3,"a",s1)
t6=Transition(s3,"b",s2)
t7=Transition(s3,"a",s2)
t8=Transition(s3,"b",s3)
auto=Automate([t1,t2,t3,t4,t5,t6,t7,t8],[s1,s2,s3])

alphabet = auto.getAlphabetFromTransitions()

# auto5=Automate.determinisation(auto4)
# auto5.show("autoDeterministe")

autoEx = Automate.creationAutomate("exempleAutomate0123.txt")

# auto.show("auto4")
det1 = Automate.determinisation(autoEx)
det1.show("det1")
autoEx.show("Ex")

exit()
# det2.show("det2")


# auto6 = Automate.complementaire(auto)
# auto6.show("Complementaire")
# Automate.intersection(auto, autoEx).show("intersection")
# Automate.union(auto, autoEx).show("union")
# Automate.concatenation(auto, autoEx).show("concatenation")

# auto.show("auto4")
# autoEtoile = Automate.etoile(auto)
# autoEtoile.show("etoile")
autoEtoile2 = Automate.etoile(autoEx)
autoEtoile2.show("etoile2")
autoEx.show("AutoEx")