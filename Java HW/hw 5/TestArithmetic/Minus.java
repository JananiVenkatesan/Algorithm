/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Minus class, lChild minus rChild
*/

	public class Minus extends Binop{
		public Minus(){
	    }
		public Minus(Node l, Node r){
	        super(l, r);
	    }
		
	    public double eval(double[] data){
	    	return lChild.eval(data) - rChild.eval(data);
	    }
	    public String toString(){
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("("+lChild.toString());
	    	sb.append(" - ");
	    	sb.append(rChild.toString()+")");
	    	return sb.toString();
	    }
	}
