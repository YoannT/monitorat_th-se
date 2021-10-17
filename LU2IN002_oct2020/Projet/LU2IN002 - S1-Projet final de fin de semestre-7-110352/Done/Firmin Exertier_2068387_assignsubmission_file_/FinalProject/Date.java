abstract class Date{
	public static String getNextDate(String pDate){//il faut que pDate soit bien une date
		if(pDate.substring(0,2).equals("29") && pDate.substring(3,5).equals("02") && Integer.parseInt(pDate.substring(8,10))%4==0){	//29 fevrier annee bissextile
			return "01/03/"+pDate.substring(6,10);
		}if(pDate.substring(0,2).equals("28") && pDate.substring(3,5).equals("02") && Integer.parseInt(pDate.substring(8,10))%4!=0){	//29 fevrier annee normale
			return "01/03/"+pDate.substring(6,10);
		}if(pDate.substring(3,5).equals("12") && pDate.substring(0,2).equals("31")){//changement d'annee
			return "01/01/"+String.valueOf(Integer.parseInt(pDate.substring(6,10))+1);
		}if(pDate.substring(0,2).equals("31") || pDate.substring(0,2).equals("30")){//changement de mois
			if(pDate.substring(0,2).equals("31")){	//31 changement systematique
				if(Integer.parseInt(pDate.substring(3,5))<9){	
					return "01/0"+String.valueOf(Integer.parseInt(pDate.substring(3,5))+1)+"/"+pDate.substring(6,10);	
				}else{
					return "01/"+String.valueOf(Integer.parseInt(pDate.substring(3,5))+1)+"/"+pDate.substring(6,10);	
				}
			}else{//30 plus de test 
				if(( Integer.parseInt(pDate.substring(3,5))<7 ) && (Integer.parseInt(pDate.substring(3,5))%2==0)) {
					return "01/0"+String.valueOf(Integer.parseInt(pDate.substring(3,5))+1)+"/"+pDate.substring(6,10);
				}
				if((Integer.parseInt(pDate.substring(3,5))>8) && (Integer.parseInt(pDate.substring(3,5))%2==1 )){
				
				return "01/"+String.valueOf(Integer.parseInt(pDate.substring(3,5))+1)+"/"+pDate.substring(6,10);
				}
			}
		}
		if(Integer.parseInt(pDate.substring(0,2))<9){
				return "0"+String.valueOf(Integer.parseInt(pDate.substring(0,2))+1)+"/"+pDate.substring(3,5)+"/"+pDate.substring(6,10);
		}	
		return String.valueOf(Integer.parseInt(pDate.substring(0,2))+1)+"/"+pDate.substring(3,5)+"/"+pDate.substring(6,10);		

	}
	
	
	
}
