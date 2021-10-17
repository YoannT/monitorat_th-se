import java.util.ArrayList;

class ArraySplit{
	public static <T> ArrayList<T> split(ArrayList<T> list,int fin){//fin exclue
		return new ArrayList<T>(list.subList(0,fin));
	}
	
	public static <T> ArrayList<T> split(ArrayList<T> list,int debut, int fin){
		return  new ArrayList<T>(list.subList(debut,fin));
	}
}
