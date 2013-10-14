/*
	Author: Bowen Li
	Andrew ID: bowenl
	
	Description: Node class, super class of Const, Binop, Plus, Minus, Mult, Divide class.
*/


public class Node{
    public Node(){}

    public double eval(){
        System.out.println("Error: eval Node");
        return 0;
    }

    public String toString(){
    	return super.toString();
    }
}