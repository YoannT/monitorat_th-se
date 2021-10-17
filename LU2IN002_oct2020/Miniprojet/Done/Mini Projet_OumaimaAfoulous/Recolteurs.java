public class Recolteurs {	 
		private int poslignes;
		private int poscolonnes;
		public double x;
		public double y;
		public double xnew;
		public double ynew;
		
		 
		          public Recolteurs(int poslignes ,int poscolonnes, double x, double y , double xnew, double ynew) {
		        	     this.poslignes=poslignes;
		        	     this.poscolonnes=poscolonnes;	        	     
		        	     this.x=x;
		        	     this.y=y;
		                 this.xnew=xnew;
		        	     this.ynew=ynew;
		        	     
		        	     
		        	     
		          }
		          
		          public double getX() {
		        	     return x;
		          }	     
		        	     
		          public double getY() {
		        	     return y;
		        	     
		          }
		          
		           public double distance(x,y)
		                 x=(int)(Math.random()*(Terrain.NBLIGNESMAX));
		                 y=(int)(Math.random()*(Terrain.NBCOLONNESMAX));
		        	       return Math.sqrt((x-this.getX())+(y-this.getY()));
	               }      
		          
		          public double seDeplacer(xnew,ynew) {
		        	     xnew = xnew+1;
		        	     ynew = ynew+1;
		        	     
		          }
		          
  }