/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Divide class, lChild divide by rChild
*/

public class Divide extends Binop{
	public Divide(){
    }  
	public Divide(Node l, Node r){
        super(l, r);
    }  
	
    public double eval(double[] data){
    	return lChild.eval(data) / rChild.eval(data);
    }
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("(" + lChild.toString());
    	sb.append(" / ");
    	sb.append(rChild.toString() + ")");
    	return sb.toString();
    }
}
