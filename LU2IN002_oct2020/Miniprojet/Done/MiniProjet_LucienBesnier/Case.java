public class Case{
	private Sanglier s;
	private Chasseur c;
	private Paysan   p;
	private Graine   g;
	private Herbes   h;
	
	public Case(){
		this.s=null;
		this.c=null;
		this.p=null;
		this.g=null;
		this.h=null;
		}
					
	public void ajouterHerbes(Herbes h){
		this.h=h;		
		}
		
	public void ajouterGraine(Graine g){
		this.g=g;
		}
				
	public void ajouterChasseur(Chasseur c){
		this.c=c;
		}
		
	public void ajouterPaysan(Paysan p){
		this.p=p;
		}
				
	public void ajouterSanglier(Sanglier s){
		this.s=s;
		}
	
	public String getType(){
		if(s!=null){
			return s.RepresentationGraph();
			}
		if(c!=null){
			return c.RepresentationGraph();
			}
		if(p!=null){
			return p.RepresentationGraph();
			}
		if(g!=null){
			return g.RepresentationGraph();
			}
		if(h!=null){
			return h.RepresentationGraph();
			}
		return " ";
		}
		
	public Sanglier estSanglier(){
		return(this.getType()=="S")?s:null;
		}
		
	public Paysan estPaysan(){
		return(this.getType()=="P")?p:null;
		}

	public Chasseur estChasseur(){
		return(this.getType()=="C")?c:null;
		}
}

