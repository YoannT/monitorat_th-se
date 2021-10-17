import java.lang.Character;

class verifString{
	public static boolean estVille(String p){
		if(p==null || p.equals("")){
			return false;
		}
		for(int i=0;i<p.length();i++){
			if(!Character.isLetter(p.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public static boolean estDate(String p){
		if(p==null || p.length()!=10){
			return false;
		}
		if(p.charAt(2)!='/' || p.charAt(5)!='/' ){
			return false;
		}
		for(int i=0;i<p.length() && (i!=2 && i!=5);i++){
			if(!Character.isDigit(p.charAt(i))){
				return false;
			}
		}
		return true;
	}
		
	
}
