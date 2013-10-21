/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Plus class, plus lChild and rChild
*/

	public class Plus extends Binop { 
	    public Plus(){
	    }
		public Plus(Node l, Node r){
	        super(l, r);
	    }
		
	    public double eval(double[] data){
	    	return lChild.eval(data) + rChild.eval(data);
	    }
	    public String toString(){
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("("+lChild.toString());
	    	sb.append(" + ");
	    	sb.append(rChild.toString()+")");
	    	return sb.toString();
	    }
	}
