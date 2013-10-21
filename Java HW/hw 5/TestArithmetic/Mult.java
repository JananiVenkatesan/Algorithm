/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Mult class, multiply lChild by rChild
*/

	public class Mult extends Binop{
		public Mult(){
	    }
		public Mult(Node l, Node r){
	        super(l, r);
	    }
		
	    public double eval(double[] data){
	    	return lChild.eval(data) * rChild.eval(data);
	    }
	    
	    public String toString(){
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("(" + lChild.toString());
	    	sb.append(" * ");
	    	sb.append(rChild.toString() + ")");
	    	return sb.toString();
	    }
	}