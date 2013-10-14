/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: Binop class, super class of Plus, Minus, Mult, Divide class.
*/


public class Binop extends Node{
    protected Node lChild, rChild;

    public Binop(Node l, Node r){
    	lChild = l; 
    	rChild = r;
    }

    public String toString(){
    	return super.toString();
    }
}
