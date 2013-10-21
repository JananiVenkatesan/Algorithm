/*
    Author: Bowen Li
    Andrew ID: bowenl
    
    Description: Variable class, contains index
*/

public class Variable extends Node{
    private int index;  // used for calling data[index]
    
    public Variable(int i){ 
    	index = i; 
    }

    // return data[index]
    public double eval(double[] data){ 
    	return data[index]; 
    }
    public String toString(){
    	return "X" + index;
    }
}
