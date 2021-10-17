def accepte(auto, mot, etat_actuel):
	S = auto.succelem(etat_actuel, mot[0])

	for j in S:
		if (j in auto.GetListFinalStates()) and (len(mot)==1): (ou 0)
			return True
		return auto.accepte(auto, mot, j)

	return False