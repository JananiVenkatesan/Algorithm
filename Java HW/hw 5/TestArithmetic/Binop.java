/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Binop class, superclass of Plus, Minus, Mult, and Divide
*/
	public class Binop extends Node{
		public Binop(){
	    	super();
	    }
	    public Binop(Node l, Node r){
	    	lChild = l; 
	    	rChild = r;
	    }
	}
