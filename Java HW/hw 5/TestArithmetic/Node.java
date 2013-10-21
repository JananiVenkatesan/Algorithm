/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: Node class, super class of Const, Binop, Plus, Minus, Mult, Divide class.
*/


public abstract class Node{ 
	protected Node lChild, rChild;
	
	public Node(){
	}
	
    public void setChild(int position, Node n){
    	if(position == 0)
    		lChild = n;
    	else if(position == 1)
    		rChild = n;
	}
    
	public double eval(double[] data){
		return 0;
	}
	public String toString(){
		return super.toString();
	}
}

